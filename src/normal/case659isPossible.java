package normal;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author aviccii 2020/12/4
 * @Discrimination 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 */
public class case659isPossible {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,7,8,9,10,11};
    }

//    public static boolean isPossible(int[] nums) {
//        //base
////        if (nums.length < 6) {
////            return false;
////        }
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i]-nums[i-1]>1) return false;
//        }
//
//        HashMap<Integer, Integer> numHashMap = new HashMap<>();
//        for (int value : nums) {
//            int num = numHashMap.getOrDefault(value, 0);
//            if (num == 0) numHashMap.put(value, 1);
//            else numHashMap.put(value, ++num);
//        }
//        ArrayList<Integer> arrayList1 = new ArrayList<>();
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        int index = numHashMap.get(nums[0]);
//        int times = 0;
//        for (Integer i : numHashMap.keySet()) {
//            if (i ==1){
//                if (index == 1) arrayList1.add(nums[0]);
//                else{
//                    arrayList1.add(nums[0]);
//                    arrayList2.add(nums[0]);
//                }
//                continue;
//            }
//            int inIndex = numHashMap.get(i);
//            if (inIndex==0) continue;
//            if (times == 0) {
//                if (inIndex != index) {
//                    arrayList1.add(i);
//                    arrayList2.add(i);
//                    times++;
//                    index = 2;
//                    continue;
//                } else arrayList1.add(i);
//            }
//            if (times == 1) {
//                if (index == inIndex) {
//                    arrayList1.add(i);
//                    arrayList2.add(i);
//                } else {
//                    arrayList2.add(i);
//                    times++;
//                    continue;
//                }
//            }
//            if (times > 1) {
//                arrayList2.add(i);
//            }
//        }
//
//
//
//        for (Integer integer : arrayList1) {
//            System.out.println(integer);
//        }
//        System.out.println("-------");
//
//        for (Integer integer : arrayList2) {
//            System.out.println(integer);
//        }
//        return true;
//    }

    public  boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>());
            }
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

}
