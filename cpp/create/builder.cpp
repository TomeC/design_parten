#include<iostream>
using namespace std;

class ResourceConf {
private:
    int maxTotal;
    int maxIdle;

public:
    ResourceConf(int total, int idle):maxTotal(total), maxIdle(idle) {}
    class Builder;
    int getMaxTotal() {
        return maxTotal;
    }
    int getMaxIdle() {
        return maxIdle;
    }
};

class ResourceConf::Builder {
private:
    int maxTotal;
    int maxIdle;
public:
    Builder* setTotal(int total) {
        maxTotal = total;
        return this;
    }
    Builder* setIdle(int idle) {
        maxIdle = idle;
        return this;
    }
    ResourceConf* build() {
        return new ResourceConf(maxTotal, maxIdle);
    }
};

int main() {
    ResourceConf& conf = *(new ResourceConf::Builder())->setTotal(10)->setIdle(2)->build();
    cout <<conf.getMaxTotal() <<":" <<conf.getMaxIdle() <<endl;
    return 0;
}