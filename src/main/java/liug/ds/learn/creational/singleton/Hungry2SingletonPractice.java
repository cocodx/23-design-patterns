package liug.ds.learn.creational.singleton;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 饿汉式-静态代码块加载
 * @date 7/2/2022 上午1:19
 */
public class Hungry2SingletonPractice {

    private static Hungry2SingletonPractice instance = null;

    static {
        instance = new Hungry2SingletonPractice();
    }



    private Hungry2SingletonPractice(){}

    public static Hungry2SingletonPractice getInstance(){
        return instance;
    }
}
