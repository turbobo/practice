package com.demo.lock;

// ��ʾ����������ʲô��˼�������룬���ǿ����ظ���ȡ��ͬ������synchronized��ReentrantLock���ǿ������
// �����뽵���˱�̸�����
public class WhatReentrant {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					System.out.println("�� 1 �λ�ȡ����������ǣ�" + this); //��ӡ���  ��ͬһ����
					int index = 1;
					while (true) {
						synchronized (this) {   //���߳̿����ظ����ͬһ����
							System.out.println("��" + (++index) + "�λ�ȡ����������ǣ�" + this);
						}
						if (index == 10) {
							break;
						}
					}
				}
			}
		}).start();
	}
}