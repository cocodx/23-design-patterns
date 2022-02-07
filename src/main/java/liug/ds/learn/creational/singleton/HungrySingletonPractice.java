package liug.ds.learn.creational.singleton;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 饿汉式，单例模式
 *
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * @date 7/2/2022 上午12:49
 */
public class HungrySingletonPractice {

    private static final HungrySingletonPractice instance = new HungrySingletonPractice();

    private HungrySingletonPractice(){}

    public static HungrySingletonPractice getInstance(){
        return instance;
    }
}
