/*
 *         File : FileUtil.java
 *    Classname : FileUtil
 *    Author(s) : eznlzhi
 *      Created : 2018-03-06
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
 *
 */

package com.example.webdemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileUtil {

    public static List<String> readFileByLine(String fileName){
        if(StringUtils.isEmpty(fileName)){
            return null;
        }
        File file = new File(fileName);
        if(!file.exists()){
            return null;
        }
        BufferedReader reader = null;
        List<String> strList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while((tempString = reader.readLine()) != null) {
                strList.add(tempString.trim());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return strList;
    }

    public static boolean writeFileByLine(List<String> strList, String filePath, String title){
        BufferedWriter writer = null;
        boolean flag = false;
        try {
            File file = new File(filePath);
            if(file.exists()){
                return flag;
            }
            writer = new BufferedWriter(new FileWriter(file));
            if(title != null && !title.isEmpty()) {
                writer.write(title);
            }
            if(strList != null){
                for (String s : strList) {
                    writer.write(s);
                }
            }
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static String readFile(String fileName){
        if(StringUtils.isEmpty(fileName)){
            return null;
        }
        File file = new File(fileName);
        if(!file.exists()){
            return null;
        }
        StringBuffer sbf = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while((tempString = reader.readLine()) != null) {
                sbf.append(tempString.trim());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static boolean writeFile(String xml, String filePath){
        BufferedWriter writer = null;
        boolean flag = false;
        try {
            File file = new File(filePath);
            if(file.exists()){
                return flag;
            }
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(xml);
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static HttpStatus checkFile(String filePath, int length) {
        File file = new File(filePath);
        if (!file.exists()) {
            return HttpStatus.NOT_FOUND;
        }
        if (!file.canRead()) {
            return HttpStatus.BAD_REQUEST;
        }
        int len = 0;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
            String line = bufferedReader.readLine();
            if (line == null || line.equals("")) {
                return HttpStatus.BAD_REQUEST;
            }
            len = line.split("\t").length;
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (length != len) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    public static boolean checkFile(String filePath, String pattern){
        File file = new File(filePath);
        if(!file.exists()){
            return false;
        }
        if(!file.canRead()){
            return false;
        }
        if(!checkFileTitle(filePath, pattern)){
            return false;
        }
        return true;
    }

    private static boolean checkFileTitle(String filePath, String pattern){
        BufferedReader bufferedReader = null;
        boolean flag = true;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
            String firstLine = bufferedReader.readLine();
            if(firstLine == null || firstLine.equals("")){
                flag = false;
            }else if(!firstLine.matches(pattern)){
                flag = false;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static boolean validatePath(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    public static boolean checkFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public static String defaultFilePath(String fileName) {
        if(fileName.startsWith("/") || fileName.contains("\\")){
            return fileName;
        }
        return String.format("/export/home/mpcadmin/%s", fileName);
    }

    public static boolean insert(String fileName, long pos, String insertContent){
        RandomAccessFile raf = null;
        File tmp;
        try {
            tmp = File.createTempFile("tmp", null);
            log.info("Create temp file : {}.", tmp.getName());
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        }
        FileOutputStream tmpOut = null;
        FileInputStream tmpIn = null;
        try {
            raf = new RandomAccessFile(fileName, "rw");
            log.info("Create random-access file : {}.", raf.toString());
            tmpOut = new FileOutputStream(tmp);
            log.info("Create FileOutputStream : {}.", tmpOut.toString());
            tmpIn = new FileInputStream(tmp);
            log.info("Create FileInputStream : {}.", tmpIn.toString());
            raf.seek(pos);
            byte[] bbuf = new byte[64];
            int hasRead;
            while ((hasRead = raf.read(bbuf)) > 0){
                tmpOut.write(bbuf, 0, hasRead);
            }
            raf.seek(pos);
            raf.write(insertContent.getBytes());
            log.info("{} insert in {}.", fileName, pos);
            while ((hasRead = tmpIn.read(bbuf)) > 0){
                raf.write(bbuf, 0, hasRead);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                    log.info("Close RandomAccessFile.");
                }
                if (tmpOut != null) {
                    tmpOut.close();
                    log.info("Close FileOutputStream.");
                }
                if (tmpIn != null) {
                    tmpIn.close();
                    log.info("Close FileInputStream.");
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return true;
    }

    public static String readerFile(String filePath) {
        StringBuffer fileData = null;
        BufferedReader reader = null;
        try {
            fileData = new StringBuffer();
            reader = new BufferedReader(new FileReader(filePath));
            char[] buf = new char[1024];
            int numRead;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }
        } catch (IOException ignored) {
            log.info(ignored.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileData.toString();
    }

    public static List<Integer> getIndexList(String strings, String str){
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        while (strings.contains(str)){
            String aa = strings.substring(0, strings.indexOf(str) + str.length());
            flag = flag + aa.length();
            list.add(flag - str.length());
            strings = strings.substring(strings.indexOf(str) + str.length());
        }
        return list;
    }

    public static boolean writeFileCover(String content, String filePath){
        if(content == null){
            return false;
        }
        BufferedWriter writer = null;
        boolean flag = false;
        try {
            File file = new File(filePath);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            log.info("Writer finish.{}", filePath);
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
