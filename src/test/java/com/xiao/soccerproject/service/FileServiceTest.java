package com.xiao.soccerproject.service;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.util.IOUtils;
import com.xiao.soccerproject.init.AppInitializer;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class FileServiceTest {
    @Autowired
    private Logger logger;

    @Autowired
    private FileService fileService;

    private String bucketName = "com.xiao.soccerproject";
    private String fileName = "fileServiceTest.txt";
    private URL fakeFileUrl;
    private MultipartFile multipartFile;
    private String path;

    @Before
    public void init() throws IOException, MalformedParameterizedTypeException, FileNotFoundException{
//        fileService.createBucket("com.xiao.soccerproject.test");// has to use global unique bucket name
        logger.info(">>>>>>>>>>>>>>>>>>>test start<<<<<<<<<<<<<<<<<");
        fakeFileUrl = new URL("http://www.fakeQueueUrl.com/xiao/soccerproject/fake");
//        File file = new File("/Users/xiaoliu/IdeaProjects/SoccerProject/uploadFileTest.txt");
//        File file = new File("/Users/xiaoliu/IdeaProjects/SoccerProject/fileServiceTest.txt");
        File file = new File("../SoccerProject/fileServiceTest.txt");// use relative
        FileInputStream input = new FileInputStream(file);
        multipartFile = new MockMultipartFile("file", file.getName(), "text/plain" , IOUtils.toByteArray(input));
        path = System.getProperty("user.dir") + File.separator + "temp";
    }

    @After
    public void cleanup(){
//        fileService.deleteBucket("com.xiao.soccerproject.test");
        logger.info(">>>>>>>>>>>>>>>>>>>test end<<<<<<<<<<<<<<<<<");
    }

    @Test
    public void listBucketTest(){
        List<Bucket> buckets = fileService.listBuckets();
        for(Bucket bucket : buckets){
            System.out.println(bucket);
        }
        assertEquals(1,buckets.size());
    }

    @Ignore
    @Test
    public void uploadFileTest() throws IOException{
        String fileUrl = fileService.uploadFile(bucketName, multipartFile);
        Assert.assertNotNull(fileUrl);
    }

    @Test
    public void listFileTest() throws IOException{
       fileService.listFile(bucketName);
    }

    @Test
    public void deleteFileTest() throws IOException{
        fileService.deleteFile(bucketName,multipartFile);
    }

    @Test
    public void saveFileTest() throws IOException{
        String savePath = "/Users/xiaoliu/Documents/Miso";
        fileService.saveFile(multipartFile,savePath);
    }

    @Test
    public void getFileTest() throws IOException{
        fileService.getFile(bucketName,multipartFile);
    }

}
