package liug.ds.learn.creational.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 * @author amazfit
 * @date 2022-06-17 下午8:35
 *
 * 如果一个对象实例一经创建就不可变，
 * 那么反复创建相同的实例就没有必要，
 * 直接向调用方返回一个共享的实例就行，
 * 这样即节省内存，又可以减少创建对象的过程，
 * 提高运行速度。
 **/
public class FlyWeightPracticeDay1 {

    /**
     * 以Integer为例，如果我们通过Integer.valueOf()这个静态工厂方法创建Integer实例，当传入的int范围在-128~+127之间时，会直接返回缓存的Integer实例
     * @param args
     */
    public static void main(String[] args) {
        Integer integer1 = new Integer(127);
        Integer integer2 = new Integer(127);
        if (integer1.equals(integer2)){
            System.out.println("缓存模式，牛逼");
        }else{
            System.out.println("缓存模式，牛逼plus");
        }

        Student student = new Student(1,"小刚");
        Student student1 = new Student(2,"张乐希");
        Student student2 = new Student(1,"小刚");

        System.out.println(student.equals(student2));
    }

    /**
     * 缓存容器
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Student{
        private static final Map<Integer,Student> cache = new ConcurrentHashMap<>();

        public static Student create(int id,String name){
            Student student = cache.get(id);
            if (student==null){
                student = new Student(id,name);
                cache.put(id,student);
            }
            return student;
        }

        /**
         * id
         */
        private Integer id;

        /**
         * 名称
         */
        private String name;

    }
}
