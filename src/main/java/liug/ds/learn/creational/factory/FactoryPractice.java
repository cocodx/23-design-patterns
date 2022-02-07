package liug.ds.learn.creational.factory;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 工厂模式
 * @date 7/2/2022 下午8:32
 */
public class FactoryPractice {

    /**
     * 工厂模式，定义生产目标类的接口，具体的实现动作交给子类去实现
     */
    public static interface Factory{
        Object createDynamicProxy(Object o);
    }

    public static class Jdk implements Factory{
        @Override
        public Object createDynamicProxy(Object o) {
            System.out.println("检查class文件是否符合要求");
            System.out.println("jdk动态代理,反射");
            return new Object();
        }
    }

    public static class Cglib implements Factory{
        @Override
        public Object createDynamicProxy(Object o) {
            System.out.println("检查class文件是否符合要求");
            System.out.println("cglib动态代理,asm");
            return new Object();
        }
    }

    public static void main(String[] args) {
        Factory jdk = new Jdk();
        jdk.createDynamicProxy(new Object());

        Factory cglib = new Cglib();
        cglib.createDynamicProxy(new Object());
    }
}
