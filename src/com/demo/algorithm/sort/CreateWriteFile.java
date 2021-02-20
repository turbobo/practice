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
        //使用newBufferedWriter创建文件并写入文件
        //使用try无需手动关闭
//        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
//            writer.write("Hello World!! 创建文件");
//            writer.write("\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //追加写模式
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
