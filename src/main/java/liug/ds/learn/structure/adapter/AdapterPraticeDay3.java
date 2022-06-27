package liug.ds.learn.structure.adapter;

/**
 * @author amazfit
 * @date 2022-06-27 下午10:39
 **/
public class AdapterPraticeDay3 {

    public static interface Target{
        public void request();
    }

    public static class Adaptee{
        public void specificRequest(){
            System.out.println("适配者中的业务代码被调用！");
        }
    }

    public static class ClassAdapter extends  Adaptee implements Target{

        @Override
        public void request() {
            specificRequest();
        }
    }

    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
