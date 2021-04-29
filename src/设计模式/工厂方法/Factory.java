package 设计模式.工厂方法;

import 设计模式.简单工厂.Product;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */

//定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化操作推迟到子类。
public abstract class Factory {
    abstract public Product factoryMethod();
    public void doSomething(){
        Product product = factoryMethod();
        //do something with product
    }
}
