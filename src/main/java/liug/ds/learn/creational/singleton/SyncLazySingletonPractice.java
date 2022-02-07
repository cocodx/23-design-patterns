package liug.ds.learn.creational.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 7/2/2022 上午1:03
 */
public class SyncLazySingletonPractice {

    private static SyncLazySingletonPractice instance = null;

    /**
     * 设置成private，只能在这个类里面new，其他类new不出来
     */
    private SyncLazySingletonPractice(){}

    //锁住SyncLazySingletonPractice.class对象
    //效率降低了，每次获取都得拿锁
    public static synchronized SyncLazySingletonPractice getInstance(){
        if (instance == null){
            instance = new SyncLazySingletonPractice();
        }
        return instance;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SyncLazySingletonPractice.getInstance().hashCode());
            }).start();
        }
    }
}
