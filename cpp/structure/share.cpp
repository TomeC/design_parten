#include <iostream>
#include <map>
using namespace std;

class Share {
};
class ShareFac {
private:
    static map<int, Share*> smap;
public:
    static Share* get(int i) {
        Share* s = smap[i];
        if (s == NULL) {
            s = new Share();
            smap[i] = s;
        }
        return s;
    }
};
map<int, Share*> ShareFac::smap;
int main() {
    Share* s1 = ShareFac::get(1);
    Share* s2 = ShareFac::get(1);
    Share* s3 = ShareFac::get(2);
    cout<<(s1 == s2) <<endl;
    cout<<(s1 == s3) <<endl;
}