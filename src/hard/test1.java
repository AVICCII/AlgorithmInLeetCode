package hard;

/**
 * @author aviccii 2021/5/10
 * @Discrimination
 */
public class test1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        test1.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
    }

    public static void swap(Student x, Student y) {
        x.setName("小李");
        y.setName("小张");

        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }

    public static class Student{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(String name) {
            this.name = name;
        }
    }
}
