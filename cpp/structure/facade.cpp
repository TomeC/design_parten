#include <iostream>
using namespace std;
class A {
public:
    void f1() {
        cout<<"f1" <<endl;
    }
    void f2() {
        cout<<"f2" <<endl;
    }
    void f() {
        f1();
        f2();
    }
};
int main() {
    A a;
    a.f();
}