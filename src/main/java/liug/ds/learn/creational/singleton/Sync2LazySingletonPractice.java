package liug.ds.learn.creational.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 7/2/2022 上午1:06
 */
public class Sync2LazySingletonPractice {

    private static Sync2LazySingletonPractice instance = null;

    /**
     * 设置成private，只能在这个类里面new，其他类new不出来
     */
    private Sync2LazySingletonPractice(){}

    //锁住SyncLazySingletonPractice.class对象
    //效率降低了，每次获取都得拿锁
    public static Sync2LazySingletonPractice getInstance(){
            if (instance == null){

                //减少同步代码块的方式提高效率，但是不可行
                synchronized (Sync2LazySingletonPractice.class){
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Sync2LazySingletonPractice();
                }
            }
        return instance;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Sync2LazySingletonPractice.getInstance().hashCode());
            }).start();
        }
    }
}
