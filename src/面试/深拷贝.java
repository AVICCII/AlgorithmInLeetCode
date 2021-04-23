package 面试;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 深拷贝 {
    public static class DeepCloneExample implements Cloneable{
        private int[] arr;

        public DeepCloneExample() {
            arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public void set(int index, int value) {
            arr[index] = value;
        }

        public int get(int index) {
            return arr[index];
        }

        @Override
        protected DeepCloneExample  clone() throws CloneNotSupportedException {
            DeepCloneExample res = (DeepCloneExample) super.clone();
            res.arr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                res.arr[i] = arr[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        DeepCloneExample e1 = new DeepCloneExample();
        DeepCloneExample e2 = null;

        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        e1.set(2,222);
        System.out.println(e2.get(2));
    }
}
