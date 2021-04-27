package randomStart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author aviccii 2021/4/27
 * @Discrimination 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 */
// ************未解决*********************
public class case341扁平化嵌套列表迭代器 {
    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> list = new ArrayList<>();
        private int index;

        private void add(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    add(nestedInteger.getList());
                }
            }
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            add(nestedList);
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }


      public interface NestedInteger {

             // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
}
