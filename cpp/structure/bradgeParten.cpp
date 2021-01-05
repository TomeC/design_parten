#include <iostream>
#include <list>
using namespace std;

class MsgSender {
public:
    virtual void send(const string& level, const string& msg) = 0;
};
class PhoneMsgSender: public MsgSender {
private:
    list<string> phones;
public:
    PhoneMsgSender(list<string>& phs): phones(phs) { }
    void send(const string& level, const string& msg) {
        for (list<string>::iterator iter = phones.begin(); iter != phones.end(); ++iter) {
            cout<<level <<" call phone to "<<*iter <<", message: "<< msg <<endl;
        }
    }
};
class EmailMsgSender: public MsgSender {
private:
    list<string> mails;
public:
    EmailMsgSender(list<string>& mls): mails(mls) { }
    void send(const string& level, const string& msg) {
        for (list<string>::iterator iter = mails.begin(); iter != mails.end(); ++iter) {
            cout<<level <<" send mail to "<<*iter <<", message: "<< msg <<endl;
        }
    }
};
class Notify {
public:
    virtual void notify(const string& msg) = 0;
};
class NormalNotify: public Notify {
private:
    MsgSender* msgSender;
public:
    NormalNotify(MsgSender* msgSender_): msgSender(msgSender_) {}
    void notify(const string& msg) {
        msgSender->send("Normal", msg);
    }
};
class UrgencyNotify: public Notify {
private:
    MsgSender* msgSender;
public:
    UrgencyNotify(MsgSender* msgSender_): msgSender(msgSender_) {}
    void notify(const string& msg) {
        msgSender->send("Urgency", msg);
    }
};
int main() {
    list<string> mails;
    mails.push_back("jerry@yingzt.com");
    mails.push_back("tom@yingzt.com");
    EmailMsgSender emailMsgSender(mails);
    NormalNotify normal(&emailMsgSender);
    normal.notify("operation success");

    list<string> phones;
    phones.push_back("1850002");
    phones.push_back("1720001");
    PhoneMsgSender phoneMsgSender(phones);
    UrgencyNotify urgencyNotify(&phoneMsgSender);
    urgencyNotify.notify("service down");
    return 0;
}