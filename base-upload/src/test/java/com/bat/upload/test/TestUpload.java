package com.bat.upload.test;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUpload {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;


    @Test
    public void test02() throws FileNotFoundException {
        File file = new File("D:\\Resources\\img\\animal\\elephant.jpg");
        StorePath storePath = this.storageClient.uploadFile(new FileInputStream(file), file.length(), "jpg", null);
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());
    }

    @Test
    public void test01() throws Exception{
        //MultipartFile file01 = new MultipartFile("");
        File file  = new File("D:\\Resources\\img\\animal\\dolphin.jpg");
        StorePath jpg = this.storageClient.uploadImageAndCrtThumbImage(new FileInputStream(file), file.length(), "jpg", null);
        System.out.println("full path: "+jpg.getFullPath());
        System.out.println("path: "+ jpg.getPath());
        String thumbImagePath = thumbImageConfig.getThumbImagePath(jpg.getPath());
        System.out.println(thumbImagePath);
    }

}
