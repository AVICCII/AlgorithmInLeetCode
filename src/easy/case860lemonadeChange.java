package easy;

import java.util.Stack;

/**
 * @author aviccii 2020/12/10
 * @Discrimination 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * <p>
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class case860lemonadeChange {

    public static void main(String[] args) {
        int[] bills = {10,10};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {

        int index5 = 0;
        int index10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i]==5) index5 ++;
            else if (bills[i]==10) {
                index5 --;
                index10 ++;
                if (index5 <0) return false;
            }
            else {
                if (index10!=0&&index5!=0) {
                    index5--;
                    index10 --;
                }else if (index10 ==0 && index5>2){
                    index5 -=3;
                }else return false;
            }
        }
        return true;
    }
}
