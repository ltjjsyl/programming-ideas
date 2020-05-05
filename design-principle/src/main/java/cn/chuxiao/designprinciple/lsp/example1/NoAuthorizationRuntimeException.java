package cn.chuxiao.designprinciple.lsp.example1;

public class NoAuthorizationRuntimeException extends RuntimeException {

    public NoAuthorizationRuntimeException(String msg) {
        super(msg);
    }
}
