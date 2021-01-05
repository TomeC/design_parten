package com.example.behavior;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 观察者模式
 * @program: VisitorParten
 * @Date: 2020/12/2 18:28
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
abstract class AbsVisitable {
    abstract void accept(IVisitor v);
}
class ConVisitableA extends AbsVisitable {
    @Override
    void accept(IVisitor v) {
        v.visit(this);
    }
}
class ConVisitableB extends AbsVisitable {
    @Override
    void accept(IVisitor v) {
        v.visit(this);
    }
}
interface IVisitor {
    void visit(ConVisitableA va);
    void visit(ConVisitableB vb);
}
class ConVisitorA implements IVisitor {
    @Override
    public void visit(ConVisitableA va) {
        System.out.println("ConVisitorA ConVisitableA");
    }

    @Override
    public void visit(ConVisitableB vb) {
        System.out.println("ConVisitorA ConVisitableB");
    }
}
class ConVisitorB implements IVisitor {
    @Override
    public void visit(ConVisitableA va) {
        System.out.println("ConVisitorB ConVisitableA");
    }

    @Override
    public void visit(ConVisitableB vb) {
        System.out.println("ConVisitorB ConVisitableB");
    }
}
public class VisitorParten {
    public static void main(String[] args) {
        IVisitor visitor = new ConVisitorA();
        List<AbsVisitable> visitables = new LinkedList<>();
        visitables.add(new ConVisitableA());
        visitables.add(new ConVisitableB());
        visitables.add(new ConVisitableA());
        for (AbsVisitable visitable : visitables) {
            visitable.accept(visitor);
        }
    }
}
