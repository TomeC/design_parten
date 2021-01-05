#include <iostream>
using namespace std;
class IA {
public:
    virtual void f() = 0;
};
class A1: public IA {
public:
    void f() {
        cout<<"A1 process" <<endl;
    }
};

class A2: public IA {
public:
    void f() {
        cout<<"A2 process" <<endl;
    }
};
class ADecorator: public IA {
private:
    IA* ia;
public:
    ADecorator(IA* ia_):ia(ia_) { }
    void f() {
        cout<<"ADecorator process" <<endl;
        ia->f();
    }
};
int main() {
    IA* i1 = new A1();
    IA* i2 = new A2();
    IA* d1 = new ADecorator(i1);
    d1->f();

    IA* d2 = new ADecorator(d1);
    d2->f();
}