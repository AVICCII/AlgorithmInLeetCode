package 面试;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class super类 {

    public static class SuperExample{
        protected int x;
        protected int y;

        public SuperExample(int x,int y){
            this.x = x;
            this.y = y;
        }

        public void func(){
            System.out.println("SuperExample.func()");
        }
    }

    public static class SuperExtendExample extends SuperExample{

        private int z;

        public SuperExtendExample(int x, int y, int z) {
            //子类一定会调用父类的构造函数来完成初始化工作
            super(x, y);
            this.z = z;
        }

        @Override
        public void func() {
            super.func();
            System.out.println("SuperExtendExample.func()");
        }
    }

    public static void main(String[] args) {
        SuperExample e = new SuperExtendExample(1, 2, 3);
        e.func();
    }


}
