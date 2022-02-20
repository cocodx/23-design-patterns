package liug.ds.learn.creational.builder;

/**
 * @author 正能量导师
 * @version 1.0
 * @description this模式的建造者,没有Director类
 * @date 20/2/2022 下午8:17
 */
public class BuilderNotClassicPracticeDay1 {

    //实际要构建的对象
    public static class Computer{
        private String cpu;
        private String ram;
        private int usbCount;
        private String keyboard;
        private String display;
        private String part1;
        private String part2;

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }

        public String getRam() {
            return ram;
        }

        public void setRam(String ram) {
            this.ram = ram;
        }

        public int getUsbCount() {
            return usbCount;
        }

        public void setUsbCount(int usbCount) {
            this.usbCount = usbCount;
        }

        public String getKeyboard() {
            return keyboard;
        }

        public void setKeyboard(String keyboard) {
            this.keyboard = keyboard;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        public String getPart1() {
            return part1;
        }

        public void setPart1(String part1) {
            this.part1 = part1;
        }

        public String getPart2() {
            return part2;
        }

        public void setPart2(String part2) {
            this.part2 = part2;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "cpu='" + cpu + '\'' +
                    ", ram='" + ram + '\'' +
                    ", usbCount=" + usbCount +
                    ", keyboard='" + keyboard + '\'' +
                    ", display='" + display + '\'' +
                    ", part1='" + part1 + '\'' +
                    ", part2='" + part2 + '\'' +
                    '}';
        }
    }

    public abstract static class AbstractBuilder{
        abstract Computer getComputer();
        abstract AbstractBuilder builderCpu(String cpu);
        abstract AbstractBuilder builderRam(String ram);
        abstract AbstractBuilder builderUsbCount(int usbCount);
        abstract AbstractBuilder builderKeyboard(String keyboard);
        abstract AbstractBuilder builderDisplay(String display);
        abstract AbstractBuilder builderPart1(String part1);
        abstract AbstractBuilder builderPart2(String part2);
    }

    public static class ConcreteBuilder extends AbstractBuilder{
        private Computer computer;

        public ConcreteBuilder() {
            computer = new Computer();
        }

        @Override
        Computer getComputer() {
            return this.computer;
        }

        @Override
        AbstractBuilder builderCpu(String cpu) {
            this.computer.setCpu(cpu);
            return this;
        }

        @Override
        AbstractBuilder builderRam(String ram) {
            this.computer.setRam(ram);
            return this;
        }

        @Override
        AbstractBuilder builderUsbCount(int usbCount) {
            this.computer.setUsbCount(usbCount);
            return this;
        }

        @Override
        AbstractBuilder builderKeyboard(String keyboard) {
            this.computer.setKeyboard(keyboard);
            return this;
        }

        @Override
        AbstractBuilder builderDisplay(String display) {
            this.computer.setDisplay(display);
            return this;
        }

        @Override
        AbstractBuilder builderPart1(String part1) {
            this.computer.setPart1(part1);
            return this;
        }

        @Override
        AbstractBuilder builderPart2(String part2) {
            this.computer.setPart2(part2);
            return this;
        }
    }

    public static void main(String[] args) {
        AbstractBuilder builder = new ConcreteBuilder();
        AbstractBuilder builder1 = new ConcreteBuilder();

        Computer computer1 = builder.builderCpu("inter").builderDisplay("LG display").builderKeyboard("keyboard").getComputer();
        Computer computer2 = builder1.builderCpu("amd").builderDisplay("PHILIPS display").builderPart2("蝰蛇鼠标").getComputer();
        System.out.println(computer1.toString());
        System.out.println(computer2.toString());
    }
}
