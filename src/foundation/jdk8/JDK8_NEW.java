package foundation.jdk8;

import java.time.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangbo82
 * @Date: 2022��05��13�� 10:25
 */
public class JDK8_NEW {
    interface Car {
        static void staticRun(){
            System.out.println("��̬�ӿڷ���");
        }

        default void defaultRun(){
            System.out.println("Ĭ�Ͻӿڷ���");
        }

        void run();
    }

    static class CarImpl implements Car{

        @Override
        public void run() {
            System.out.println("���󷽷�");
        }
    }

    public static void main(String[] args) {
/*        CarImpl carIm = new CarImpl();
        carIm.defaultRun();
        Car.staticRun();
        carIm.run();*/


      /*  //parallelStream�ṩ�����Ĳ��д�������Stream����һ��Ҫ���ԣ���ײ�ʹ��Fork/Join���ʵ�֣��������Ƕ��߳��첽�����һ��ʵ�֡�
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(num->System.out.println(num));
        //ʹ��parallelStream�󣬽���������ռ���ԭ��˳�������Ϊ�˽�һ��֤���ò����ǲ��еģ���ӡ���߳���Ϣ��
        numbers.parallelStream() .forEach(num->System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"����ӡ>>"+num));
*/

        // ��ȡ��ǰʱ��
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);//2021-06-29T16:27:58.543
        // ��ȡָ��ʱ��
        LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
        System.out.println(ld2);//2016-11-21T10:10:10
        // ָ��ʱ����ƶ�2��
        LocalDateTime ldt3 = ld2.plusYears(20);
        System.out.println(ldt3);//2036-11-21T10:10:10
        // ָ��ʱ��ǰ�ƶ�2��
        LocalDateTime ldt4 = ld2.minusMonths(2);
        System.out.println(ldt4);//2016-09-21T10:10:10

        System.out.println(ldt.getYear());//2021
        System.out.println(ldt.getMonthValue());//6
        System.out.println(ldt.getDayOfMonth());//29
        System.out.println(ldt.getHour());//16
        System.out.println(ldt.getMinute());//27
        System.out.println(ldt.getSecond());//58

        System.out.println("---------------��ǰʱ�����-------------------");

        // ��ǰʱ�����
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("��ǰʱ��: " + currentTime);//2021-06-29T16:27:58.546

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);// 2021-06-29

        Month month = currentTime.getMonth();
        Integer mon=month.ordinal()+1;
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("��: " + month +"/"+mon+", ��: " + day +", ��: " + seconds);//��: JUNE/6, ��: 29, ��: 58

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);//date2: 2012-06-10T16:27:58.546

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.FEBRUARY, 25);
        System.out.println("date3: " + date3);//date3: 2014-02-25

        // 22 Сʱ 15 ����
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);//date4: 22:15

        // �����ַ���
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);//date5: 20:15:30
        System.out.println("-------------Instant : ʱ���--------------------");
        // Instant : ʱ����� ��ʹ�� Unix Ԫ��  1970��1��1�� 00:00:00 �������ĺ���ֵ��
        Instant ins = Instant.now();  //Ĭ��ʹ�� UTC ʱ�� �ȴ�½ʱ����ǰ8Сʱ
        System.out.println("ins"+ins);//ins2021-06-29T08:27:58.578Z

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println("odt"+odt);//odt2021-06-29T16:27:58.578+08:00

        System.out.println("ins.getNano():"+ins.getNano());//ins.getNano():578000000

        Instant ins2 = Instant.ofEpochSecond(5);
        System.out.println("ins2:"+ins2);//ins2:1970-01-01T00:00:05Z


        System.out.println("----------�ķ�ʱ��ͳ��------------");
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Instant ins3 = Instant.now();

        System.out.println("���ķ�ʱ��Ϊ��" + Duration.between(ins1, ins3));//���ķ�ʱ��Ϊ��PT1.005S

        LocalDate ld3 = LocalDate.now();
        LocalDate ld4 = LocalDate.of(2011, 1, 1);

        Period pe = Period.between(ld4, ld3);
        System.out.println(pe.getYears());//10
        System.out.println(pe.getMonths());//5
        System.out.println(pe.getDays());//28



        Map<String,Integer> ageMap=new HashMap<>();
        ageMap.put("�ֻ�",4);
        ageMap.put("����",5);
        ageMap.put("����",6);
        ageMap.forEach((name,age)->{System.out.println("���֣�"+name+", ����:"+age);});

    }
}



