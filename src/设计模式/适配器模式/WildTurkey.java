package 设计模式.适配器模式;

/**
 * @author aviccii 2021/4/29
 * @Discrimination
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gooble!");
    }
}
