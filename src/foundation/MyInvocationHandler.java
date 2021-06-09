package foundation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	/**
	 * 执行代理对象的所有方法时都会被替换成执行如下的invoke方法
	 * 
	 * proxy ：代表动态代理对象； method：代表正在执行的方法 ；args :代表执行代理对象方法时传入的实参
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
		/*System.out.println("正在执行方法：" + method.getName());
		if (args != null) {
			System.out.println("下面是执行方法时传入的实参：");
			for (Object object : args) {
				System.out.println(object);
			}
		} else {
			System.out.println("该方法调用无实参！");
		}
		return null;*/


		//调用方法
		Object res = method.invoke(target,args);   //调用Student 的 print方法返回的结果是2
		//乘以2的结果
		if(res!=null){
			res = (Integer)res *2 ;
		}
		System.out.println("增强功能");
		return res;
	}
 
}