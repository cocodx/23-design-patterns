package liug.ds.learn.structure.facade;

/**
 *
 * 为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 * @author amazfit
 * @date 2022-06-10 下午9:35
 **/
public class FacadePraticeDay1 {

    public static interface Shape{
        void draw();
    }

    public static class Square implements Shape{

        @Override
        public void draw() {
            System.out.println("square::draw()");
        }
    }

    public static class Circle implements Shape{

        @Override
        public void draw() {
            System.out.println("Circle::draw()");
        }
    }

    public static class ShapeMaker{
        private Shape circle;
        private Shape square;

        public ShapeMaker() {
            this.circle = new Circle();
            this.square = new Square();
        }

        public void drawCircle(){
            circle.draw();
        }

        public void drawSquare(){
            square.draw();
        }
    }

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
    }

}
