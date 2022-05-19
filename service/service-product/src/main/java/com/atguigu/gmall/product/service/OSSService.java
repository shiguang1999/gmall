package com.atguigu.gmall.product.service;

import org.springframework.web.multipart.MultipartFile;

public interface OSSService {
    /**
     * 上传前端返回的文件到Minio,并返回路径
     * @param file
     * @return
     */
    String fileUpload(MultipartFile file) throws Exception;
}
