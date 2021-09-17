package foundation.test;

import foundation.pojo.Person;
import foundation.pojo.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 利用newProxyInstance生成代理对象
 * 
 * @author wangzhipeng
 * 
 */
public class TestReflectProxy2 {

	public static void main(String[] args) {
/*		// 1、创建一个InvocationHandler对象
		InvocationHandler myInvocationHandler = new MyInvocationHandler();
		// 2、利用Proxy类的静态方法newProxyInstance直接生成Person接口的代理对象
		Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, myInvocationHandler);
		// 3、调用代理对象的方法
		person.walk();
		person.sayHello();*/
		/**
		 * 输出结果如下：
		 *
		 * 正在执行方法：walk 该方法调用无实参！
		 *
		 * 正在执行方法：sayHello 该方法调用无实参！
		 */

		Student s = new Student();
		//1、创建一个InvocationHandler对象
		InvocationHandler myInvocationHandler = new MyInvocationHandler(s);
		// 2、利用Proxy类的静态方法newProxyInstance直接生成Person接口的代理对象
		Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, myInvocationHandler);

		System.out.println("输出："+s.print());
		System.out.println("输出："+proxy.print());
	}

}