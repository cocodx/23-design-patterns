package liug.ds.learn.creational.simplefactory;

/**
 * @author 正能量导师
 * @date 2022/6/18-15:40
 * @Description
 */
public class SimpleFactoryPracticeDay1 {

    public static interface Api{
        //任意想要打印输出的字符串
        public void test1(String s);
    }

    public static class Impl implements Api{

        @Override
        public void test1(String s) {
            System.out.println("Now in Impl,The input s=="+s);
        }
    }

    public static void main(String[] args) {
        Api api = new Impl();
        api.test1("laugh,don't affarid");
    }



}
