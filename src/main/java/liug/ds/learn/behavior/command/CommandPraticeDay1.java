package liug.ds.learn.behavior.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式
 * @author amazfit
 * @date 2022-06-10 下午9:56
 **/
public class CommandPraticeDay1 {

    /**
     * 命令接口
     */
    public static interface Order{
        void execute();
    }

    //请求类
    public static class Stock {
        private String name="ABC";
        private int quantity=10;

        public void buy(){
            System.out.println("Stock [ name: "+name+", Quantity: "+quantity+" ] bought");
        }
        public void sell(){
            System.out.println("Stock [ Name: "+name+", Quantity: "+quantity+" ] quantity sold");
        }
    }

    public static class BuyStock implements Order{
        private Stock abcStock;

        public BuyStock(Stock abcStock) {
            this.abcStock = abcStock;
        }

        @Override
        public void execute() {
            abcStock.sell();
        }
    }

    public static class SellStock implements Order{
        private Stock abcStock;

        public SellStock(Stock abcStock) {
            this.abcStock = abcStock;
        }

        @Override
        public void execute() {
            abcStock.sell();
        }
    }

    //命令类的存放集合，存放集合类，顺序执行
    public static class Borker{
        private List<Order> orderList = new ArrayList<>();

        public void takeOrder(Order order){
            orderList.add(order);
        }

        public void placeOrders(){
            for (Order order:orderList){
                order.execute();
            }
            orderList.clear();
        }
    }

    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Borker borker = new Borker();
        borker.takeOrder(buyStockOrder);
        borker.takeOrder(sellStockOrder);

        borker.placeOrders();
    }

}
