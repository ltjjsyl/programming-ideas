package cn.chuxiao.designpattern.callback;

/**
 * 同步回调
 */
public class BClass {

    public void process(ICallback callback) {

        //...
        callback.methodCallback();
    }
}
