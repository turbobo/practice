package foundation.test;


/**
 * @Author Jusven
 * @Date 2021/6/16 16:49
 * ������
 */
public class CutRope {
    public static void main(String[] args) {
        for (int i = 2; i < 11; i++) {
            System.out.println("cutRope("+ i +") = " + cutRope(i));
        }
        System.out.println("cutRope(8) = " + cutRope(8));
    }

    public static int cutRope(int n){
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        if(n == 4){
            return 4;
        }
        //ʹ�������¼����Ϊn�����ӣ��з��Ժ�õ������˻�
        int[] arr = new int[n+1];
        //С��4������£�������Ϊһ���֣������з־������˻�
        for (int i = 1; i <= 4; i++) {
            arr[i] = i;
        }

        for (int i = 5; i <= n; i++) {
            //������Ϊi�������з֣�����ÿ����������ֵ����ȡ���ֵ
            for (int j = 1; j < i; j++) {   //�з�Ϊ j  �� i-j  �ܳ���Ϊ i
                arr[i] = Math.max(arr[i],j*arr[i-j]);
            }
        }
        return arr[n];
    }
}
