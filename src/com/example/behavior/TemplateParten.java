package com.example.behavior;

/**
 * @description: 模版模式
 * @program: TemplateParten
 * @Date: 2020/11/17 17:48
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
abstract class Template {
    public final void process() {
        System.out.println("process begin");
        m1();
        System.out.println("process end");
    }
    // 延迟到子类实现
    protected abstract void m1();
}
class ConcreteTemplate extends Template {
    @Override
    public void m1() {
        System.out.println("process m1");
    }
}
public class TemplateParten {
    public static void main(String[] args) {
        Template concreteTemplate = new ConcreteTemplate();
        concreteTemplate.process();
    }
}
