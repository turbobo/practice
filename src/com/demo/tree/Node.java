package com.demo.tree;
/*
* �������ڵ�
* */
public class Node {
    public Node leftChild;
    public Node rightChild;
    public int data;

    Node(int newData) {
        leftChild = null;
        rightChild = null;
        data = newData;
    }
}