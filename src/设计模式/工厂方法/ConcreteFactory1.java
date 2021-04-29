package 设计模式.工厂方法;

import 设计模式.简单工厂.ConcreteProduct;
import 设计模式.简单工厂.ConcreteProduct1;
import 设计模式.简单工厂.Product;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
public class ConcreteFactory1 extends Factory{

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
