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
        singleLinkedList.add(heroNodeQz);
        singleLinkedList.add(heroNodeDGQ);
        singleLinkedList.add(heroNodeYJJ);
        //显示
        singleLinkedList.listLinkedList();
    }
}

//定义SingleLinkedList管理我们的hero
class SingleLinkedList{
    //先初始化一个头节点，头节点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0,
            "","");
    //添加节点到单向链表
    //当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp =head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出循环后，temp就指向了链表的最后
        //将最后的这个节点的next指向新的节点
        temp.next=heroNode;
    }

    //显示链表[遍历]
    public void listLinkedList(){
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
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
    public HeroNode(int no,String name,String nickname){
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