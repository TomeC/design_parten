package com.example.behavior;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 策略模式
 * @program: StrategyParten
 * @Date: 2020/11/19 17:33
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
interface IStrategy {
    void call();
}
class StrategyA implements IStrategy {
    @Override
    public void call() {
        System.out.println("StrategyA call");
    }
}
class StrategyB implements IStrategy {
    @Override
    public void call() {
        System.out.println("StrategyB call");
    }
}
class StrategyFactory {
    private static Map<Integer, IStrategy> strategyMap = new HashMap<>();
    static {
        strategyMap.put(0, new StrategyA());
        strategyMap.put(1, new StrategyB());
    }
    public static IStrategy getStrategy(int type) {
        return strategyMap.get(type);
    }
}
public class StrategyParten {
    public static void main(String[] args) {
        IStrategy strategy = StrategyFactory.getStrategy(1);
        strategy.call();
    }
}
