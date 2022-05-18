package foundation.summary;

import foundation.pojo.MySingleton;
import foundation.pojo.Parent;

import java.io.*;
import java.text.MessageFormat;

/**
 * @author: wangbo82
 * @Date: 2022年05月18日 11:43
 */
public class testSerializable {
    public static void main(String[] args) throws Exception {
        /**序列化Parent对象**/
        MySingleton mySingleton = SerializeParent();

        /**反序列Perons对象**/
//        Parent p = DeserializeParent();
        MySingleton m = DeserializeParent();

        System.out.println(m == mySingleton);
//        System.out.println(MessageFormat.format("name={0},age={1},sex={2}",p.getName(), p.getAge()));
    }

    /**
     * Description: 序列化Parent对象
     */
    private static MySingleton SerializeParent() throws FileNotFoundException,
            IOException {
        Parent parent = new Parent();
//        Parent.setName("gacl");
//        Parent.setAge(25);
        /** ObjectOutputStream 对象输出流，将Parent对象存储到E盘的Parent.txt文件中，完成对Parent对象的序列化操作 **/
//        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
//                new File("E:/Parent.txt")));
//        oo.writeObject(parent);
//        System.out.println("Parent对象序列化成功！" + parent.toString());
//        oo.close();

        MySingleton mySingleton = MySingleton.getInstance();
        ObjectOutputStream o2 = new ObjectOutputStream(new FileOutputStream(
                new File("E:/MySingleton.txt")));
        o2.writeObject(mySingleton);
        System.out.println("MySingleton对象序列化成功！" + mySingleton.toString());
        o2.close();
        return mySingleton;
    }

    /**
     * Description: 反序列Perons对象
     */
    private static MySingleton DeserializeParent() throws Exception, IOException {
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
//                new File("E:/Parent.txt")));
//        Parent parent = (Parent) ois.readObject();
//        System.out.println("Parent对象反序列化成功！"+ parent.toString());  //反序列化后不是同一个对象
//
//        return parent;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/MySingleton.txt")));
        MySingleton mySingleton = (MySingleton) ois.readObject();
        System.out.println("MySingleton对象反序列化成功！"+ mySingleton.toString());  //反序列化后不是同一个对象
        //添加readResolve方法后，反序列化得到同一个对象
//        MySingleton对象序列化成功！foundation.pojo.MySingleton@7f31245a
//        MySingleton对象反序列化成功！foundation.pojo.MySingleton@7f31245a

        return mySingleton;
    }
}
