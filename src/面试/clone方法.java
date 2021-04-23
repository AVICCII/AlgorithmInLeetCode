package 面试;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class clone方法 {


    public static class CloneExample implements Cloneable{
        private int a;
        private int b;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) {
        CloneExample e1 = new CloneExample();
// CloneExample e2 = e1.clone(); // 'clone()' has protected access in 'java.lang.Object'
        try{
            CloneExample e2 = (CloneExample) e1.clone();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

}
