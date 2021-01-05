#include<iostream>
using namespace std;

class ProtoType {
private:
    int id;
    string name;
public:
    ProtoType(int _id, string _name):id(_id), name(_name) {}
    int getId() {return id;}
    string getName() {return name;}
    ProtoType& operator=(const ProtoType& p) {
        id = p.id;
        name = p.name;
        return *this;
    }
};
int main() {
    ProtoType p(1, "hello");
    ProtoType c = p;
    cout<<c.getId() <<":" <<c.getName() <<endl;

}