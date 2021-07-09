package normal;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author aviccii 2021/7/6
 * @Discrimination
 */
public class case1418_点菜展示表 {
    public static List<List<String>> displayTable(List<List<String>> orders){
        List<List<String>> ans = new ArrayList<>();
        Set<String> foodSet = new HashSet<>();
        Set<Integer> tableSet = new HashSet<>();

        HashMap<Integer,HashMap<String,Integer>> menu = new HashMap<>();
        for (List<String> order : orders) {
            String table = order.get(1);
            int tableNum = Integer.parseInt(table);
            tableSet.add(tableNum);
            String foodName = order.get(2);
            foodSet.add(foodName);
            HashMap<String, Integer> tableMenu = menu.getOrDefault(tableNum, new HashMap<String, Integer>());
            tableMenu.put(foodName,tableMenu.getOrDefault(foodName,0)+1);
            menu.put(tableNum,tableMenu);
        }
        List<String> foodList = new ArrayList<>(foodSet);
        List<Integer> tableList = new ArrayList<>(tableSet);
        Collections.sort(foodList);
        Collections.sort(tableList);
        foodList.add(0,"Table");
        ans.add(foodList);


        for (int s : tableList) {

            HashMap<String, Integer> map = menu.get(Integer.parseInt(String.valueOf(s)));
            List<String> res = new ArrayList<>();
            res.add(String.valueOf(s));
            for (int i = 1; i < foodList.size(); i++) {
                int num = map.getOrDefault(foodList.get(i),0);
                res.add(i,String.valueOf(num));
            }
            ans.add(res);
        }
        return ans;
    }

}
