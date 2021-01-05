#include<iostream>
using namespace std;
class IUser {
public:
    virtual bool login(string name) = 0;
};
class User: public IUser {
public:
    bool login(string name) {
        return true;
    }
};
class UserProxy: public IUser {
private:
    User user;
public:
    bool login(string name) {
        cout<<name <<" login ..." <<endl;
        bool result = user.login(name);
        cout<<name <<" login success" <<endl;
        return result;
    }
};


int main() {
    UserProxy proxy;
    proxy.login("tom");
    return 0;
}