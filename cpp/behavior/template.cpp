#include <iostream>
using namespace std;

class Template {
public:
    void process() {
        cout<<"process begin" <<endl;
        m1();
        cout<<"process end" <<endl;
    }
protected:
    virtual void m1() = 0;
};

class ConcreteTemplate: public Template {
public:
    void m1() {
        cout<<"m1" <<endl;
    }
};

int main() {
    Template* t = new ConcreteTemplate();
    t->process();
    return 0;
}
