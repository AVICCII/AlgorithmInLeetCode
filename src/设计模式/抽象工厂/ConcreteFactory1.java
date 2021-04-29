package 设计模式.抽象工厂;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
public class ConcreteFactory1 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}
