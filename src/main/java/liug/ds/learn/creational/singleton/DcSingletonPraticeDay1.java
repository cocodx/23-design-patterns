package liug.ds.learn.creational.singleton;

/**
 * @author amazfit
 * @date 2022-06-13 下午7:56
 **/
public class DcSingletonPraticeDay1 {


        private volatile static DcSingletonPraticeDay1 day1=null;

        private DcSingletonPraticeDay1(){}

        public static DcSingletonPraticeDay1 getInstance(){
            if (day1==null) {
                synchronized (DcSingletonPraticeDay1.class){
                    if (day1==null){
                        day1 = new DcSingletonPraticeDay1();
                    }
                }
            }
            return day1;
        }

}
