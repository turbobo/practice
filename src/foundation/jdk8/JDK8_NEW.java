package foundation.jdk8;

import java.time.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangbo82
 * @Date: 2022年05月13日 10:25
 */
public class JDK8_NEW {
    interface Car {
        static void staticRun(){
            System.out.println("静态接口方法");
        }

        default void defaultRun(){
            System.out.println("默认接口方法");
        }

        void run();
    }

    static class CarImpl implements Car{

        @Override
        public void run() {
            System.out.println("抽象方法");
        }
    }

    public static void main(String[] args) {
/*        CarImpl carIm = new CarImpl();
        carIm.defaultRun();
        Car.staticRun();
        carIm.run();*/


      /*  //parallelStream提供了流的并行处理，它是Stream的另一重要特性，其底层使用Fork/Join框架实现，简单理解就是多线程异步任务的一种实现。
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(num->System.out.println(num));
        //使用parallelStream后，结果并不按照集合原有顺序输出。为了进一步证明该操作是并行的，打印出线程信息。
        numbers.parallelStream() .forEach(num->System.out.println("当前线程："+Thread.currentThread().getName()+"，打印>>"+num));
*/

        // 获取当前时间
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);//2021-06-29T16:27:58.543
        // 获取指定时间
        LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
        System.out.println(ld2);//2016-11-21T10:10:10
        // 指定时间后移动2年
        LocalDateTime ldt3 = ld2.plusYears(20);
        System.out.println(ldt3);//2036-11-21T10:10:10
        // 指定时间前移动2月
        LocalDateTime ldt4 = ld2.minusMonths(2);
        System.out.println(ldt4);//2016-09-21T10:10:10

        System.out.println(ldt.getYear());//2021
        System.out.println(ldt.getMonthValue());//6
        System.out.println(ldt.getDayOfMonth());//29
        System.out.println(ldt.getHour());//16
        System.out.println(ldt.getMinute());//27
        System.out.println(ldt.getSecond());//58

        System.out.println("---------------当前时间解析-------------------");

        // 当前时间解析
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);//2021-06-29T16:27:58.546

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);// 2021-06-29

        Month month = currentTime.getMonth();
        Integer mon=month.ordinal()+1;
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month +"/"+mon+", 日: " + day +", 秒: " + seconds);//月: JUNE/6, 日: 29, 秒: 58

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);//date2: 2012-06-10T16:27:58.546

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.FEBRUARY, 25);
        System.out.println("date3: " + date3);//date3: 2014-02-25

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);//date4: 22:15

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);//date5: 20:15:30
        System.out.println("-------------Instant : 时间戳--------------------");
        // Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
        Instant ins = Instant.now();  //默认使用 UTC 时区 比大陆时间提前8小时
        System.out.println("ins"+ins);//ins2021-06-29T08:27:58.578Z

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println("odt"+odt);//odt2021-06-29T16:27:58.578+08:00

        System.out.println("ins.getNano():"+ins.getNano());//ins.getNano():578000000

        Instant ins2 = Instant.ofEpochSecond(5);
        System.out.println("ins2:"+ins2);//ins2:1970-01-01T00:00:05Z


        System.out.println("----------耗费时间统计------------");
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Instant ins3 = Instant.now();

        System.out.println("所耗费时间为：" + Duration.between(ins1, ins3));//所耗费时间为：PT1.005S

        LocalDate ld3 = LocalDate.now();
        LocalDate ld4 = LocalDate.of(2011, 1, 1);

        Period pe = Period.between(ld4, ld3);
        System.out.println(pe.getYears());//10
        System.out.println(pe.getMonths());//5
        System.out.println(pe.getDays());//28



        Map<String,Integer> ageMap=new HashMap<>();
        ageMap.put("胖虎",4);
        ageMap.put("二蛋",5);
        ageMap.put("富贵",6);
        ageMap.forEach((name,age)->{System.out.println("名字："+name+", 年龄:"+age);});

    }
}



