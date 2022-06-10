package liug.ds.learn.behavior.strategy;

/**
 * 策略模式
 * @author amazfit
 * @date 2022-06-10 下午10:13
 **/
public class StrategyPraticeDay1 {


    public static interface Strategy{
        public int doOperation(int num1,int num2);
    }

    public static class OperationAdd implements Strategy{

        @Override
        public int doOperation(int num1, int num2) {
            return num1+num2;
        }
    }

    public static class OperationSubtract implements Strategy{

        @Override
        public int doOperation(int num1, int num2) {
            return num1-num2;
        }
    }
    public static class OperationMultiply implements Strategy{

        @Override
        public int doOperation(int num1, int num2) {
            return num1 * num2;
        }
    }

    /**
     * 使用context来查看当它的改变策略Strategy时的行为变化
     */
    public static class Context{
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public int executeStrategy(int num1,int num2){
            return strategy.doOperation(num1,num2);
        }
    }

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10+5="+context.executeStrategy(10,5));

        context = new Context(new OperationSubtract());
        System.out.println("10-5="+context.executeStrategy(10,5));

        context = new Context(new OperationMultiply());
        System.out.println("10*5="+context.executeStrategy(10,5));
    }
}
