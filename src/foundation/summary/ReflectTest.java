package foundation.summary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: wangbo82
 * @Date: 2022��05��18�� 10:49
 */
public class ReflectTest {
    private int price;

    public String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //�����ĵ���
        ReflectTest reflectTest = new ReflectTest();
        reflectTest.setPrice(5);
        System.out.println("ReflectTest Price:" + reflectTest.getPrice());
        //ʹ�÷������
//        Class clz = Class.forName("foundation.summary.ReflectTest");
        Class<? extends ReflectTest> clz = reflectTest.getClass();

        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        Constructor ReflectTestConstructor = clz.getConstructor();
        Object ReflectTestObj = ReflectTestConstructor.newInstance();
        Object ReflectTestObj2 = ReflectTestConstructor.newInstance();
        Object ReflectTestObj3 = ReflectTestConstructor.newInstance();
        //��������Ĳ���һ������
        System.out.println(ReflectTestObj.toString());
        System.out.println(ReflectTestObj2.toString());
        System.out.println(ReflectTestObj3.toString());
//        setPriceMethod.invoke(ReflectTestObj, 14);
        setPriceMethod.invoke(ReflectTestObj, 65);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("ReflectTest Price:" + getPriceMethod.invoke(ReflectTestObj));

//        Field[] fields = clz.getFields();  //������˽������price
        Field[] fields = clz.getDeclaredFields();  //����˽������
        for (Field field : fields) {
            System.out.println("����: " + field.getName());
        }

//        Method[] methods = clz.getMethods();
        Method[] methods = clz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("����: " + m.getName());
        }
    }
}
