package com.aaron.exer.controller;

import com.aaron.exer.bean.UploadBean;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;

/**
 * Created by AaronC on 3/26/2017.
 */
@Controller
public class UploadController {

    public static final Resource PICTURES_DIR = new FileSystemResource("./picture");

    @RequestMapping(value = "upload")
    public String getUploadPage(UploadBean uploadBean) throws IOException {
        System.out.println(PICTURES_DIR.getFilename());

        return "upload";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(UploadBean uploadBean, MultipartFile[] files) throws IOException {

//        System.out.println(uploadBean.getEmail()+" "+uploadBean.getName()+" ");

//        File f=new File(PICTURES_DIR.getFile().getAbsolutePath()+File.separator+"newFolder");

//        f.mkdir();

        for(MultipartFile file:files) {
            saveFile(file);
        }

        return "uploadSuccess";
    }

    private void saveFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        File tempFile = File.createTempFile("uploaded", getFileExtension(filename), PICTURES_DIR.getFile());

        try (InputStream in = file.getInputStream();
             OutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy( in, out);
        }
    }

    @RequestMapping(value = "/uploadedPicture")
    public void getUploadedPicture(HttpServletResponse response) throws IOException {
        Resource classPathResource = new FileSystemResource("./picture/"+"anonymous.png");
        response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(classPathResource.getFilename()));
        IOUtils.copy(classPathResource.getInputStream(), response.getOutputStream());
    }

    private static String getFileExtension(String name) {
        return name.substring(name.lastIndexOf("."));
    }
}
