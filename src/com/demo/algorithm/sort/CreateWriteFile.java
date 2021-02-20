package com.demo.algorithm.sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author Jusven
 * @Date 2021/2/20 9:29
 */
public class CreateWriteFile {
    public static void main(String[] args) {
        String filename = "E:\\IdeaSpace\\TEST\\newFile.txt";

        Path path = Paths.get(filename);
        //ʹ��newBufferedWriter�����ļ���д���ļ�
        //ʹ��try�����ֶ��ر�
//        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
//            writer.write("Hello World!! �����ļ�");
//            writer.write("\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //׷��дģʽ
        for(int i=100000;i>=1;i--){
            try(BufferedWriter writer = Files.newBufferedWriter(path,StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
                writer.append(Integer.toString(i));
                writer.write("\n");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
