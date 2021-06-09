package com.demo.interview.primeton;

import java.io.*;

/**
 * @Author Jusven
 * @Date 2021/5/23 16:38
 *
 * test2 ʵ�ֱ���D:\test\srcĿ¼�µ�����ͼƬ(jpg)
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

    //�����ļ�
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

    //��ȡ�ļ�����
    public static void readFromFile(File file) {
        if(file.isFile() && file.exists()) {
            try {
                //FileInputStream���ڴ��ļ���ȡ����,��ȡ�ļ����ֽ���
                FileInputStream fs = new FileInputStream(file);
                //ʹ��InputStream���ļ����ȡ���ݣ����ֽ���ת��Ϊ�ַ���.
                InputStreamReader isr = new InputStreamReader(fs);
                //���ַ��������ж�ȡ�ı�����������ַ�
                BufferedReader br = new BufferedReader(isr);

                StringBuffer sb = new StringBuffer();
                String text = null;
                while((text = br.readLine()) != null) {
                    //����ȡ�����ı�����stringbuffer��
                    sb.append(text);
                }
                System.out.println("��ȡ�����" + sb.toString());

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
