package liug.ds.learn.behavior.template;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 模板模式，在一个抽象类中公开定义它的方法的模板，子类按需要重写方法实现，但调用以抽象类中定义的方式执行
 * @date 7/2/2022 下午9:19
 */
public class TemplatePractice {

    public static abstract class Game{
        abstract void initialize();
        abstract void startPlay();
        abstract void endPlay();

        public final void play(){
            initialize();
            startPlay();
            endPlay();
        }
    }

    public static class Cricket extends Game {
        @Override
        void endPlay() {
            System.out.println("Cricket Game Finished!");
        }
        @Override
        void initialize() {
            System.out.println("Cricket Game Initialized! Start playing.");
        }
        @Override
        void startPlay() {
            System.out.println("Cricket Game Started. Enjoy the game!");
        }
    }

    public static class Football extends Game {
        @Override
        void endPlay() {
            System.out.println("Football Game Finished!");
        }
        @Override
        void initialize() {
            System.out.println("Football Game Initialized! Start playing.");
        }
        @Override
        void startPlay() {
            System.out.println("Football Game Started. Enjoy the game!");
        }
    }

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        Game game1 = new Football();
        game1.play();
    }


}
