package 设计模式.简单工厂;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
//错误实现
//public class Client {
//    public static void main(String[] args) {
//        int type = 1;
//        Product product;
//        if (type == 1) product = new ConcreteProduct();
//        else if (type ==2) product = new ConcreteProduct1();
//        else product = new ConcreteProduct2();
//        //do something with product
//    }
//}

    //正确简单工厂实现
public class Client{
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        //do something with product
    }
}