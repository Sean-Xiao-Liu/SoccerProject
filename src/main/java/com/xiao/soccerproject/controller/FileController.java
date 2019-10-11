package com.xiao.soccerproject.controller;

import com.xiao.soccerproject.service.FileService;
import com.xiao.soccerproject.service.MessageService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/files")
public class FileController {
    private static final String queueName = "soccer-project-queue";
    private static final String fileDownloadDir = "/Users/xiaoliu/IdeaProjects/SoccerProject";
    @Autowired
    private Logger logger;
    @Autowired
    private FileService fileService;
    @Autowired
    private MessageService messageService;

    //create a new bucket in s3
    @RequestMapping(value = "/createBucket/{bucketName}", method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createBucket(@PathVariable String bucketName){
        String message = "The bucket already Exist";
        if(fileService.ifBucketExist(bucketName)){
            try{
                fileService.createBucket(bucketName);
                message = "The bucket has been created successful";
            }catch (Exception e){
                message = "Failed to create the bucket";
                e.printStackTrace();
            }
        }
        logger.info(message);
        return message;
    }

    //upload file to certain bucket
    @RequestMapping(value = "/uploadFile/{bucketName}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@PathVariable String bucketName, @RequestParam("file") MultipartFile file) {
        String msg = String.format("The file name=%s, size=%d could not be uploaded.", file.getOriginalFilename(), file.getSize());
        ResponseEntity responseEntity = ResponseEntity.status(HttpServletResponse.SC_NOT_ACCEPTABLE).body(msg);
        try {
            String path = System.getProperty("user.dir") + File.separator + "temp";// save the file which needs to be uploaded to a local path called temp
            fileService.saveFile(file, path);
            String url = fileService.uploadFile(bucketName, file);
            if (url != null) {
                msg = String.format("The file name=%s, size=%d was uploaded, url=%s", file.getOriginalFilename(), file.getSize(), url);
                messageService.sendMessage(queueName, url);
                responseEntity = ResponseEntity.status(HttpServletResponse.SC_OK).body(msg);
            }
            logger.info(msg);
        }
        catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpServletResponse.SC_NOT_ACCEPTABLE).body(e.getMessage());
            logger.error(e.getMessage());
        }
        return responseEntity;
    }

    //upload multiple files to given bucket
    @RequestMapping(value = "/uploadMultipleFile/{bucketName}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadMultipleFiles(@PathVariable String bucketName, @RequestParam("file") MultipartFile[] files){
        String msg = "no content";
        ResponseEntity responseEntity = ResponseEntity.status(HttpServletResponse.SC_NO_CONTENT).body(msg);
       for(int i = 0; i < files.length ;i++) {
           msg = String.format("The file name=%s, size=%d could not be uploaded.", files[i].getOriginalFilename(), files[i].getSize());
           responseEntity = ResponseEntity.status(HttpServletResponse.SC_NOT_ACCEPTABLE).body(msg);
           try {
               String path = System.getProperty("user.dir") + File.separator + "temp";// save the file which needs to be uploaded to a local path called temp
               fileService.saveFile(files[i], path);
               String url = fileService.uploadFile(bucketName, files[i]);
               if (url != null) {
                   msg = String.format("The file name=%s, size=%d was uploaded, url=%s", files[i].getOriginalFilename(), files[i].getSize(), url);
                   messageService.sendMessage(queueName, url);
                   responseEntity = ResponseEntity.status(HttpServletResponse.SC_OK).body(msg);
               }
               logger.info(msg);
           } catch (Exception e) {
               responseEntity = ResponseEntity.status(HttpServletResponse.SC_NOT_ACCEPTABLE).body(e.getMessage());
               logger.error(e.getMessage());
           }
       }
        return responseEntity;
    }



    @RequestMapping(value = "/downloadFile/{fileName}", method = RequestMethod.GET, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = null;
        String msg = "The file doesn't exist.";
        ResponseEntity responseEntity;
        try {
            Path filePath = Paths.get(fileDownloadDir).toAbsolutePath().resolve(fileName).normalize();
            resource = new UrlResource(filePath.toUri());
            if(!resource.exists()) return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(msg);
            responseEntity = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);;
            msg = String.format("The file %s was downloaded", resource.getFilename());
            //Send message to SQS
            messageService.sendMessage(queueName, msg);
            logger.debug(msg);
        }
        catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(ex.getMessage());
            logger.debug(ex.getMessage());
        }
        return responseEntity;
    }


    // delete a file from the bucket
    //https://springbootdev.com/2018/08/02/upload-and-delete-files-with-amazon-s3-and-spring-boot/

//    @RequestMapping(value = "/deleteFile/{bucketName}", method = RequestMethod.DELETE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity deleteFile(@PathVariable String bucketName,@RequestParam("file") MultipartFile file){
//        String msg = String.format("the file %s doesn't exist in the bucket %s", file.getOriginalFilename(),bucketName);
//        ResponseEntity responseEntity = ResponseEntity.status(HttpServletResponse.SC_NO_CONTENT).body(msg);
//        try{
//
//        }
//    }
}

