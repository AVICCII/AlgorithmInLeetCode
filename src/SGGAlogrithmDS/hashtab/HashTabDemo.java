package SGGAlogrithmDS.hashtab;

/**
 * @author aviccii 2020/11/19
 * @Discrimination
 */
public class HashTabDemo {
    public static void main(String[] args) {

    }
}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp Next;//next默认为Null
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
    public void add(Emp emp){

    }
}