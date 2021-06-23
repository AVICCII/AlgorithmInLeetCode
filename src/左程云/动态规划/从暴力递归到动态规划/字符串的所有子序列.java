package 左程云.动态规划.从暴力递归到动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2021/6/23
 * @Discrimination
 */
public class 字符串的所有子序列  {

    public static List<String> subs(String s){
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str,0,ans,path);
        return ans;
    }

    //str是固定参数
    //index是此时来到的位置
    //ans是结果集(如果index来到了str中的终止位置，那么加入结果集)
    //path是沿途路径(终止位置前的str状态)
    private static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length){
            ans.add(path);
            return;
        }
        String no = path;
        process1(str,index+1,ans,no);
        String yes = path + String.valueOf(str[index]);
        process1(str,index+1,ans,yes);
    }

//    private static void CheckSubSequence(String target,int startPos,List<String> ans,String path){
//        char[] targetCharArr = target.toCharArray();
//        if (startPos == targetCharArr.length) {
//            ans.add(path);
//            return;
//        }
//        String no = path;
//        CheckSubSequence(target,startPos,ans,no);
//        String yes = path + String.valueOf(targetCharArr[startPos]);
//        CheckSubSequence(target,startPos,ans,yes);
//    }



}
