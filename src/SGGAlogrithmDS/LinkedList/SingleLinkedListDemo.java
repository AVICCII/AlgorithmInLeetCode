package SGGAlogrithmDS.LinkedList;

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

        //测试修改节点的代码
        HeroNode newHeroNodeDGQ = new HeroNode(2, "椰汁糕", "网络巨人！");
        singleLinkedList.update(newHeroNodeDGQ);
        //修改后的显示结果
        singleLinkedList.listLinkedList();

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
