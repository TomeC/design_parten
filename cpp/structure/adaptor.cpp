#include <iostream>
using namespace std;
class Adaptee {
public:
    void f1() {
        cout<< "f1" <<endl;
    }
};
class Adaptor: public Adaptee {
public:
    void fa() {
        f1();
    }
};
int main() {
    Adaptor adaptor;
    adaptor.fa();
}