package cn.chuxiao.designprinciple.dip.case1;

//炉子
public class Furnace {

    public static final int THERMONETER = 0x86; //温度计
    public static final int HEATER = 0x87;       //加热器
    public static final int ENGAGE = 1;
    public static final int DISENGAGE = 0;

    public void regulate(double minTemp, double maxTemp) throws InterruptedException {
        while (true) {
            while (in(THERMONETER) > minTemp) {
                wait(1);
            }
            out(HEATER, ENGAGE);
            while (in(THERMONETER) < maxTemp) {
                wait(1);
            }
            out(HEATER, DISENGAGE);
        }
    }

    private double in(int address) {
        return 0.0;
    }

    private void out(int address, int falg) {

    }
}
