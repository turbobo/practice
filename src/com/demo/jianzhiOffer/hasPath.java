package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/6/15 21:18
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ�
 */
public class hasPath {
    public static void main(String[] args) {

    }

    public static boolean solution(char[][] matrix, String word) {
        // ѭ������ҵ��׸���ĸ�ĳ�ʼλ��
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == word.charAt(0)){   //�����ж��λ��ƥ�䵽�ַ�����һ����ĸ
                    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            /*        //��ʼƥ��word�ڶ�����ĸ-----*/

                    //�����жϵ�һ����ĸ����һ��·��
                    //��λ����ĸ���Եõ�word���򷵻�
                    if(dfs(i,j,0,visited,matrix,word) == true) {
                        return true;
                    }
                }
            }
        }
        //һֱû���ҵ�
        return false;
    }

    /**
     *
     * @param m  ������
     * @param n  ������
     * @param k  �ַ�����k����ĸ
     * @param visited  һ��·������ͨ�����������ѷ��ʹ��ĵ㣬��һ���Ҳ�������õ�Ͳ�����ʹ�
     * @param matrix   ����
     * @param word   �ַ���
     * @return
     */
    public static boolean dfs(int m, int n, int k, boolean[][] visited, char[][] matrix, String word){
        //��ЧУ��  �������곬���߽磬���߸õ��Ѿ����ʹ�
        // ***************** m-1 n-1������Ҳ����С��0 ************************************
        if(m>=matrix.length || n>=matrix[0].length || visited[m][n] == true){
            return false;
        }
        //��λ�ú��ַ������һ����ĸ��ͬ����˵���Ѿ������������ҵ������ַ���------kҲ���������һ��λ��
        if((matrix[m][n] == word.charAt(word.length()-1)) && (k == word.length()-1)){
            return true;
        }
        //visited[][] ��¼���ʹ��ľ����
        if(matrix[m][n] == word.charAt(k)){
            visited[m][n] = true;
            //�����������ĸ��������Ѱ��,���ƥ�䵽һ����
            // ����������������������Ϊδ���ʣ�ÿ����ĸ���ܾ���һ�Σ�û���ҵ���һ����ĸ��������ʵû�з��ʹ���
            if(dfs(m+1,n,k+1,visited,matrix,word) || dfs(m-1,n,k+1,visited,matrix,word)
                    || dfs(m,n+1,k+1,visited,matrix,word) || dfs(m,n-1,k+1,visited,matrix,word)){
                return true;
            }else{ //�ĸ�����û��ƥ�䵽��һ����ĸ�����б��ָõ� matrix[m][n]δ���ʹ�
                visited[m][n] = false;  //matrix[m][n]�ĸ������߲�ͨ�����ϸ������������
                return false;
            }
        }else {  //��ĸ��ƥ�䣬���Ըõ㲻����ʹ���ֱ�ӷ���
            visited[m][n] = false;
            return false;
        }

    }
}
