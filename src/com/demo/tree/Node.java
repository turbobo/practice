package com.demo.tree;
/*
* �������ڵ�
* */
public class Node {
    Node leftChild;
    Node rightChild;
    int data;

    Node(int newData) {
        leftChild = null;
        rightChild = null;
        data = newData;
    }
}