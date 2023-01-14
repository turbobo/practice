package com.demo.leetcode.hashset;

/**
 * @Author Jusven
 * @Date 2023/1/7 9:31
 * 实现 Trie (前缀树)  --- 字典树
 * <p>
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
public class Trie {
    /**
     * 使用 多叉树实现，用结点组成树形结构
     * 用结点来记录 后面的元素 以及当前是否为字符串的结尾；
     * 竖向遍历,只要一个结点标志为结尾，说明存在该字符；
     * 竖向存在则表明以该字符串开头存在
     */
    private boolean isTail;
    //使用数组记录结点，每个结点负责记录当前值，以及后面的结点索引
    // 每一层字符最多只有26个，通过索引获取到下一层节点值后，该结点又能继续获取到下一层结点，就可以组成字符串
    private Trie[] children;


    //  初始化前缀树对象
    // Trie本身是一个结点，其包含的结点数组构成子结点，组成一个多叉树
    public Trie() {
        //初始化  每个结点默认不是字符串结尾
        this.isTail = false;
        this.children = new Trie[26];
    }



    // 向前缀树中插入字符串 word
    void insert(String word) {
        // 遍历字符串 竖向插入多叉树中
        // 每次获取当前树，从多叉树最顶层开始逐层往下遍历
        // 第二次插入字符串时，this就已经保存了之前的字符串了 ！！！！！！！！！！！！！！！！！！！！！！！！！！！
        Trie child = this;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
//            if (i != word.length() -1) {
                //首先判断结点是否存在==这个元素第一次出现
                if (child.children[c - 'a'] == null) {
                    child.children[c - 'a'] = new Trie();  //新建的结点默认不是叶子结点
                }
                // 默认是false  无需单独赋值
//                child.children[c - 'a'].isTail = false;

                // 指向下一层结点，开始存储字符串的下一个字符
                child = child.children[c - 'a'];
//            }
//            else {
//                if (child.children[c - 'a'] == null) {
//                    child.children[c - 'a'] = new Trie();
//                }
//                child.children[c - 'a'].isTail = true;
//            }

        }

        // 每个字符串遍历结束 才赋值true
        child.isTail = true;

    }

    // 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
    boolean  search(String word) {
        // 搜索当前完整的多叉树
//        Trie child = this;
//        for (int i=0;i<word.length();i++) {
//            char c = word.charAt(i);
//            if (child.children[c - 'a'] != null) {
//                child = child.children[c - 'a'];
//            }
//        }
//        if (child.isTail) {
//            return true;
//        }
//        return false;

        Trie child = this;
        if (startsWith(word)) {
            // startsWith(word)为true  说明前面的结点都存在，只需要遍历到最后一层结点，判断该结点是否为叶子结点即可
            for (int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                child = child.children[c - 'a'];
            }
            if (child.isTail) {
                return true;
            }
        }
        return false;
    }

    // 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     boolean startsWith(String prefix) {
        Trie child = this;
        for (int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if (child.children[c - 'a'] != null) {
                // 继续遍历字符
                child = child.children[c - 'a'];
            } else {
                return false;
            }
        }
        // 每个字符都存在于多叉树中，则说明prefix存在
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");


        trie.insert("abs");

        System.out.println(trie.startsWith("ab"));
        System.out.println(trie.search("ab"));

    }

}
