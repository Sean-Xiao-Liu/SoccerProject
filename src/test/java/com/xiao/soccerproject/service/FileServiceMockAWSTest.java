//package com.xiao.soccerproject.service;
//
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.util.IOUtils;
//import com.xiao.soccerproject.init.AppInitializer;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.*;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.lang.reflect.MalformedParameterizedTypeException;
//import java.net.URL;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//// mock testing focus on behavior verification
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppInitializer.class)
//public class FileServiceMockAWSTest {
//    @Mock(answer = Answers.RETURNS_DEEP_STUBS) private AmazonS3 amazonS3;
//    @Autowired @Spy private Logger logger;
//    @InjectMocks private FileService fileService;
//
//    private String bucketName = "com.xiao.soccerproject";
//    private String fileName = "fileServiceTest.txt";
//    private URL fakeFileUrl;
//    private MultipartFile multipartFile;
//    private String path;
//
//    @Before
//    public void init() throws IOException, MalformedParameterizedTypeException, FileNotFoundException {
//        logger.info(">>>>>>>>>>>>>>>>>>>test start<<<<<<<<<<<<<<<<<");
//
//        //Initialize Mockito
//        MockitoAnnotations.initMocks(this);
//
//        fakeFileUrl = new URL("http://www.fakeQueueUrl.com/xiao/soccerproject/fake");
//        File file = new File("/Users/xiaoliu/IdeaProjects/SoccerProject/uploadFileTest.txt");
//        FileInputStream input = new FileInputStream(file);
//        multipartFile = new MockMultipartFile("file", file.getName(), "text/plain" , IOUtils.toByteArray(input));
//        path = System.getProperty("user.dir") + File.separator + "temp";
//
//        //stubbing for the method doesObjectExist and generatePresignedUrl
//        when(amazonS3.doesObjectExist(anyString(),anyString())).thenReturn(false);
//        when(amazonS3.generatePresignedUrl(any())).thenReturn(fakeFileUrl);
//
//    }
//
//    @After
//    public void cleanup(){
////        fileService.deleteBucket("com.xiao.soccerproject.test");
//        logger.info(">>>>>>>>>>>>>>>>>>>test end<<<<<<<<<<<<<<<<<");
//    }
//
//    @Test
//    public void uploadFileTest(){
//        fileService.uploadFile(bucketName,multipartFile);
//        verify()
//    }
//
//
//}
