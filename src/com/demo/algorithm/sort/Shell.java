package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 18:00
 * ϣ������
 */
public class Shell {
    //������Ԫ������
    public static void sort(Comparable[] a){
        //1.�������鳤��ȷ��������h��ʼֵ
        int h=1;
        while(h<a.length/2){
            h=2*h+1;
        }

        //2.ϣ������
        while(h>=1){
            //2.1 �ҵ��������Ԫ��
            // i���ӣ�����һ��Ԫ�غ��Լ��ļ��Ԫ�رȽϣ�ֱ��ÿ��������Ԫ�ض��ȽϹ�
            for(int i=h;i<a.length;i++) {
                //2.2 �Ѵ�����Ԫ��a[j]�ŵ�����������
                for(int j=i;j>=h;j=j-h) {  //j���Ǵ�����Ԫ��λ��,�ͼ��Ԫ�رȽ�; j>=h; ÿ�λ��µ�������h�� �ӵ�һ��hλ�ÿ�ʼ�Ƚϣ�
                    if(greater(a[j-h],a[j])){
                        swap(a,j-h,j);
                    }else{  //�Ѿ��ҵ���ǰ����λ�ã������ٱȽϸĲ���λ��
                        break;
                    }
                }
            }

            h=h/2; //����С������
        }

        //��һ��������Ԫ���±���� h
    }

    //�Ƚ�c1,c2Ԫ�ش�С
    private static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2)>0;   //ֱ�ӷ��رȽϽ��
    }

    //����Ԫ��i ��j ����
    private static void swap(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
