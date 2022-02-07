package cn.hua.year2021._3march.practice13;
// 705. 设计哈希集合
public class DemoMain {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]

        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));
    }

}
