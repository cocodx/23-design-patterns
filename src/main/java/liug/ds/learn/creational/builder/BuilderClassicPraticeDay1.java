package liug.ds.learn.creational.builder;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 建造者模式
 * 将一个复杂对象的构建
 * @date 20/2/2022 下午6:39
 */
public class BuilderClassicPraticeDay1 {

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

    public static interface ProductBuilder{
        void builderCpu(String cpu);
        void builderRam(String ram);
        void builderUsbCount(String usbCount);
        void builderKeyboard(String keyboard);
        void builderDisplay(String display);
        void builderPart1(String part1);
        void builderPart2(String part2);

        Computer getComputer();
    }

    public static class DefaultConcreteProductBuilder implements ProductBuilder{
        private Computer computer = new Computer();
        private String cpu;
        private String ram;
        private int usbCount;
        private String keyboard;
        private String display;
        private String part1;
        private String part2;

        public Computer getComputer() {
            return computer;
        }

        @Override
        public void builderCpu(String cpu) {

        }

        @Override
        public void builderRam(String ram) {

        }

        @Override
        public void builderUsbCount(String usbCount) {

        }

        @Override
        public void builderKeyboard(String keyboard) {

        }

        @Override
        public void builderDisplay(String display) {

        }

        @Override
        public void builderPart1(String part1) {

        }

        @Override
        public void builderPart2(String part2) {

        }
    }

    public static class Director{
        private ProductBuilder builder = null;

        public Director(ProductBuilder builder) {
            this.builder = builder;
        }

        public Computer computer1(String cpu, String display, String part1){
            builder.builderCpu(cpu);
            builder.builderDisplay(display);
            builder.builderPart1(part1);
            return builder.getComputer();
        }

        public Computer computer2( String display, String part1){
            builder.builderDisplay(display);
            builder.builderPart1(part1);
            return builder.getComputer();
        }

    }

    public static void main(String[] args) {
        Director director = new Director(new DefaultConcreteProductBuilder());
        Computer computer = director.computer1("inter","LG显示器","part1");
        Computer computer2 = director.computer1("amd","PHILIPS 显示器","part1");
        System.out.println(computer.toString());
        System.out.println(computer2.toString());
    }

}
