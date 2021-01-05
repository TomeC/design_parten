package com.example.behavior;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 命令模式
 * @program: CommandParten
 * @Date: 2020/12/3 11:40
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
interface ICommand {
    void excute();
}
class CommandA implements ICommand {
    @Override
    public void excute() {
        System.out.println("CommandA excute");
    }
}
class CommandB implements ICommand {
    @Override
    public void excute() {
        System.out.println("CommandB excute");
    }
}
public class CommandParten {
    public static void main(String[] args) {
        List<ICommand> commands = new LinkedList<>();
        commands.add(new CommandA());
        commands.add(new CommandB());
        commands.add(new CommandA());
        for (ICommand command : commands) {
            command.excute();
        }
    }
}
