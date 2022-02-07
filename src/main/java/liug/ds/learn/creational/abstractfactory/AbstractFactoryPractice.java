package liug.ds.learn.creational.abstractfactory;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 抽象工厂模式：在工厂模式上面，进一步的抽象，把具体实现的子类相同部分给抽象出来
 * @date 7/2/2022 下午8:40
 */
public class AbstractFactoryPractice {


    public static abstract class AbstractFactory{
        protected Object createDynamicProxy(Object o){
            common();
            return createDynamicProxy1(o);
        }

        protected abstract Object createDynamicProxy1(Object o);

        private static void common() {
            System.out.println("检查class文件是否符合要求");
        }
    }

    public static class Jdk extends AbstractFactory{
        @Override
        protected Object createDynamicProxy1(Object o) {
            System.out.println("jdk动态代理,反射");
            return new Object();
        }
    }
}
