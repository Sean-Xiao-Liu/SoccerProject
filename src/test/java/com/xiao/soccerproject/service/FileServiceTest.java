package com.xiao.soccerproject.service;

import com.amazonaws.services.s3.model.Bucket;
import com.xiao.soccerproject.init.AppInitializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInitializer.class)

public class FileServiceTest {
    @Autowired
    private Logger logger;

    @Autowired
    private FileService fileService;

//    @Before
//    public void init() throws FileNotFoundException , MalformedParameterizedTypeException {
////        fileService.createBucket("com.xiao.soccerproject.test");// has to use global unique bucket name
//        logger.info(">>>>>>>>>>>>>>>>>>>test start<<<<<<<<<<<<<<<<<");
//        File file = new File("/Users/xiaoliu/IdeaProjects/SoccerProject/fileServiceTest.txt");
//        FileInputStream input = new FileInputStream(file);
//    }
//
//    @After
//    public void cleanup(){
////        fileService.deleteBucket("com.xiao.soccerproject.test");
//        logger.info(">>>>>>>>>>>>>>>>>>>test end<<<<<<<<<<<<<<<<<");
//    }

    @Test
    @Transactional
    public void listBucketTest(){
        List<Bucket> buckets = fileService.listBuckets();
        for(Bucket bucket : buckets){
            System.out.println(bucket);
        }
        assertEquals(1,buckets.size());
    }
}
