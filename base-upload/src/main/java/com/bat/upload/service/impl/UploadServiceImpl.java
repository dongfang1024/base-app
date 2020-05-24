package com.bat.upload.service.impl;

import com.bat.upload.service.UploadService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpeg", "image/gif");

    @Autowired
    private FastFileStorageClient storageClient;

    public String uploadImage(MultipartFile file){
        //1、check file type
        String originalFileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        if(!CONTENT_TYPES.contains(contentType)){
            log.info("File type is incorrect : {}.", originalFileName);
            return null;
        }
        //2、check file content
        try {
            BufferedImage read = ImageIO.read(file.getInputStream());
            //3、保存到服务器
            //file.transferTo(new File("D:\\Resources\\img\\leyou-develop\\"+originalFileName));
            String extName = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            if(StringUtils.isBlank(extName)) throw new IOException();
            StorePath url = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), extName, null);
            String resultUrl= "http://image.leyou.com/"+url.getFullPath();
            log.info("File<{}> has been uploaded successfully. Image url: {}", originalFileName,  resultUrl);
            return resultUrl;
        } catch (IOException e) {
            log.info("Server Internal Error: {}", originalFileName);
            e.printStackTrace();
            return null;
        }
    }

}
