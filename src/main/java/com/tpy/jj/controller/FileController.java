package com.tpy.jj.controller;

import com.tpy.jj.utils.Commons;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@Slf4j
@RequestMapping("file")
public class FileController {

    @RequestMapping("downApp")
    @ResponseBody
    public void Download(HttpServletResponse response) {
        String fileName = "app-release.apk";
        String result = Commons.downloadFile(response, fileName);
        log.info("app包下载结果:",result);
    }

    private String downloadFile(HttpServletResponse response){
        String downloadFilePath = "D:\\微信文件\\";//被下载的文件在服务器中的路径,
        String fileName = "D:\\微信文件\\app-release.apk";//被下载文件的名称

        File file = new File(downloadFilePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }
}
