package 设计模式.抽象工厂;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
        //do something with A&B
    }
}
