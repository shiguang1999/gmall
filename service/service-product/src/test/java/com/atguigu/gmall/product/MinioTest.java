package com.atguigu.gmall.product;


import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.MinioException;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

public class MinioTest {


    @Test
    public void upload() throws Exception {
        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://192.168.189.130:9000", "admin", "admin123456");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("gmall");
            if (isExist) {
                System.out.println("Bucket 已经创建");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("gmall2");
            }
            // 使用putObject上传一个文件到存储桶中。
            //String bucketName,桶名
            // String objectName,//文件名
            // InputStream stream,//文件流
            // PutObjectOptions options//上传参数的设置项

            FileInputStream stream = new FileInputStream("C:\\Users\\shiguang\\Desktop\\pic\\aa.png");
            PutObjectOptions options = new PutObjectOptions(stream.available(), -1);
            minioClient.putObject("gmall","aa.png",stream,options);
            System.out.println("上传成功");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
