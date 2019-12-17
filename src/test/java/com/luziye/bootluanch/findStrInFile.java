package com.luziye.bootluanch;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findStrInFile {
    public static void main(String[] args) {
        System.out.println(getAppearCount("abc", "abc"));
    }

    public static int getFile(File f, String str) {
        int count = 0;
        if (f == null) {
            System.out.println("路径为空，重新传入");
            return 0;
        } else if (f.isFile()) {
            System.out.println("路径非文件夹，请重新传入");
            return 0;
        } else if (!f.exists()) {
            System.out.println("路径不存在，请重新传入");
            return 0;
        }
        File[] fs = f.listFiles();
        for (int i = 0; i < fs.length; i++) {
            if (fs[i].isFile() && isTxt(fs[i])) {
                count = textAppearCount(fs[i], str) + count;
            } else {
                getFile(fs[i], str);
            }
        }
        return count;
    }

    public static boolean isTxt(File file) {
        String fileName = file.getName();
        String regex = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (regex.equals("txt")) {
            return true;
        }
        return false;
    }

    public static int textAppearCount(File f, String target) {
        BufferedReader br = null;
        int index = 0;
        int count = 0;
        StringBuffer sb = new StringBuffer();
        BufferedInputStream fis=null;
        //读取文件内容
        try {
            fis=new BufferedInputStream(new FileInputStream(f));
            br = new BufferedReader(new InputStreamReader(fis,"utf-8"),10*1024*1024);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            String srcText = sb.toString();
            while ((index = srcText.indexOf(target)) != -1) {
                srcText = srcText.substring(index + target.length());
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }
    //abcsdabcomfrabc abc
    public static int getAppearCount(String srcText, String target) {
        int index = 0;
        int count = 0;
        while ((index = srcText.indexOf(target)) != -1) {
            srcText = srcText.substring(index + target.length());
            count++;
        }
        return count;
    }
}
