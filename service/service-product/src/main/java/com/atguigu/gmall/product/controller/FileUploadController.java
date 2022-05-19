package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/product")
@RestController
public class FileUploadController {

    @PostMapping("/fileUpload")
    public Result fileUpload(FileUpload fileUpload) {


        return Result.ok();
    }
}
