package cn.chuxiao.designprinciple.dip.case1;

//炉子
//抽象概念，都依赖概念实现
public class FurnaceV1 {


    public void regulate(Thermoneter t, Heater h, double minTemp, double maxTemp) throws InterruptedException {
        while (true) {
            while (t.read() > minTemp) {
                wait(1);
            }
            h.engage();
            while (t.read() < maxTemp) {
                wait(1);
            }
            h.disEngage();
        }
    }
}
