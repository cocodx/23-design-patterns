package liug.ds.learn.behavior.command;

/**
 * 命令模式
 * @author amazfit
 * @date 2022-06-14 下午8:03
 **/
public class CommandPracticeDay3 {

    public static class Light{
        public void on(){
            System.out.println("开灯！");
        }
    }

    public static interface Command{
        public void execute();
    }

    public static class LightOnCommand implements Command{
        Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.on();
        }
    }

    public static class SimpleRemoteControl{
        Command slot;

        public void setSlot(Command slot) {
            this.slot = slot;
        }

        public void buttonWasPressed(){
            slot.execute();
        }
    }

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        remote.setSlot(lightOnCommand);
        remote.buttonWasPressed();
    }

}
