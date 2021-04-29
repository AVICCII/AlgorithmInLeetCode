package 设计模式.单例模式;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
//一般为了实现单例模式，会把构造器私有化，然后通过静态方法和静态变量来获取一个对象。
    //懒汉式，线程不安全
public class Singleton {
        //静态变量
        private static Singleton singleton;

        //构造器私有化
        private Singleton(){};

        //静态方法
        public static Singleton getInstance(){
            //可以使用synchronize修饰该方法来实现线程安全，但是效率较差
            if (singleton == null) singleton = new Singleton();
            return singleton;
    }
}

//饿汉式
//比较常用的一种方法，使用classLoder机制避免了多线程同步问题。但是会产生垃圾对象，浪费内存。
class Singleton2{
    private static Singleton2 instance = new Singleton2();
    private Singleton2(){};
    public static Singleton2 getInstance(){
        return instance;
    }
}

/*
    double Check
 */
//采用懒加载模式，同样也是线程安全的。采用双锁机制，在多线程模式下也能保持高性能

//如果只使用了一个 if 语句。在 uniqueInstance == null 的情况下，如果两个线程都执行了 if 语句，那么两个线程都会进入 if 语句块内。
// 虽然在 if 语句块内有加锁操作，但是两个线程都会执行 uniqueInstance = new Singleton(); 这条语句，只是先后的问题，那么就会进行两次实例化。
// 因此必须使用双重校验锁，也就是需要使用两个 if 语句：第一个 if 语句用来避免 uniqueInstance 已经被实例化之后的加锁操作，
// 而第二个 if 语句进行了加锁，所以只能有一个线程进入，就不会出现 uniqueInstance == null 时两个线程同时进行实例化操作。
class DoubleCheckSingleton{
    private static DoubleCheckSingleton doubleCheckSingleton;
    private DoubleCheckSingleton(){};

    public static DoubleCheckSingleton getInstance(){
        //firstCheck
        if (doubleCheckSingleton== null) synchronized (DoubleCheckSingleton.class){
            //SecondCheck
            if (doubleCheckSingleton == null) doubleCheckSingleton = new DoubleCheckSingleton();
        }
        return doubleCheckSingleton;
    }
}

//静态内部类实现

/*
静态内部类只有当被外部类调用到的时候才会初始化
 */

//当 Singleton 类被加载时，静态内部类 SingletonHolder 没有被加载进内存。
// 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载，
// 此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
//这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
class SingletonStaticInnerClassImpl{
    private SingletonStaticInnerClassImpl(){};

    private static class SingletonHolder{
        private static final SingletonStaticInnerClassImpl INSTANCE = new SingletonStaticInnerClassImpl();
    }

    public static SingletonStaticInnerClassImpl getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }
}