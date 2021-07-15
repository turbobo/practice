package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/6/15 21:18
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class hasPath {
    public static void main(String[] args) {

    }

    public static boolean solution(char[][] matrix, String word) {
        // 循环多次找到首个字母的初始位置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == word.charAt(0)){   //可能有多个位置匹配到字符串第一个字母
                    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            /*        //开始匹配word第二个字母-----*/

                    //继续判断第一个字母的下一个路径
                    //该位置字母可以得到word，则返回
                    if(dfs(i,j,0,visited,matrix,word) == true) {
                        return true;
                    }
                }
            }
        }
        //一直没有找到
        return false;
    }

    /**
     *
     * @param m  横坐标
     * @param n  纵坐标
     * @param k  字符串第k个字母
     * @param visited  一条路径能走通，包括所有已访问过的点，下一点找不到，则该点就不算访问过
     * @param matrix   矩阵
     * @param word   字符串
     * @return
     */
    public static boolean dfs(int m, int n, int k, boolean[][] visited, char[][] matrix, String word){
        //有效校验  横纵坐标超出边界，或者该点已经访问过
        // ***************** m-1 n-1，所有也可能小于0 ************************************
        if(m>=matrix.length || n>=matrix[0].length || visited[m][n] == true){
            return false;
        }
        //该位置和字符串最后一个字母相同，则说明已经遍历结束，找到所有字符串------k也遍历到最后一个位置
        if((matrix[m][n] == word.charAt(word.length()-1)) && (k == word.length()-1)){
            return true;
        }
        //visited[][] 记录访问过的矩阵点
        if(matrix[m][n] == word.charAt(k)){
            visited[m][n] = true;
            //往上下左右四个方向继续寻找,如果匹配到一个，
            // 则继续遍历，否则访问设置为未访问（每个字母都能经过一次，没有找到下一个字母，所以其实没有访问过）
            if(dfs(m+1,n,k+1,visited,matrix,word) || dfs(m-1,n,k+1,visited,matrix,word)
                    || dfs(m,n+1,k+1,visited,matrix,word) || dfs(m,n-1,k+1,visited,matrix,word)){
                return true;
            }else{ //四个方向都没有匹配到下一个字母，所有本轮该点 matrix[m][n]未访问过
                visited[m][n] = false;  //matrix[m][n]四个方向都走不通，换上个点的其他方向
                return false;
            }
        }else {  //字母不匹配，所以该点不算访问过，直接返回
            visited[m][n] = false;
            return false;
        }

    }
}
