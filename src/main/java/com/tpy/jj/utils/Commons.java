package com.tpy.jj.utils;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Random;

public class Commons {

    private static final String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123457890!@#$%^&*()_+";

    /**
     * 获取随机盐
     * @param count
     * @return
     */
    public static String getSalt(int count){
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(chars[new Random().nextInt(chars.length)]);
        }
        return stringBuilder.toString();
    }


    /**
     * 下载文件
     * @param response
     * @param fileName
     * @return
     */
    public static String downloadFile(HttpServletResponse response, String fileName) {
        String path = "D:\\微信文件\\";
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
//            path = new File(ResourceUtils.getURL("classpath:").getPath());
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(path + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (FileNotFoundException e1) {
            //e1.getMessage()+"系统找不到指定的文件";
            return "系统找不到指定的文件";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }

    public static void main(String[] args) {
        System.out.println(getSalt(4));
    }

}
