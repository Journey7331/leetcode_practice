package cn.hua.year2021._3march.practice13;
// 705. 设计哈希集合
import java.util.Arrays;

public class MyHashSet {
    private boolean[] sets = new boolean[1000001];

    public MyHashSet() {
    }

    public void add(int key) {
        sets[key] = true;
    }

    public void remove(int key) {
        sets[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return sets[key];
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "sets=" + Arrays.toString(sets) +
                '}';
    }
}
