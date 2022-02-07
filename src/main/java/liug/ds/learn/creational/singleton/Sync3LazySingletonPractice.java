package liug.ds.learn.creational.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 正能量导师
 * @version 1.0
 * @description double-check 双重检查
 * @date 7/2/2022 上午1:11
 */
public class Sync3LazySingletonPractice {

    private static Sync3LazySingletonPractice instance;

    public static Sync3LazySingletonPractice getInstance(){
        //第一次判断，避免每次进来都要上锁
        if (instance==null){
            synchronized (Sync3LazySingletonPractice.class){
                if (instance==null){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Sync3LazySingletonPractice();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Sync3LazySingletonPractice.getInstance().hashCode());
            }).start();
        }
    }
}
