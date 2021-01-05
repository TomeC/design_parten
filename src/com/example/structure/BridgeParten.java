package com.example.structure;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 桥接模式
 * @program: BridgeParten
 * @Date: 2020/11/9 17:01
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
interface MsgSender {
    void send(String level, String msg);
}
class TelphoneSender implements MsgSender {
    private List<String> phones;

    public TelphoneSender(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public void send(String level, String msg) {
        phones.forEach(phone -> {
            System.out.println(level+" 发短信给"+phone+":"+msg);
        });
    }
}
class EmailSender implements MsgSender {
    private List<String> mails;

    public EmailSender(List<String> mails) {
        this.mails = mails;
    }

    @Override
    public void send(String level, String msg) {
        mails.forEach(mail -> {
            System.out.println(level+" 发邮件给"+mail+":"+msg);
        });
    }
}
abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }
    public abstract void notify(String msg);
}
class NormalNotification extends Notification {
    public NormalNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String msg) {
        msgSender.send("normal", msg);
    }
}
class UrgencyNotification extends Notification {
    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String msg) {
        msgSender.send("urgency", msg);
    }
}

public class BridgeParten {
    public static void main(String[] args) {
        MsgSender sender = new EmailSender(Arrays.asList("1@qq.com", "2@qq.com"));
        Notification notification = new NormalNotification(sender);
        notification.notify("server has warning");

        MsgSender sender1 = new TelphoneSender(Arrays.asList("123", "111"));
        Notification notification1 = new UrgencyNotification(sender1);
        notification1.notify("server has exception");
    }
}
