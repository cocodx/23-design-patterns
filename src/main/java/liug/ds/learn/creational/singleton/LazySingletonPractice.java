package liug.ds.learn.creational.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 单例模式-懒加载
 *
 * 达到了按需加载，但是有线程不安全的问题
 *
 * @date 7/2/2022 上午12:44
 */
public class LazySingletonPractice {

    private static LazySingletonPractice instance = null;

    /**
     * 设置成private，只能在这个类里面new，其他类new不出来
     */
    private LazySingletonPractice(){}

    public static LazySingletonPractice getInstance(){
        if (instance == null){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingletonPractice();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(LazySingletonPractice.getInstance().hashCode());
            }).start();
        }
    }

}
