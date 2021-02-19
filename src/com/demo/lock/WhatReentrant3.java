package com.demo.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class WhatReentrant3 {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("��1�λ�ȡ���������A�ǣ�" + lock);

					int index = 1;
					while (true) {
						try {
							lock.lock();
							System.out.println("��" + (++index) + "�λ�ȡ��A��������ǣ�" + lock);
							
							try {
								Thread.sleep(new Random().nextInt(200));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							if (index == 10) {
								break;
							}
						} finally {
//							lock.unlock();// �������ע�ͣ�ʵ�ּ����������ͷŴ�����һ��
						}

					}

				} finally {
					lock.unlock();
					// ������finally��ͷ�ͷ�9�Σ��ü������ͷŴ���һ������û������
					for (int i = 0; i < 9; i++) {
						lock.unlock();

					}
				}
			}
		}).start();
		
		//�������û���ͷ���  ����һֱ�ȴ�����
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					lock.lock();
					
					for (int i = 0; i < 20; i++) {
						System.out.println("threadName:" + Thread.currentThread().getName());
						try {
							Thread.sleep(new Random().nextInt(200));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} finally {
					lock.unlock();
				}
			}
		}).start();
		
		
	}
}