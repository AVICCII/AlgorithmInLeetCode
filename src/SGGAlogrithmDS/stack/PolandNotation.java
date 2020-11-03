package SGGAlogrithmDS.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author aviccii 2020/11/3
 * @Discrimination
 */
public class PolandNotation {
    public static void main(String[] args) {

        //完成一个中缀表达式转成后缀表达式的功能
        //说明
        //1.1+((2+3)x4)-5 => 转成1 2 3 + 4 x + 5 -
        //2.因为直接对str进行操作，不方便，因此先将 "1+((2+3)x4)-5" => 中缀表达式对应的list
        // 即"1+((2+3)x4)-5" => ArrayList [1,+,(,(,2,+,3,),x,4,),-,5]

        String expression = "1+((2+3)*4)-5";

        List<String> strings = toInfixExpressionList(expression);
        System.out.println(strings);


        //先定义一个逆波兰表达式
        //(3+4)x5-6  =>  3 4 + 5 x 6 -
        //说明为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 - ";
        //思路
        //1.先将suffixExpression放到ArrayList里
        //2.将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算

        List<String> rpnList = getListString(suffixExpression);
        int res = calculate(rpnList);
        System.out.println(res);
    }

    //方法：将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s){
        //定义一个List存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0;//这是一个指针，用于遍历s
        String str;//多位数拼接
        char c;//每遍历一个字符，就放到c
        do {
            //如果c是一个非数字，需要加入到ls里
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(c+"");
                i++;//i后移
            }else {//如果是一个数要考虑多位数
                str="";//先将Str置空
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str +=c;//拼接
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }

    //将一个逆波兰表达式依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    /*
    1.从左至右扫描，将3和4压入堆栈
    遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，将7再入栈
    将5入栈
    接下来是x运算符，所以弹出5和7，计算出7x5=35，将35入栈
    将6入栈
    最后是-运算符，计算出35-6=29即最终结果
     */
    public static int calculate(List<String> ls) {
        //创建一个栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        //遍历
        for (String s : ls) {
            //使用正则表达式取出数
            if (s.matches("\\d+")) { //匹配的是多位数
                //入栈
                stack.push(s);
            } else {
                //pop出两个数再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else if (s.equals("/")) {
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                //将结果入栈
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
