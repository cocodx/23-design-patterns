package liug.ds.learn.behavior.state;

/**
 *
 * 类的行为是基于它的状态改变的
 *
 * 状态模式
 * @author amazfit
 * @date 2022-06-10 下午10:21
 **/
public class StatePraticeDay1 {

    public static interface State{
        public void doAction(Context context);
    }

    public static class StartState implements State{

        @Override
        public void doAction(Context context) {
            System.out.println("Player is in start state");
            context.setState(this);
        }

        @Override
        public String toString() {
            return "Start State";
        }
    }

    public static class StopState implements State{

        @Override
        public void doAction(Context context) {
            System.out.println("Player is in start state");
            context.setState(this);
        }

        @Override
        public String toString() {
            return "Stop State";
        }
    }

    public static class Context{
        private State state;

        public Context() {
            this.state = null;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }

}
