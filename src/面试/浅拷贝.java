package 面试;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 浅拷贝 {

    public static class shallowCloneExample implements Cloneable{

        private int[] arr;


        public  shallowCloneExample(){
            arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public void set(int index,int value){
            arr[index] = value;
        }

        public int get(int index){
            return arr[index];
        }

        @Override
        protected shallowCloneExample  clone() throws CloneNotSupportedException {
            return (shallowCloneExample) super.clone();
        }
    }

    public static void main(String[] args) {
        shallowCloneExample e1 = new shallowCloneExample();
        shallowCloneExample e2 = null;

        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //浅拷贝：拷贝对象和原始对象的引用都是一个对象，因此对拷贝对象的引用的操作会影响原始对象
        e1.set(2,222);
        System.out.println(e2.get(2));//222
        System.out.println(e1.get(2));//222
    }

}
