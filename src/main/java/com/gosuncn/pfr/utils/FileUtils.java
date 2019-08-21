package com.gosuncn.pfr.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 依赖apache的工具类
 * // https://mvnrepository.com/artifact/commons-lang/commons-lang
 * 	compile ('commons-lang:commons-lang:2.6')
 *
 * 	// https://mvnrepository.com/artifact/commons-io/commons-io
 * 	compile ('commons-io:commons-io:2.6')
 */
public class FileUtils {
    /**
     * 文件将会保存在localPath目录下
     *
     * @param file
     * @param localPath 指定文件的本地保存路径，如 C:/Users/huweijian/Desktop/rentHouse/
     * @param fileName  要保存的文件名,包含扩展名
     * @return 是否成功
     */
    public static boolean storeFile(@NonNull MultipartFile file, @NonNull String localPath, @NonNull String fileName) {
        if (file == null || localPath == null || fileName == null) {
            return false;
        }

        String realpath = localPath + (localPath.endsWith("/") ? "" : "/");
        File fileDir = new File(realpath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        InputStream input = null;
        FileOutputStream fos = null;
        try {
            input = file.getInputStream();
            fos = new FileOutputStream(realpath + "/" + fileName);
            IOUtils.copy(input, fos);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(fos);
        }
        return true;
    }

    /**
     * 获得扩展名
     *
     * @param file
     * @return
     */
    public static String getExtensionName(@NonNull MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        //获得文件的扩展名
        String extname = FilenameUtils.getExtension(originalFilename);
        return extname;
    }

    /**
     * 删除文件（非目录）
     * @param filePath
     */
    public static boolean deleteFile(String filePath){
        if(filePath==null||filePath.isEmpty()){
            return false;
        }
        File file = new File(filePath);
        if(file.exists()&&file.isFile()){
            file.delete();
            return true;
        }
        return false;
    }



}