package com.example.behavior;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 责任链模式
 * @program: ChainResponsibilityParten
 * @Date: 2020/11/19 18:36
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
// 自定义链表mode
abstract class AbsHandler {
    protected AbsHandler next = null;

    public void setNext(AbsHandler next) {
        this.next = next;
    }

    public void handle() {
        boolean isOk = doHandle();
        if (!isOk && next != null) {
            next.handle();
        }
    }
    abstract public boolean doHandle();
}
class HandlerA extends AbsHandler {

    @Override
    public boolean doHandle() {
        System.out.println("HandlerA process, false");
        return false;
    }
}
class HandlerB extends AbsHandler {
    @Override
    public boolean doHandle() {
        System.out.println("HandlerB process, true");
        return true;
    }
}
class ChanHandler {
    private AbsHandler head, tail;
    public void addHandler(AbsHandler handler) {
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setNext(handler);
        tail = handler;
    }
    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
// list模式
class ListChan {
    private List<AbsHandler> handlers = new LinkedList<>();
    public void addHandler(AbsHandler handler) {
        handlers.add(handler);
    }
    public void process() {
        for (AbsHandler handler : handlers) {
            if (handler.doHandle()) {
                return;
            }
        }
    }
}

public class ChainResponsibilityParten {
    public static void main(String[] args) {
        HandlerA handlerA = new HandlerA();
        HandlerB handlerB = new HandlerB();

//        ChanHandler chanHandler = new ChanHandler();
//        chanHandler.addHandler(handlerA);
//        chanHandler.addHandler(handlerB);
//        chanHandler.handle();

        ListChan listChan = new ListChan();
        listChan.addHandler(handlerA);
        listChan.addHandler(handlerB);
        listChan.process();
    }
}
