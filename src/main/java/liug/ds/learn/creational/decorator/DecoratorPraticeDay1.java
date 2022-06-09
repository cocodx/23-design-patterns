package liug.ds.learn.creational.decorator;

/**
 * 装饰者模式
 * @author amazfit
 * @date 2022-06-10 上午7:21
 **/
public class DecoratorPraticeDay1 {

    public static interface Shape{
        //绘制图形
        void draw();
    }

    public static class Circle implements Shape{

        @Override
        public void draw() {
            System.out.println("绘制圆形");
        }
    }

    public static class Rectangle implements Shape{

        @Override
        public void draw() {
            System.out.println("绘制方形");
        }
    }

    public static abstract class ShapeDecorator implements Shape{
        protected Shape decoratedShape;

        public ShapeDecorator(Shape decoratedShape) {
            this.decoratedShape = decoratedShape;
        }

        public void draw(){
            decoratedShape.draw();
        }
    }

    public static class RedShapeDecorator extends ShapeDecorator{

        public RedShapeDecorator(Shape decoratedShape) {
            super(decoratedShape);
        }

        @Override
        public void draw() {
            decoratedShape.draw();
            setRedBorder(decoratedShape);
        }

        private void setRedBorder(Shape decoratedShape){
            System.out.println("Border Color: Red");
        }
    }

    public static class SizeShapeDecorator extends RedShapeDecorator{

        public SizeShapeDecorator(Shape decoratedShape) {
            super(decoratedShape);
        }

        @Override
        public void draw() {
            super.draw();
            setSize(decoratedShape);
        }

        private void setSize(Shape decoratedShape){
            System.out.println("size: 100");
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator shapeDecorator = new RedShapeDecorator(circle);
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        ShapeDecorator sizeRedRectangle = new SizeShapeDecorator(redRectangle);
        sizeRedRectangle.draw();
    }

}
