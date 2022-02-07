package liug.ds.learn.creational.singleton;

/**
 * @author 正能量导师
 * @version 1.0
 * @description enum，不仅可以解决线程同步，还可以防止反序列化
 * @date 7/2/2022 上午1:23
 */
public enum EnumSingletonPractice {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(EnumSingletonPractice.INSTANCE.hashCode());
            }).start();
        }
    }
}
