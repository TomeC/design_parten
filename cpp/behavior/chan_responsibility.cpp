#include <iostream>
using namespace std;

class AbsHandler {
private:
    AbsHandler next;
public:
    void setHandler(AbsHandler handler) {
        next = handler;
    }
    void handle(AbsHandler handler) {
        bool isSucc = handler.doHandle();
        if (!isSucc && next != NULL) {
            next.doHandle();
        }
    }
    virtual bool doHandle() = 0;
};
class HandlerA: public AbsHandler {
public:
    virtual bool doHandle() {
        cout<<"HandlerA process fail" <<endl;
        return false;
    }
};
class HandlerB: public AbsHandler {
public:
    virtual bool doHandle() {
        cout<<"HandlerB process succ" <<endl;
        return true;
    }
};

class ChanHandler {
private:
    AbsHandler head, tail;
public:

};