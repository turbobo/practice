package foundation.summary;

import foundation.pojo.MySingleton;
import foundation.pojo.Parent;

import java.io.*;
import java.text.MessageFormat;

/**
 * @author: wangbo82
 * @Date: 2022��05��18�� 11:43
 */
public class testSerializable {
    public static void main(String[] args) throws Exception {
        /**���л�Parent����**/
        MySingleton mySingleton = SerializeParent();

        /**������Perons����**/
//        Parent p = DeserializeParent();
        MySingleton m = DeserializeParent();

        System.out.println(m == mySingleton);
//        System.out.println(MessageFormat.format("name={0},age={1},sex={2}",p.getName(), p.getAge()));
    }

    /**
     * Description: ���л�Parent����
     */
    private static MySingleton SerializeParent() throws FileNotFoundException,
            IOException {
        Parent parent = new Parent();
//        Parent.setName("gacl");
//        Parent.setAge(25);
        /** ObjectOutputStream �������������Parent����洢��E�̵�Parent.txt�ļ��У���ɶ�Parent��������л����� **/
//        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
//                new File("E:/Parent.txt")));
//        oo.writeObject(parent);
//        System.out.println("Parent�������л��ɹ���" + parent.toString());
//        oo.close();

        MySingleton mySingleton = MySingleton.getInstance();
        ObjectOutputStream o2 = new ObjectOutputStream(new FileOutputStream(
                new File("E:/MySingleton.txt")));
        o2.writeObject(mySingleton);
        System.out.println("MySingleton�������л��ɹ���" + mySingleton.toString());
        o2.close();
        return mySingleton;
    }

    /**
     * Description: ������Perons����
     */
    private static MySingleton DeserializeParent() throws Exception, IOException {
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
//                new File("E:/Parent.txt")));
//        Parent parent = (Parent) ois.readObject();
//        System.out.println("Parent�������л��ɹ���"+ parent.toString());  //�����л�����ͬһ������
//
//        return parent;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/MySingleton.txt")));
        MySingleton mySingleton = (MySingleton) ois.readObject();
        System.out.println("MySingleton�������л��ɹ���"+ mySingleton.toString());  //�����л�����ͬһ������
        //���readResolve�����󣬷����л��õ�ͬһ������
//        MySingleton�������л��ɹ���foundation.pojo.MySingleton@7f31245a
//        MySingleton�������л��ɹ���foundation.pojo.MySingleton@7f31245a

        return mySingleton;
    }
}
