package com.xiao.soccerproject.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.apigatewayv2.model.transform.ApiJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.xspec.L;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import java.io.*;


/*
* Object Key and Metadata
*
* object = file ; key = file name
* https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html
*
* */

@Service
public class FileService {

    @Autowired
    private Logger logger;

    @Autowired
    private AmazonS3 amazonS3;

    public boolean ifBucketExist(String bucketName){
        return !amazonS3.doesBucketExistV2(bucketName);
    }

    public void createBucket(String bucketName){
        if(!amazonS3.doesBucketExistV2(bucketName)) amazonS3.createBucket(bucketName);
    }

    public void deleteBucket(String bucketName){
        if(amazonS3.doesBucketExistV2(bucketName)) amazonS3.deleteBucket(bucketName);
    }

    public List<Bucket> listBuckets(){
        return amazonS3.listBuckets();
    }

    public String getFileUrl(String bucketName, String fileName){
        LocalDateTime expiration = LocalDateTime.now().plusDays(1);
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName,fileName);
        generatePresignedUrlRequest.withMethod(HttpMethod.GET);
        generatePresignedUrlRequest.withExpiration(Date.from(expiration.toInstant(ZoneOffset.UTC)));

        return amazonS3.generatePresignedUrl(generatePresignedUrlRequest).toString();
    }

    //display text input stream, co-work with getFile method
    public static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println("    " + line);
        }
        System.out.println();
    }


    // save file, save file to local
    public boolean saveFile(MultipartFile multipartFile, String filePath){
        boolean isSuccess = false;
        try{
            File directory = new File(filePath);
            if(!directory.exists()) directory.mkdir();
            Path filepath = Paths.get(filePath, multipartFile.getOriginalFilename());
            multipartFile.transferTo(filepath);
            isSuccess = true;
            logger.info(String.format("This file %s is saved in the folder %s", multipartFile.getOriginalFilename(),filePath));
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return isSuccess;
    }

    //upload file method
    public String uploadFile(String bucketName, MultipartFile file) throws IOException {
        try {
            if (amazonS3.doesObjectExist(bucketName, file.getOriginalFilename())) {
                logger.info(String.format("The file '%s' exists in the bucket %s", file.getOriginalFilename(), bucketName));
                return null;
            }
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());
            amazonS3.putObject(bucketName, file.getOriginalFilename(), file.getInputStream(), objectMetadata);
            logger.info(String.format("The file name=%s, size=%d was uploaded to bucket %s", file.getOriginalFilename(), file.getSize(), bucketName));
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
        return getFileUrl(bucketName, file.getOriginalFilename());
    }


    // get file method, display the content of the file
    // https://docs.aws.amazon.com/AmazonS3/latest/dev/RetrievingObjectUsingJava.html
    public void getFile(String bucketName, MultipartFile file) throws IOException {
        S3Object downloadedFile = null;
        try {
            if (!amazonS3.doesObjectExist(bucketName, file.getOriginalFilename())) {
                logger.info(String.format("The file '%s' does not exists in the bucket %s", file.getOriginalFilename(), bucketName));
            }

            // get a file and print its contents
            System.out.println("Downloading an object");
            downloadedFile = amazonS3.getObject(new GetObjectRequest(bucketName, file.getOriginalFilename()));
            System.out.println("Content-Type:\n" + downloadedFile.getObjectMetadata().getContentType());
            System.out.println("Content:\n");
//            display???
            displayTextInputStream(downloadedFile.getObjectContent());
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        } finally {
            // To ensure that the network connection doesn't remain open, close any open input streams.
            if (downloadedFile != null) {
                downloadedFile.close();
            }
        }
    }

    // list files method
    // https://docs.aws.amazon.com/AmazonS3/latest/dev/ListingObjectKeysUsingJava.html
    public void listFile(String bucketName) throws IOException {
        try{
            System.out.println("Listing objects");
            ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(bucketName).withMaxKeys(2);
            ListObjectsV2Result result;

            do {
                result = amazonS3.listObjectsV2(req);

                for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
                    System.out.printf(" - %s (size: %d)\n", objectSummary.getKey(), objectSummary.getSize());
                }
                // If there are more than maxKeys keys in the bucket, get a continuation token
                // and list the next objects.
                String token = result.getNextContinuationToken();
                System.out.println("Next Continuation Token: " + token);
                req.setContinuationToken(token);
            } while (result.isTruncated());
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }


    // delete file method
    // https://docs.aws.amazon.com/AmazonS3/latest/dev/DeletingOneObjectUsingJava.html
    public void deleteFile(String bucketName, MultipartFile file) throws IOException {
        try {
            if (!amazonS3.doesObjectExist(bucketName, file.getOriginalFilename())) {
                logger.info(String.format("The file '%s' does not exists in the bucket %s", file.getOriginalFilename(), bucketName));
            }

            amazonS3.deleteObject(new DeleteObjectRequest(bucketName,file.getOriginalFilename()));
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }

}
