package com.demo.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

// ��ʾ����������ʲô��˼
public class WhatReentrant2 {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("��1�λ�ȡ����������ǣ�" + lock);

					int index = 1;
					while (true) {
						try {
							lock.lock();
							System.out.println("��" + (++index) + "�λ�ȡ����������ǣ�" + lock);   //��ӡ�����ͬһ����
							
							try {
								Thread.sleep(new Random().nextInt(200));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							if (index == 10) {
								break;
							}
						} finally {
							lock.unlock();
						}

					}

				} finally {
					lock.unlock();
				}
			}
		}).start();
	}
}