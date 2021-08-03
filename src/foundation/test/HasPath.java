package foundation.test;


import com.demo.jianzhiOffer.hasPath;

/**
 * @Author Jusven
 * @Date 2021/6/16 16:14
 * �����е�·��
 */
public class HasPath {
    public static void main(String[] args) {
        char[][] matrix = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        System.out.println("hasPath(matrix,\"abcced\") = " + hasPath(matrix, "abcced"));
        char[][] matrix2 = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        System.out.println("hasPath(matrix2,\"abcb\") = " + hasPath(matrix2, "abcb"));

    }
    public static boolean hasPath(char[][] matrix, String word) {
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == word.charAt(0)){
                    //ÿ��ƥ�䵽��һ���ַ�ʱ�Ŵ����µı������
                    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                    if(dfs(i,j,0,matrix,word,visited) == true) {  //��λ�ÿ�ʼ������һֱ��ƥ�䵽word
                        return true;
                    }
                }
            }
        }
        return false;  //���������matrix��û���ҵ�
    }
    public static boolean dfs(int i, int j, int k, char[][] matrix, String word, boolean[][] visited){
        //��ЧУ��
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || k>(word.length()-1) || visited[i][j]==true){
            return false;
        }
        //������־��wordƥ�䵽���һ��λ��,�Ҿ�����word���һ���ַ���ͬ
        if((k==word.length()-1) && (word.charAt(word.length()-1) == matrix[i][j])){
            return true;
        }
        //�����ж��ַ��Ƿ���ͬ
        if(word.charAt(k) == matrix[i][j]){
            //���ȱ�Ǹõ�
            visited[i][j] = true;
            //�ж���һ���ַ�,�ĸ������Ƿ���ƥ�䵽word��һ���ַ�
            if(dfs(i+1,j,k+1,matrix,word,visited) || dfs(i-1,j,k+1,matrix,word,visited)
            || dfs(i,j+1,k+1,matrix,word,visited) || dfs(i,j-1,k+1,matrix,word,visited)){
                return true;
            }else{
                visited[i][j] = false;  //�����λ�õ���һ��λ���Ҳ������߲�ͨ���õ㲻���߹�
                return false;
            }
        }else{
            visited[i][j] = false;  //�����λ���ַ���ƥ�䣬�߲�ͨ���õ㲻���߹�
            return false;
        }
    }
}
