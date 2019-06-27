package com.cskaoyan.controller.scheduling;

import com.cskaoyan.pojo.ResponseStatus;
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

        // 将文件夹打散
        int code = filename.hashCode();
        String string = Integer.toHexString(code);
        char[] chars = string.toCharArray();

        //取十六进制HashCode的前两位作为文件夹路径
        filename = chars[0] + "/" + chars[1] + "/" + filename;
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

    @RequestMapping("/file/download")
    @ResponseBody
    public ResponseStatus FileDownload(String filename, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getServletContext().getRealPath("/");
        String contextPath = request.getContextPath();
        String replace = filename.replace(contextPath, "WEB-INF");

        int index = replace.lastIndexOf("/");
        String downloadFile = replace.substring(index + 1);

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + downloadFile);

        try (InputStream inputStream = new FileInputStream(realPath + "/" + replace);
             ServletOutputStream outputStream = response.getOutputStream()) {
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseStatus();
    }

    @RequestMapping("/pic/upload")
    @ResponseBody
    public ResponseStatus pictureUpload(MultipartFile uploadFile, HttpServletRequest request) {
        String fileName = uploadFile.getOriginalFilename();
        fileName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "_" + fileName;
        String contextPath = request.getContextPath();
        String path = request.getServletContext().getRealPath("/WEB-INF/image/upload/");
        File file = new File(path + fileName);

        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseStatus status = new ResponseStatus();
        status.setError(0);
        status.setUrl(contextPath + "/pic/" + fileName);
        return status;
    }

}
