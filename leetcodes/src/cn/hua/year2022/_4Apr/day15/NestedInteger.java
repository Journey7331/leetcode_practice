package cn.hua.year2022._4Apr.day15;

import java.util.List;

public class NestedInteger implements NestedIntegerInterface{

    private Integer num = null;
    private NestedInteger ni;

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return num;
    }

    @Override
    public void setInteger(int value) {
        this.num = new Integer(value);
    }

    @Override
    public void add(NestedInteger ni) {
        this.ni = ni;
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}
