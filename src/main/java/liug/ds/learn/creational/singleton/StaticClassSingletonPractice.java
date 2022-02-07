package liug.ds.learn.creational.singleton;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 静态内部类的方式，JVM保证单例
 * 加载外部类时，不会加载内部类，可以实现懒加载
 * @date 7/2/2022 上午1:15
 */
public class StaticClassSingletonPractice {

    private StaticClassSingletonPractice(){}

    private static class staticHolder{
        private final static StaticClassSingletonPractice instance = new StaticClassSingletonPractice();
    }

    public static StaticClassSingletonPractice getInstance(){
        return staticHolder.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(StaticClassSingletonPractice.getInstance().hashCode());
            }).start();
        }
    }
}
