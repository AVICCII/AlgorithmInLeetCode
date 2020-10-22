package SGGAlogrithmDS.LinkedList;

/**
 * @author aviccii 2020/10/22
 * @Discrimination
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void listLinkedList() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(HeroNode2 heroNode2) {
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
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
        //形成一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }


    //修改节点的信息，根据no编号来修改，即no编号不能改。
    //根据newHeroNode的no来修改即可
    public void update(HeroNode2 newHeroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;//到链表的最后，已经遍历完成
            }
            if (temp.no == newHeroNode.no) {
                flag = true;//找到，退出
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }


    //删除节点
    //思路
    //对于双向链表我们可以直接找到要删除的这个节点
    //找到后自我删除即可
    public void del(int no) {

        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空无法删除");
            return;
        }


        HeroNode2 temp = head.next;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                //找到待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {//找到
            //可以删除
            temp.pre.next = temp.next;
            //如果是最后一个节点则不需要下面这样操作，否则NPE
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的%d节点不存在", no);
        }
    }


}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向上一个节点

    //构造器
    public HeroNode2(int no, String name, String nickname) {
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
