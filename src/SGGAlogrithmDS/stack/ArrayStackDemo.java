package SGGAlogrithmDS.stack;

import java.lang.reflect.Array;

/**
 * @author aviccii 2020/10/27
 * @Discrimination
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(3);
        arrayStack.push(3);
        arrayStack.push(3);
        arrayStack.push(3);
        arrayStack.list();
    }
}

//定义一个ArrayStack表示栈
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组中
    private int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈-push
    public void push(int value){
        //先判断栈是否满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈-pop
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    //显示栈的情况，遍历时，需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，无数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}