package SGGAlogrithmDS.LinkedList;

import java.util.Stack;

/**
 * @author aviccii 2020/10/20
 * @Discrimination
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        HeroNode heroNodeQz = new HeroNode(1, "茄子", "茂名磨刀石");
        HeroNode heroNodeDGQ = new HeroNode(2, "冬瓜强", "网络巨人");
        HeroNode heroNodeYJJ = new HeroNode(3, "YJJ", "马枪王子");

        //创建要给的链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNodeQz);
        singleLinkedList.addByOrder(heroNodeYJJ);
        singleLinkedList.addByOrder(heroNodeDGQ);

        //显示
        singleLinkedList.listLinkedList();
        reversePrint(singleLinkedList.getHead());


//        //测试修改节点的代码
//        HeroNode newHeroNodeDGQ = new HeroNode(2, "椰汁糕", "网络巨人！");
//        singleLinkedList.update(newHeroNodeDGQ);
//        //修改后的显示结果
//        singleLinkedList.listLinkedList();
//        singleLinkedList.del(1);
//        singleLinkedList.listLinkedList();
    }


    //方法：获取到单链表的节点的个数（如果是带头节点的链表，需要不统计头节点）

    /**
     *
     * @param head  链表的头节点
     * @return  返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量,这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur!=null){
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }


    //查找单链表中的倒数第k个节点
    //思路
    //1.编写一个方法，接收head节点，同时接收一个index
    //2.index表示倒数第Index个节点
    //3.先把链表从头到尾遍历一下，得到链表总的长度getLength
    //4.得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
    //5.如果找到了，则返回该节点，否则返回Null
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if (head.next==null){
            return null;
        }
        //第一次遍历得到链表的长度
        int size = getLength(head);
        //第二次遍历size - index位置，就是我们倒数第k个节点
        //先做一个数据的校验
        if (index<=0 || index >size){
            return null;
        }
        //定义给辅助变量,for循环定位到倒数的Index
        HeroNode cur = head.next;//3//3-1 =2
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }





    //将单链表反转
    public static void reverseList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回。
        if (head.next ==null || head.next.next == null){
            return;
        }
        //定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur.next!=null){
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新链表的头部
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;
        }
        head.next = reverseHead.next;
    }


    //倒序打印节点
    public static void reversePrint(HeroNode head){
        Stack<HeroNode> stack = new Stack<>();
        while (true){
            if (head.next == null) {
                break;
            }
            stack.push(head.next);
            head = head.next;
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }


}

//定义SingleLinkedList管理我们的hero
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0,
            "", "");

    //添加节点到单向链表
    //当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出循环后，temp就指向了链表的最后
        //将最后的这个节点的next指向新的节点
        temp.next = heroNode;
    }

    public HeroNode getHead(){
        return head;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(来帮助找到添加的位置)
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到了，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明需要添加的heroNode存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag){//不能添加，说明编号存在
            System.out.printf("准备插入的英雄编号 %d 已经存在了，不能加入\n",heroNode.no);
        }else {
            //插入到链表中，temp的后面
            heroNode.next= temp.next;
            temp.next=heroNode;
        }
    }


    //修改节点的信息，根据no编号来修改，即no编号不能改。
    //根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while(true){
            if(temp ==null){
                break;//到链表的最后，已经遍历完成
            }
            if (temp.no == newHeroNode.no){
                flag=true;//找到，退出
                break;
            }
            temp= temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else { //没有找到
            System.out.printf("没有找到编号 %d 的节点，不能修改\n",newHeroNode.no);
        }
    }

    //删除节点
    //思路
    //1.head不能动，因此我们需要一个temp节点来找到待删除节点的前一个节点
    //2.说明我们在比较的时候，是temp.next.no 和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no == no){
                //找到待删除节点的前一个节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //判断flag
        if (flag){//找到
            //可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在",no);
        }
    }



    //显示链表[遍历]
    public void listLinkedList() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//定义HeroNode,每一个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                " " +
                '}';
    }
}
