package cn.chuxiao.designprinciple.dip.case1;

public class Thermoneter {
    public static final int THERMONETER = 0x86; //温度计

    public double read() {
        return in(THERMONETER);
    }

    private double in(int address) {
        return 0.0;
    }
}
