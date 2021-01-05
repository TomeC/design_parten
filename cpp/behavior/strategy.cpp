#include <iostream>
using namespace std;
class IStategy {
public:
    virtual void call() = 0;
};
class StrategyA: public IStategy {
public:
    void call() {
        cout<<"StrategyA call" <<endl;
    }
};
class StrategyB: public IStategy {
public:
    void call() {
        cout<<"StrategyB call" <<endl;
    }
};

int main() {
    IStategy* strategy = new StrategyA();
    strategy->call();
    return 0;
}