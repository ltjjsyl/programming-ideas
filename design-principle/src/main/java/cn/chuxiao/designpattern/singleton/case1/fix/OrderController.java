package cn.chuxiao.designpattern.singleton.case1.fix;

public class OrderController {

    public void create(OrderVo order) {
        //...
        Logger.getInstance().log("Create an order " + order.toString());
    }
}

class OrderVo {

}
