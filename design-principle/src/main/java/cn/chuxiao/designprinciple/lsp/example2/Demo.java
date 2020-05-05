package cn.chuxiao.designprinciple.lsp.example2;

import static junit.framework.Assert.assertEquals;

public class Demo {

    //不符合里氏替换原则
    public void testArea(Rectangle r) {
        r.setHeight(5);
        r.setWidth(4);
        assertEquals(20, r.area());
    }
}
