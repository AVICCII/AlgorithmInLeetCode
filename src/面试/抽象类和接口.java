package 面试;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 抽象类和接口 {

    public abstract static class AbstractClassExample{
        protected int x;
        private int y;

        public abstract void func1();

        public void func2(){
            System.out.println("func2");
        }
    }

    public static class AbstractExtendClassExample extends AbstractClassExample{

        @Override
        public void func1() {
            System.out.println("func1");
        }
    }


    public interface InterfaceExample{
        void func1();

        default void func2(){
            System.out.println("func2");
        }

        int x = 123;
        public int z = 0;
    }

    public static class InterfaceImplementExample implements InterfaceExample{

        @Override
        public void func1() {
            System.out.println("func1");
        }
    }


    public static void main(String[] args) {
        AbstractClassExample ac2 = new AbstractExtendClassExample();
        ac2.func1();

        //---------------------------------------------------------//
        InterfaceExample ie2 = new InterfaceImplementExample();
        ie2.func1();
        System.out.println(InterfaceExample.x);
    }
}
