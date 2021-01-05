package com.example.structure;

/**
 * @description: 门面模式
 * @program: FacadeParten
 * @Date: 2020/11/13 18:58
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
class A {
    public void f1() {
        System.out.println("f1");
    }
    public void f2() {
        System.out.println("f2");
    }
    
    /**
    * 对小接口的组合使接口更易用
    */
    public void f() {
        f1();
        f2();
    }
}
public class FacadeParten {
    public static void main(String[] args) {
        A a = new A();
        a.f();
    }
}
