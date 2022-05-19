package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.product.config.MinioProperties;
import com.atguigu.gmall.product.service.OSSService;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OSSServiceImpl implements OSSService {

    @Autowired
    MinioClient minioClient;

    @Autowired
    MinioProperties minioProperties;

    @Override
    public String fileUpload(MultipartFile file) throws Exception {


        InputStream stream = file.getInputStream();
        String filename = UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
        PutObjectOptions options = new PutObjectOptions(stream.available(), -1);

        String contentType = file.getContentType();
        options.setContentType(contentType);

        minioClient.putObject(minioProperties.getBucket(), filename, stream, options);

        //文件访问路径
        String path = minioClient.getObjectUrl(minioProperties.getBucket(), filename);
        return path;
    }
}
