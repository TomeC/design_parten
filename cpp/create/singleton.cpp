#include <iostream>
#include <mutex>
using namespace std;
//懒汉1
class singleton {
private:
     int resource;
     static singleton* instance;
     static mutex mx;

private:
    singleton() {
        resource = 0;
    }
    ~singleton() {}
    singleton(const singleton&);
    singleton& operator=(const singleton&);
public:
    static singleton* getInstance() {
        if (instance == NULL) {
            lock_guard<mutex> lg(mx);
            if (instance == NULL) {
                instance = new singleton();
            }
        }
        return instance;
    }
    int getResource() {
        return resource;
    }
};
singleton* singleton::instance = NULL;
mutex singleton::mx;

//懒汉1
class singleton2 {
private:
    int resource;
    singleton2() { resource = 0;}
	~singleton2() { }
	singleton2(const singleton2&);
	singleton2& operator=(const singleton2&);
public:
    static singleton2& getInstance() {
		static singleton2 instance;
		return instance;
	}
	int getResource() {
	    return ++resource;
	}
};

// 饿汉
class singleton3 {
private:
    int resource;
    static singleton3 instance;
    singleton3() { resource = 0;}
	~singleton3() { }
	singleton3(const singleton3&);
	singleton3& operator=(const singleton3&);
public:
    static singleton3& getInstance() {
		return instance;
	}
	int getResource() {
	    return ++resource;
	}
};
singleton3 singleton3::instance;

int main()
{
    cout<<singleton::getInstance()->getResource() <<endl;
    cout<<singleton2::getInstance().getResource() <<endl;
    cout<<singleton2::getInstance().getResource() <<endl;
    cout<<singleton3::getInstance().getResource() <<endl;
    cout<<singleton3::getInstance().getResource() <<endl;
}

/*
non-local static 对象的初始化发生在main函数执行之前，也即main函数之前的单线程启动阶段，所以不存在线程安全问题。
但C++没有规定多个non-local static 对象的初始化顺序，尤其是来自多个编译单元的non-local static对象，他们的初始化顺序是随机的。

C++11则在语言规范中解决了这个问题。C++11规定，在一个线程开始local static 对象的初始化后到完成初始化前，
其他线程执行到这个local static对象的初始化语句就会等待，直到该local static 对象初始化完成。
*/