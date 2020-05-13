package cn.chuxiao.designprinciple.dip.case1;

public class Heater {

    public static final int HEATER = 0x87;       //加热器
    public static final int ENGAGE = 1;
    public static final int DISENGAGE = 0;

    public void engage() {
        out(HEATER, ENGAGE);
    }

    public void disEngage() {
        out(HEATER, DISENGAGE);
    }

    private void out(int address, int falg) {

    }
}
