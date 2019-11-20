package com.yefei.securityweb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yefei
 * @Date: create in 2019-07-05
 * @Desc:
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 传入文件路径复制文件
     * @param srcPath
     * @param targetPath
     * @throws IOException
     */
    public static void copyFile(String srcPath, String targetPath) throws IOException {
        FileInputStream in = new FileInputStream(new File(srcPath));
        FileOutputStream out = new FileOutputStream(new File(targetPath));
        copyFile(in, out);
    }

    /**
     * 传入文件类复制文件
     * @param srcFile
     * @param targetFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File targetFile) throws IOException {
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(targetFile);
        copyFile(in, out);
    }

    /**
     * 传入文件流复制文件
     * @param in
     * @param out
     * @throws IOException
     */
    public static void copyFile(FileInputStream in, FileOutputStream out) throws IOException {
        byte[] buff = new byte[512];
        int n = 0;
        while ((n = in.read(buff)) != -1) {
            out.write(buff, 0, n);
        }
        out.flush();
        in.close();
        out.close();
    }


    /**
     * 递归获取一个路径下的所有文件
     * @param path        文件路径
     * @param allFileName 用来接受文件名称的列表，传size为0的空集合即可
     * @return
     */
    public static List<String> recursiveFiles(String path, List<String> allFileName) {
        // 创建 File对象
        File file = new File(path);
        // 取 文件/文件夹
        File files[] = file.listFiles();
        // 对象为空 直接返回
        if (files == null || files.length == 0) {
            return allFileName;
        }

        for (File f : files) {              // 存在文件 遍历 判断
            if (f.isDirectory()) {          // 判断是否为 文件夹
                // 为 文件夹继续遍历
                recursiveFiles(f.getAbsolutePath(), allFileName);
            } else if (f.isFile()) {        // 判断是否为 文件
                allFileName.add(f.getAbsolutePath());
            } else {
                logger.error("未知错误文件");
            }
        }
        return allFileName;
    }


    /**
     * 不使用递归获取一个路径下所有文件
     * @param path
     * @return
     */
    public static List<String> getFiles(String path) {
        List<String> fileNames = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    list.add(file2);
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        list.add(file2);
                    } else {
                        fileNames.add(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            logger.error("文件不存在!");
        }
        return fileNames;
    }

}
