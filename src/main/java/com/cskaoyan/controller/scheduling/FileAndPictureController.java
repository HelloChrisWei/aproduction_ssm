package com.cskaoyan.controller.scheduling;

import com.cskaoyan.pojo.ResponseStatus;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileAndPictureController {

    @RequestMapping("/file/upload")
    @ResponseBody
    public ResponseStatus fileUpload(MultipartFile file, HttpServletRequest request) {
        String filename = file.getOriginalFilename();
        String contextPath = request.getContextPath();

        filename = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "_" + filename;

        String realPath = request.getServletContext().getRealPath("/WEB-INF/file/");

        File uploadFile = new File(realPath + filename);
        // 如果文件夹不存在，创建
        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdirs();
        }
        // 传入文件
        try {
            file.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置状态吗
        ResponseStatus status = new ResponseStatus();
        status.setError(0);
        status.setUrl(contextPath + "/file/" + filename);
        return status;
    }

    @RequestMapping("file/download")
    public ResponseEntity<byte[]> export(String fileName, HttpServletRequest request) throws IOException {

        String name = fileName.substring(fileName.lastIndexOf("/") + 1);
        HttpHeaders headers = new HttpHeaders();
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/file/");

        File file = new File(realPath + name);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", name);

        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @RequestMapping("/file/delete")
    @ResponseBody
    public ResponseStatus deleteFile(String fileName, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String filename = fileName.substring(contextPath.length());
        String realPath = request.getSession().getServletContext().getRealPath("");
        File file = new File(realPath, filename);
        if (file.exists()) {
            file.delete();
        }
        ResponseStatus status = new ResponseStatus();
        status.setData("success");
        return status;
    }

    @RequestMapping("/pic/upload")
    @ResponseBody
    public ResponseStatus pictureUpload(MultipartFile uploadFile, HttpServletRequest request) {
        String fileName = uploadFile.getOriginalFilename();
        String contextPath = request.getContextPath();

        fileName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "_" + fileName;

        String realPath = request.getServletContext().getRealPath("/WEB-INF/image/upload/");

        File file = new File(realPath + fileName);

        // 如果文件夹不存在，创建
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseStatus status = new ResponseStatus();
        status.setError(0);
        status.setUrl(contextPath + "/image/upload/" + fileName);
        return status;
    }

    @RequestMapping("/pic/delete")
    @ResponseBody
    public ResponseStatus deletePicture(String picName, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String filename = picName.substring(contextPath.length());
        String realPath = request.getSession().getServletContext().getRealPath("");
        File file = new File(realPath, filename);
        if (file.exists()) {
            file.delete();
        }
        ResponseStatus status = new ResponseStatus();
        status.setData("success");
        return status;
    }
}
