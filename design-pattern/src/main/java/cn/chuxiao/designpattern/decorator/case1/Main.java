package cn.chuxiao.designpattern.decorator.case1;

public class Main {

    public static void main(String[] args) {
        Email email = new EmailImpl("Hello World!");
        String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV

        System.out.println("case1:");
        Email emailSendOut = new EmailSendout(email);
        System.out.println(emailSendOut.getContent());
        System.out.println();

        System.out.println("case2:");
        Email emailEncrypt = new EmailEncrypt(key, initVector, email);
        String encryptedContent1 = emailEncrypt.getContent();
        System.out.println("encrypted content: " + encryptedContent1);
        System.out.println(Encryptor.decrypt(key, initVector, encryptedContent1));
        System.out.println();

        System.out.println("case3:");
        Email emailsendOutEncrypt = new EmailSendout(new EmailEncrypt(key, initVector, email));
        System.out.println(emailsendOutEncrypt.getContent());
        System.out.println();

        Email emailEncryptSendOut = new EmailEncrypt(key, initVector, new EmailSendout(email));
        String encryptedContent2 = emailEncryptSendOut.getContent();
        System.out.println("encrypted content: " + encryptedContent2);
        System.out.println();
        System.out.println(Encryptor.decrypt(key, initVector, encryptedContent2));
    }


}
