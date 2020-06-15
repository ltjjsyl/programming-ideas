package cn.chuxiao.designpattern.decorator.case1;

public class EmailSendout extends EmailDecorator {

    private Email email;

    public EmailSendout(Email email) {
        this.email = email;
    }

    @Override
    public String getContent() {
        String content = email.getContent();
        content += "\n" + "本邮件仅为个人观点，并不代表公司立场.";
        return content;
    }
}
