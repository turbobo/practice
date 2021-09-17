package foundation.test;

import foundation.pojo.Person;
import foundation.pojo.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ����newProxyInstance���ɴ������
 * 
 * @author wangzhipeng
 * 
 */
public class TestReflectProxy2 {

	public static void main(String[] args) {
/*		// 1������һ��InvocationHandler����
		InvocationHandler myInvocationHandler = new MyInvocationHandler();
		// 2������Proxy��ľ�̬����newProxyInstanceֱ������Person�ӿڵĴ������
		Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, myInvocationHandler);
		// 3�����ô������ķ���
		person.walk();
		person.sayHello();*/
		/**
		 * ���������£�
		 *
		 * ����ִ�з�����walk �÷���������ʵ�Σ�
		 *
		 * ����ִ�з�����sayHello �÷���������ʵ�Σ�
		 */

		Student s = new Student();
		//1������һ��InvocationHandler����
		InvocationHandler myInvocationHandler = new MyInvocationHandler(s);
		// 2������Proxy��ľ�̬����newProxyInstanceֱ������Person�ӿڵĴ������
		Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, myInvocationHandler);

		System.out.println("�����"+s.print());
		System.out.println("�����"+proxy.print());
	}

}