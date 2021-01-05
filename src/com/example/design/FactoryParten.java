package com.example.design;

import java.util.*;

/**
 * @description: 工厂模式
 * @program: Factory
 * @Date: 2020/11/5 14:20
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
interface Rule {
    String getName();
}
class RuleA implements Rule {
    @Override
    public String getName() {
        return "RuleA";
    }
}
class RuleB implements Rule {
    @Override
    public String getName() {
        return "RuleB";
    }
}
class SimpleFactoryA {
    public static Rule getRule(String name) {
        if (name.equals("RuleA")) {
            return new RuleA();
        } else if (name.equals("RuleB")) {
            return new RuleB();
        } else {
            return null;
        }
    }
}
class SimpleFactoryB {
    private static Map<String, Rule> cacheRule = new HashMap<>();
    static {
        cacheRule.put("RuleA", new RuleA());
        cacheRule.put("RuleB", new RuleB());
    }
    public static Rule getRule(String name) {
        return cacheRule.get(name);
    }
}

/**
 * 抽象工厂
 */
interface IAbstractFactory {
    Rule getRule(String name);
}
class AbsFactoryA implements IAbstractFactory {
    @Override
    public Rule getRule(String name) {
        if (name.equals("RuleA")) {
            return new RuleA();
        } else if (name.equals("RuleB")) {
            return new RuleB();
        } else {
            return null;
        }
    }
}
class AbsFactoryB implements IAbstractFactory {
    @Override
    public Rule getRule(String name) {
        if (name.equals("RuleA")) {
            return new RuleA();
        } else if (name.equals("RuleB")) {
            return new RuleB();
        } else {
            return null;
        }
    }
}
class FactoryProducer {
    public static IAbstractFactory getFactory(String type) {
        if (type.equals("A")) {
            return new AbsFactoryA();
        } else if (type.equals("B")) {
            return new AbsFactoryB();
        } else {
            return null;
        }
    }
}
public class FactoryParten {
    public static void main(String[] args) {
        Rule rule = SimpleFactoryA.getRule("RuleA");
        System.out.println(rule.getName());

        // abstract factory
        IAbstractFactory abstractFactory = FactoryProducer.getFactory("A");
        Rule rule1 = abstractFactory.getRule("RuleA");
        System.out.println(rule1.getName());
    }
}
