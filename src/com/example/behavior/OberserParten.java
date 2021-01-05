package com.example.behavior;

import java.util.LinkedList;
import java.util.List;

/** todo 考虑实现eventbus类型的通用观察者模式
 * @description: 观察者模式
 * @program: OberserParten
 * @Date: 2020/11/15 23:18
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
interface Observer {
    void update();
}
class ConObserver1 implements Observer {
    @Override
    public void update() {
        System.out.println("ConObserver1 update");
    }
}
class ConObserver2 implements Observer {
    @Override
    public void update() {
        System.out.println("ConObserver2 update");
    }
}
class Subject {
    private List<Observer> observers = new LinkedList<>();
    public void register(Observer observer) {
        observers.add(observer);
    }
    public void update() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
public class OberserParten {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.register(new ConObserver1());
        subject.register(new ConObserver2());
        subject.register(new ConObserver1());
        subject.update();
    }
}
