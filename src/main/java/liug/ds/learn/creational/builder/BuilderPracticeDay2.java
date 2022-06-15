package liug.ds.learn.creational.builder;

import lombok.Data;
import lombok.ToString;

/**
 * builder pattern
 * @author amazfit
 * @date 2022-06-16 上午7:32
 **/
public class BuilderPracticeDay2 {

    @ToString
    @Data
    public static class Item{
        private String itemName;
        private Integer type;
        private String code;
        private String url;
    }

    @Data
    public static abstract class ItemBuilder{
        protected Item item = new Item();
        public abstract void buildNormal();

        public abstract void buildCard();

        public abstract void buildVideo();

        //返回产品对象
    }

    public static class ItemConcreteBuilder extends ItemBuilder{

        @Override
        public void buildNormal() {
            item.setItemName("普通商品");
            item.setType(1);
        }

        @Override
        public void buildCard() {
            item.setItemName("卡卷商品");
            item.setType(2);
            item.setCode("123456");
        }

        @Override
        public void buildVideo() {
            item.setItemName("视频商品");
            item.setType(3);
            item.setUrl("http://www.baidu.com");
        }
    }

    @Data
    public static class ItemDirector{
        private ItemBuilder itemBuilder;

        public Item normalConstruct(){
            itemBuilder.buildNormal();
            return itemBuilder.getItem();
        }
        public Item cardConstruct(){
            itemBuilder.buildCard();
            return itemBuilder.getItem();
        }
        public Item videoConstruct(){
            itemBuilder.buildVideo();
            return itemBuilder.getItem();
        }
    }

    public static void main(String[] args) {
        Item item = new Item();
        ItemBuilder builder = new ItemConcreteBuilder();
        ItemDirector itemDirector = new ItemDirector();

        itemDirector.setItemBuilder(builder);
        Item item1 = itemDirector.normalConstruct();
        System.out.println(item1);

        Item item2 = itemDirector.cardConstruct();
        System.out.println(item2);

        Item item3 = itemDirector.videoConstruct();
        System.out.println(item3);
    }



}
