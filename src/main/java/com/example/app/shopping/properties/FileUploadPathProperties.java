package com.example.app.shopping.properties;

public class FileUploadPathProperties {
    public static final String WINDOWS_UPLOAD_DIR = "C:/uploads/";
//    "C:/Users/Administrator/uploads/" 로 수정 필요
    public static final String LINUX_UPLOAD_DIR = "/home/ec2-user/uploads/";

    public static String getUploadDir() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return WINDOWS_UPLOAD_DIR;
        } else {
            return LINUX_UPLOAD_DIR;
        }
    }
}
