#include <iostream>
#include <string>
#include <map>
using namespace std;
// 简单工厂
class Rule {
public:
    virtual string getName() = 0;
    virtual ~Rule() {}
};
class RuleA: public Rule {
public:
    string getName() {
        return "RuleA";
    }
};
class RuleB: public Rule {
public:
    string getName() {
        return "RuleB";
    }
};
class SimpleFactory {
public:
    static Rule* getRule(string name) {
        if (name == "RuleA") {
            return new RuleA();
        } else if (name == "RuleB") {
            return new RuleB();
        }
        return NULL;
    }
};
// 抽象工厂
class IAbstractFactory {
public:
    virtual Rule* getRule(string name) = 0;
};
class AbstractFactoryA: public IAbstractFactory {
public:
    Rule* getRule(string name) {
        if (name == "RuleA") {
            return new RuleA();
        } else if (name == "RuleB") {
            return new RuleB();
        } else {
            return NULL;
        }
    }
};

class AbstractFactoryB: public IAbstractFactory {
public:
    Rule* getRule(string name) {
        if (name == "RuleA") {
            return new RuleA();
        } else if (name == "RuleB") {
            return new RuleB();
        } else {
            return NULL;
        }
    }
};
class FactoryProducer {
public:
    static IAbstractFactory* getFactory(string type) {
        if (type == "A") {
            return new AbstractFactoryA();
        } else if (type == "B") {
            return new AbstractFactoryB();
        }
        return NULL;
    }
};
int main() {
    Rule* rule = SimpleFactory::getRule("RuleB");
    cout <<rule->getName() <<endl;

    IAbstractFactory* factory = FactoryProducer::getFactory("A");
    if (factory != NULL) {
        cout<< factory->getRule("RuleA")->getName() <<endl;
    }
    return 0;
}