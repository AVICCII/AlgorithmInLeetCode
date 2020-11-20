package SGGAlogrithmDS.hashtab;

/**
 * @author aviccii 2020/11/19
 * @Discrimination
 */
public class HashTabDemo {
    public static void main(String[] args) {

    }
}

//创建HashTable用于管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示共有多少条链表

    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //TODO
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);

    }

    //遍历所有的链表，遍历hashtab
    public void list(){
        for (int i = 0;i<size;i++){
            empLinkedListArray[i].list();
        }
    }

    //编写一个散列函数 使用一个取模法
    public int hashFun(int id){
        return id % size;
    }
}



//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;//next默认为Null
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建一个EmpLinkedList 表示一条链表
class EmpLinkedList{
    //头指针指向第一个Emp,因此我们这个链表的head是直接指向第一个雇员的
    private Emp head;//默认为空

    //添加雇员到链表
    //1.假定当添加雇员时，id是自增长的 即id的分配总是从小到大
    // 因此我们将该雇员直接加入到本链表的最后一个即可

    public void add(Emp emp){
        //如果是添加第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针来定位到最后
        Emp curEmp = head;
        //说明到链表的最后
        while (curEmp.next != null) {
            curEmp = curEmp.next;//后移
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(){
        if (head == null){
            //说明链表为空
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表的信息为");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            //说明curEmp是最后节点
            if (curEmp.next==null) break;
            curEmp = curEmp.next;//后移，遍历
        }
        System.out.println();
    }
}