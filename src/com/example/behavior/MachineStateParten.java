package com.example.behavior;


/**
 * @description: 状态机模式-马里奥
 * @program: MachineStateParten
 * @Date: 2020/11/30 12:51
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */

interface IState {
    void handle();
    String getState();
}
class StateA implements IState {
    @Override
    public void handle() {
        System.out.println("StateA");
    }

    @Override
    public String getState() {
        return "StateA";
    }
}
class StateB implements IState {
    @Override
    public void handle() {
        System.out.println("StateB");
    }
    @Override
    public String getState() {
        return "StateB";
    }
}
class Machine {
    private IState state;

    public Machine() {
        this.state = new StateA();
    }

    public void handle() {
        state.handle();
        state = new StateB();
    }
    public void printState() {
        System.out.println(state.getState());
    }
}
public class MachineStateParten {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.printState();
        machine.handle();
        machine.printState();
        machine.handle();
    }
}
