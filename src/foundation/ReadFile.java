package foundation;

import java.io.*;

/**
 * @Author Jusven
 * @Date 2021/6/3 17:48
 * ¶ÁÈ¡ÎÄ¼þ
 *
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/test.txt");
        BufferedReader br  = new BufferedReader(new FileReader(file));
        String s = null;
        while ((s = br.readLine()) != null){
            System.out.println("s = " + s);
        }
    }
}
