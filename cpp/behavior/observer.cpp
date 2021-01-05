#include <iostream>
#include <list>
using namespace std;

class Observer {
public:
    virtual void update() = 0;
};

class ConcreteObserver1: public Observer {
public:
    void update() {
        cout<<"ConcreteObserver1 update" <<endl;
    }
};
class ConcreteObserver2: public Observer {
public:
    void update() {
        cout<<"ConcreteObserver2 update" <<endl;
    }
};

class Subject {
private:
    list<Observer*> obs;
public:
    void regist (Observer* o) {
        obs.push_back(o);
    }
    void update() {
        for (list<Observer*>::iterator iter = obs.begin(); iter != obs.end(); ++iter) {
            (*iter)->update();
        }
    }
};

int main() {
    Subject s;
    s.regist(new ConcreteObserver1());
    s.regist(new ConcreteObserver2());
    s.regist(new ConcreteObserver1());
    s.update();
    return 0;
}