package 设计模式.抽象工厂;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
public abstract class AbstractFactory {
    abstract AbstractProductA createProductA();
    abstract AbstractProductB createProductB();
}
