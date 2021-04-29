package 设计模式.适配器模式;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
public class TurkeyAdapter implements Duck{

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}
