package 面试.并发.线程安全;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aviccii 2021/4/21
 * @Discrimination
 */
public class 不可变 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        // Collections.unmodifiableXXX() 先对原始的集合进行拷贝，需要对集合进行修改的方法都直接抛出异常。
        unmodifiableMap.put("a",1);
    }
}
