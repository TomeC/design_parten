#include <iostream>
#include <list>
using namespace std;
class HumanResource {
protected:
    int id;
    int salary;
public:
    HumanResource(int id_, int salary_):id(id_), salary(salary_) {}
    virtual int getSalary() = 0;
};
class Employee: public HumanResource {
public:
    Employee(int id_, int salary_): HumanResource(id_, salary_) {}
    int getSalary() {
        return salary;
    }
};
class Department: public HumanResource {
private:
    list<HumanResource *> resourceList;
public:
    Department(int id_):HumanResource(id_, 0) {}
    int getSalary() {
        int total = 0;
        for (list<HumanResource *>::iterator iter = resourceList.begin(); iter != resourceList.end(); ++iter) {
            total += (*iter)->getSalary();
        }
        return total;
    }
    void addResource(HumanResource* res) {
        resourceList.push_back(res);
    }
};
int main() {
    Department root(1);
    HumanResource* p1 = new Employee(11, 100);
    HumanResource* p2 = new Employee(12, 80);
    root.addResource(p1);
    root.addResource(p2);
    cout<<root.getSalary() <<endl;

    Department* d1 = new Department(2);
    d1->addResource(new Employee(21, 10));
    root.addResource(d1);
    cout<<root.getSalary() <<endl;

    Department* d2 = new Department(3);
    d2->addResource(new Employee(31, 20));
    root.addResource(d2);
    cout<<root.getSalary() <<endl;

    HumanResource* d3 = new Department(4);
    d2->addResource(new Employee(41, 30));
    root.addResource(d3);
    cout<<root.getSalary() <<endl;
}