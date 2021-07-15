package foundation.test;


import com.demo.jianzhiOffer.hasPath;

/**
 * @Author Jusven
 * @Date 2021/6/16 16:14
 * 矩阵中的路径
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
                    //每次匹配到第一个字符时才创建新的标记数组
                    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                    if(dfs(i,j,0,matrix,word,visited) == true) {  //该位置开始，后面一直能匹配到word
                        return true;
                    }
                }
            }
        }
        return false;  //遍历完矩阵matrix都没有找到
    }
    public static boolean dfs(int i, int j, int k, char[][] matrix, String word, boolean[][] visited){
        //有效校验
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || k>(word.length()-1) || visited[i][j]==true){
            return false;
        }
        //结束标志，word匹配到最后一个位置,且矩阵点和word最后一个字符相同
        if((k==word.length()-1) && (word.charAt(word.length()-1) == matrix[i][j])){
            return true;
        }
        //首先判断字符是否相同
        if(word.charAt(k) == matrix[i][j]){
            //首先标记该点
            visited[i][j] = true;
            //判断下一个字符,四个方向是否能匹配到word下一个字符
            if(dfs(i+1,j,k+1,matrix,word,visited) || dfs(i-1,j,k+1,matrix,word,visited)
            || dfs(i,j+1,k+1,matrix,word,visited) || dfs(i,j-1,k+1,matrix,word,visited)){
                return true;
            }else{
                visited[i][j] = false;  //矩阵该位置的下一个位置找不到，走不通，该点不算走过
                return false;
            }
        }else{
            visited[i][j] = false;  //矩阵该位置字符不匹配，走不通，该点不算走过
            return false;
        }
    }
}
