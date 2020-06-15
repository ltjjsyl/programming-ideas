package cn.chuxiao.designpattern.decorator.case1;

public class EmailEncrypt extends EmailDecorator {

    private Email email;
    private String key;
    private String initVector;

    public EmailEncrypt(String key, String initVector, Email email) {
        this.email = email;
        this.key = key;
        this.initVector = initVector;
    }

    @Override
    public String getContent() {
        String content = email.getContent();

        return Encryptor.encrypt(key, initVector, content);
    }
}
