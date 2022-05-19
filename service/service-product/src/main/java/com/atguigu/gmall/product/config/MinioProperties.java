package com.atguigu.gmall.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.minio")
@Data
public class MinioProperties {

//    @Value("${endpoint}")
    String endpoint;

//    @Value("${accessKey}")
    String accessKey;

//    @Value("${secretKey}")
    String secretKey;

    String bucket;
}
