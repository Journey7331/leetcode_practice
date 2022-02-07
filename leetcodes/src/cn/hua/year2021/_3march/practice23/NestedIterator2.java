package cn.hua.year2021._3march.practice23;
// 341. 扁平化嵌套列表迭代器
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator2 implements Iterator<Integer> {

    Iterator<Integer> iter;

    // 构造函数,初始化元素列表和地址下标
    public NestedIterator2(List<NestedInteger> nestedList) {
        List<Integer> retlist = new ArrayList<>();
        dfs(nestedList,retlist);
        this.iter = retlist.iterator();
    }

    // 深度查询嵌套列表中的元素
    private void dfs(List<NestedInteger> nestedList, List<Integer> retlist) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                retlist.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList(), retlist);
            }
        }
    }

    // 下一个元素
    @Override
    public Integer next() {
        return iter.next();
    }

    // 下标是否到了末尾
    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */