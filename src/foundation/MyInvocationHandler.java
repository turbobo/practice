package foundation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	/**
	 * ִ�д����������з���ʱ���ᱻ�滻��ִ�����µ�invoke����
	 * 
	 * proxy ������̬������� method����������ִ�еķ��� ��args :����ִ�д�����󷽷�ʱ�����ʵ��
	 */

	private Object target = null;
	public MyInvocationHandler(){
	}
	public MyInvocationHandler(Object target){
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		/*System.out.println("����ִ�з�����" + method.getName());
		if (args != null) {
			System.out.println("������ִ�з���ʱ�����ʵ�Σ�");
			for (Object object : args) {
				System.out.println(object);
			}
		} else {
			System.out.println("�÷���������ʵ�Σ�");
		}
		return null;*/


		//���÷���
		Object res = method.invoke(target,args);   //����Student �� print�������صĽ����2
		//����2�Ľ��
		if(res!=null){
			res = (Integer)res *2 ;
		}
		System.out.println("��ǿ����");
		return res;
	}
 
}