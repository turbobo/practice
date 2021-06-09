package com.demo.interview.primeton;

import java.io.*;

/**
 * @Author Jusven
 * @Date 2021/5/23 16:38
 *
 * test2 实现遍历D:\test\src目录下的所有图片(jpg)
 */
public class test2 {
    public static void main(String[] args) throws IOException {
//        File file = new File("H:\\workplaces\\eclipse_programs\\DataStructures\\testWrite2.txt");
        File file = new File("E:\\test\\src");
        FileInputStream fin = new FileInputStream(file);
        fin.close();

        readFromFile(file);
        listFil(file);

    }

    //遍历文件
    static void listFil(File file)
    {
        if(file.isDirectory()){
            File[] files=file.listFiles();
            for(File fil:files)
            {
                if(fil.isDirectory())
                    listFil(fil);
                System.out.println("file:"+fil);
            }
        }
        System.out.println("file:"+file);
    }

    //获取文件内容
    public static void readFromFile(File file) {
        if(file.isFile() && file.exists()) {
            try {
                //FileInputStream用于从文件读取数据,读取文件成字节流
                FileInputStream fs = new FileInputStream(file);
                //使用InputStream从文件里读取数据，将字节流转换为字符流.
                InputStreamReader isr = new InputStreamReader(fs);
                //从字符输入流中读取文本，缓冲各个字符
                BufferedReader br = new BufferedReader(isr);

                StringBuffer sb = new StringBuffer();
                String text = null;
                while((text = br.readLine()) != null) {
                    //将读取到的文本存入stringbuffer中
                    sb.append(text);
                }
                System.out.println("读取结果：" + sb.toString());

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
