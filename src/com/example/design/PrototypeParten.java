package com.example.design;

/**
 * @description: 原型模式
 * @program: PrototypeParten
 * @Date: 2020/11/7 22:53
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */

/**
 * 浅拷贝
 */
class ShadowPrototype implements Cloneable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShadowPrototype() {
        id = 10;
        name = "helloProto";
    }

    /**
     * 浅拷贝
     * @return
     */
    @Override
    protected Object clone() {
        return this;
    }

//    /**
//     * 深拷贝
//     * @return
//     */
//    @Override
//    protected Object clone() {
//        return new ShadowPrototype();
//    }
}
public class PrototypeParten {
    public static void main(String[] args) {
        ShadowPrototype prototype = new ShadowPrototype();
        ShadowPrototype clone = (ShadowPrototype) prototype.clone();

        prototype.setName("newProto");
        System.out.println(clone.getId()+":"+clone.getName());

    }
}
