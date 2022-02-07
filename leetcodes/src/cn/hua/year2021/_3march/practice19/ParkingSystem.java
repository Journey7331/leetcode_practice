package cn.hua.year2021._3march.practice19;
// 1603. 设计停车系统
public class ParkingSystem {
    private final int[] carSet;
    private int[] car;

    public ParkingSystem(int big, int medium, int small) {
        carSet = new int[4];
        carSet[1] = big;
        carSet[2]= medium;
        carSet[3] = small;
        this.car = new int[4];
    }

    public boolean addCar(int carType) {
        if(this.car[carType]+1>carSet[carType])  return false;
        this.car[carType]++;
        return true;
    }


/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
}
