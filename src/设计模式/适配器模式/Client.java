package 设计模式.适配器模式;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
public class Client {
    public static void main(String[] args) {
        WildTurkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack();

    }
}
