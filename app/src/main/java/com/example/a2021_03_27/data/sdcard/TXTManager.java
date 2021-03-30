package com.example.a2021_03_27.data.sdcard;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class TXTManager {
    private static String writeTxtPath;
    private static String readTxtPath;

    //获取目录下所有txt文件完整文件名
    public static List<String> getFilesAllName(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        if(files == null){
            Log.e("error","空目录");
            return null;
        }
        List<String> s = new ArrayList<>();
        for(int i = 0 ; i < files.length ; i++){
            if(files[i].getName().substring((int)(files[i].length()-4)) == ".txt"){
                s.add(files[i].getAbsolutePath());
            }
        }
        return s;
    }

    public void setTxtPath(String w,String r){
        writeTxtPath = w;
        readTxtPath = r;
    }

    //将文本以txt的形式存放在本地
    public static boolean writeToLocal(String fileName,String content,String writeTxtPath){
        InitLocalDir initLocalDir = new InitLocalDir();
        //创建文件输出流
        FileOutputStream fileOutputStream;
        //创建写缓冲区
        BufferedWriter bufferedWriter;
        //创建文件目录
        initLocalDir.createADirectory(writeTxtPath);
        //初始化文件
        File file = new File(writeTxtPath+"/"+fileName+".txt");
        try{
            //创建文件
            file.createNewFile();
            //初始化输出流
            fileOutputStream = new FileOutputStream(file);
            //初始化些缓冲区
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            //将content写入文件
            bufferedWriter.write(content);
            //关闭写缓冲区
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String readFromLocal(String readTxtPath){
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        //暂存文本的容器（初始化）
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(readTxtPath);
        if(file.exists()){
            try{
                fileInputStream = new FileInputStream(file);
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line;
                while((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line);
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return  stringBuilder.toString();
    }
}
