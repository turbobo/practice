package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/5/15 11:11
 *
 * ������Ӵ�---ֻ��һ�������
 *
 * ���������ַ���str1��str2,��������ַ�����������Ӵ�
 * ��Ŀ��֤str1��str2��������Ӵ�������Ψһ
 *
 * */
public class LCS {
    public static void main(String[] args) {
        LCS("ABD", "BDE");
        LCS("1AB2345CD","12345EF");
    }

    //��̬�滮
    public static String LCS (String text1, String text2) {
        int m = text1.length(), n = text2.length();
        //��̬�滮����
        //text1[0,i]��ʾtext1��ǰ i���ַ�
        //text2[0,j]��ʾtext2��ǰ j���ַ�
        //dp[i][j]��ʾ text1��ǰ i���ַ�  ��  text2��ǰ j���ַ�   ���ڹ��������еĸ���
        //i=0  ���� j=0 dp[i][j]=0
        //text1[i] == text2[j] ʱ��dp[i][j] = dp[i-1][j-1] + 1
        //text1[i] ��= text2[j] ʱ��dp[i][j] = 0����λ����ͬ�����¼���

        int[][] dp = new int[m + 1][n + 1];
        //����Ӵ�����
        int length = 0;
        //����Ӵ�λ��
        int index = 0;
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    //��ǰ�ַ���ͬʱ��ֻ�迼��text1  text2 ����һλ�Ӵ�����������ϱ�λ��ͬ����
                    dp[i][j] = dp[i - 1][j - 1] + 1;   //��λ�Ƚϣ����ַ���ͬ���ظ������м� 1

                    //ÿ�μ�¼��ǰ��Ӵ���λ�á�����
                    if(length<dp[i][j]){
                        length = dp[i][j];
                        index = i;
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }
        if(index!=0){
            System.out.println("��̬�滮����: ");
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println(text1+" �� "+text2+" ����󹫹��Ӵ�: "+text1.substring(index-length,index)+" ����: " + length);
            return text1.substring(index-length,index);   //�����Ӵ�
        }
        return "";

    }

    public String LCS2 (String str1, String str2) {
        String result = "";
        int start = 0;
        int end = 1;
        while(end<=str2.length()){
            String subStr = str2.substring(start,end);
            if(str1.contains(subStr)){   //�ַ�������
                result = subStr;   //������Ӵ�������Ψһ�����
            }else{
                start++;
            }
            end++;
        }
        return result;
    }
}
