package liug.ds.learn.structure.facade;

/**
 * @author amazfit
 * @date 2022-06-19 下午9:44
 **/
public class FacadePracticeDay22 {

    public static interface AModuleApi{
        public void testA();
    }

    public static class AModuleImpl implements AModuleApi{

        @Override
        public void testA() {
            System.out.println("现在在A模块里面操作testA方法");
        }
    }

    public static interface BModuleApi{
        public void testB();
    }

    public static class BModuleImpl implements BModuleApi{

        @Override
        public void testB() {
            System.out.println("现在在B模块操作testB方法");
        }
    }

    public static interface CModuleApi{
        public void testC();
    }

    public static class CModuleImpl implements CModuleApi{

        @Override
        public void testC() {
            System.out.println("现在C模块操作testC方法");
        }
    }

    public static class Facade{
        public void test(){
            AModuleApi aModuleApi = new AModuleImpl();
            BModuleApi bModuleApi = new BModuleImpl();
            CModuleApi cModuleApi = new CModuleImpl();
            aModuleApi.testA();
            bModuleApi.testB();
            cModuleApi.testC();
        }
    }

    public static void main(String[] args) {
        new Facade().test();
    }


}
