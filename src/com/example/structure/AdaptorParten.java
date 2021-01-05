package com.example.structure;

/**
 * @description: 适配器模式
 * @program: Adaptor
 * @Date: 2020/11/13 11:18
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
class Adaptee {
    public void f1() {
        System.out.println("f1");
    }
    public void f2() {
        System.out.println("f2");
    }
}
/**
* @Description:  基于继承的实现 
* @Author: benjamin.wang
* @Date: 2020/11/13 18:53
*/
class Adaptor extends Adaptee {
    public void fa() {
        super.f1();
    }
    public void fb() {
        super.f2();
    }
}
/**
* @Description:  基于组合的实现
* @Author: benjamin.wang
* @Date: 2020/11/13 18:53
*/
class Adaptor2 {
    private Adaptee adaptee;

    public Adaptor2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    public void fa() {
        adaptee.f1();
    }
}
public class AdaptorParten {
    public static void main(String[] args) {
        Adaptor adaptor = new Adaptor();
        adaptor.fa();
        adaptor.fb();
    }
}
