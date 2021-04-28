package 面试;

import java.util.Stack;

/**
 * @author aviccii 2021/4/28
 * @Discrimination
 */
public class 全排序 {
    public static void main(String[] args) {
        perm(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new Stack());

    }

    public static void perm(int[] array, Stack stack) {
        if (array.length == 0) {
            System.out.println(stack);

        } else {
            for (int i = 0; i < array.length; i++) {
                int[] tempArray = new int[array.length - 1];

                System.arraycopy(array, 0, tempArray, 0, i);

                System.arraycopy(array, i + 1, tempArray, i, array.length - i - 1);

                stack.push(array[i]);

                perm(tempArray, stack);

                stack.pop();

            }

        }

    }

    public class test {

    }

}
