package com.example.structure;

/**
 * @description: 装饰器模式
 * @program: DecoratorParten
 * @Date: 2020/11/13 10:30
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
interface IA {
    void f();
}
class A1 implements IA {
    @Override
    public void f() {
        System.out.println("A1 process");
    }
}
class A2 implements IA {
    @Override
    public void f() {
        System.out.println("A2 process");
    }
}
class ADecorator implements IA {
    private IA ia;

    public ADecorator(IA ia) {
        this.ia = ia;
    }

    @Override
    public void f() {
        System.out.println("decorator process");
        ia.f();
    }
}

public class DecoratorParten {
    public static void main(String[] args) {
        IA ia = new ADecorator(new A1());
        IA ib = new ADecorator(ia);
        ib.f();
    }
}
