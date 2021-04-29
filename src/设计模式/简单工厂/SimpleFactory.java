package 设计模式.简单工厂;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
public class SimpleFactory {
    //SimpleFactory 是简单工厂实现，它被所有需要进行实例化的客户类调用。
    public Product createProduct(int type){
        if (type == 1) return new ConcreteProduct1();
        else if (type == 2) return new ConcreteProduct2();
        return new ConcreteProduct();
    }
}
