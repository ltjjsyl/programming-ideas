package cn.chuxiao.designpattern.sington.case1.origin;

public class OrderController {
    private Logger logger = new Logger();

    public void create(OrderVo order) {
        //...
        logger.log("Create an order " + order.toString());
    }
}

class OrderVo {

}
