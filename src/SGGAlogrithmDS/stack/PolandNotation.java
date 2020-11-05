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
        //将得到的中缀表达式对应的list => 转成一个后缀表达式对应的List
        //  即 ArrayList [1,+,(,(,2,+,3,),x,4,),-,5] =》ArrayList 1 2 3 + 4 x + 5 -

        String expression = "1+((2+3)*4)-5";

        List<String> strings = toInfixExpressionList(expression);
        System.out.println("后缀表达式对应的List"+strings);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(strings);
        System.out.println("后缀表达式对应的List"+parseSuffixExpressionList);


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



    //  即 ArrayList [1,+,(,(,2,+,3,),x,4,),-,5] =》ArrayList 1 2 3 + 4 x + 5 -
    //方法：将得到的中缀表达式对应的list => 转成一个后缀表达式对应的List

    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        //说明：因为s2在整个转换过程中没有pop的操作，同时还需要最后逆序，这里不适用栈，使用队列List<String> S2
        List<String> s2 = new ArrayList<>();//存储中间结果的s2

        //遍历ls
        for (String item : ls) {
            //如果是一个数，就入栈
            if (item.matches("\\d+")){
                s2.add(item);
            } else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                //如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2,直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将匹配的左括号弹出
            }else {
                //当item的优先级小于等于栈顶运算符
                //将s1栈顶的运算符弹出并压入到s2中，再次转到上步骤与新的栈顶运算符进行比较
                //问题：我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出到s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;//注意因为是存放到List,因此按顺序输出就是对应的后缀表达式
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

//编写一个类，Operation 可以返回运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result =ADD;
                break;
            case "-":
                result =SUB;
                break;
            case "*":
                result =MUL;
                break;
            case "/":
                result =DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}