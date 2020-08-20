package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aviccii 2020/8/20
 * @Discrimination 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 *
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 *
 */
public class Case29destCity {
    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap<>();
        // 将所有路径的起点与终点存入map
        for(List<String> list : paths){
            map.put(list.get(0), list.get(1));
        }
        for(String s : map.keySet()){
            // 如果某个路径的终点不是另一个路径的起点，则该点就是旅行终点
            if(map.get(map.get(s)) == null){
                return map.get(s);
            }
        }
        // 返回默认null，由题意是不会走到这里返回的
        return null;
    }

}
