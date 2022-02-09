package liug.ds.learn.structure.bridge;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 桥接模式
 * @date 9/2/2022 下午11:57
 */
public class BridgePracticeDay1 {
    //这个interface就是一个桥，在构造方法里可以注入不同的实现类
    public static interface Brand{
        void sale();
    }
    public static class Lenovo implements Brand{

        @Override
        public void sale() {
            System.out.println("卖联想电脑");
        }
    }
    public static class Dell implements Brand{

        @Override
        public void sale() {
            System.out.println("卖戴尔电脑");
        }
    }
    public static class Computer{
        protected Brand brand;

        public Computer(Brand brand) {
            this.brand = brand;
        }
        public void sale(){
            brand.sale();
        }
    }
    public static class Desktop extends Computer{

        public Desktop(Brand brand) {
            super(brand);
        }

        @Override
        public void sale() {
            super.sale();
            System.out.println("销售台式机");
        }
    }
    public static class Laptop extends Computer{

        public Laptop(Brand brand) {
            super(brand);
        }

        @Override
        public void sale() {
            super.sale();
            System.out.println("销售笔记本");
        }
    }

    public static void main(String[] args) {
        Computer lenovo = new Laptop(new Lenovo());
        lenovo.sale();

        Computer dell = new Desktop(new Dell());
        dell.sale();
    }
}
