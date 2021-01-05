package com.example.behavior;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description: 备忘录模式
 * @program: SnapShotParten
 * @Date: 2020/12/3 10:45
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
class Text {
    private StringBuilder data = new StringBuilder();

    public String getData() {
        return data.toString();
    }

    public void append(String data) {
        this.data.append(data);
    }

    public void restore(String res) {
        this.data.replace(0, data.length(), res);
    }
}
class SnapShot {
    private Stack<Text> texts = new Stack<>();
    public Text pop() {
        if (!texts.empty()) {
            return texts.pop();
        }
        return new Text();
    }
    public void push(Text text) {
        Text tmp = new Text();
        tmp.restore(text.getData());
        texts.push(tmp);
    }
}

public class SnapShotParten {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("hello");
        System.out.println(builder.toString());
        builder.replace(0, 2, "aa");
        System.out.println(builder.toString());

        Scanner input = new Scanner(System.in);
        Text text = new Text();
        SnapShot snapShot = new SnapShot();
        while (input.hasNext()) {
            String data = input.next();
            if (":l".equals(data)) {
                System.out.println(text.getData());
            } else if (":undo".equals(data)) {
                Text tmp = snapShot.pop();
                text.restore(tmp.getData());
            } else {
                snapShot.push(text);
                text.append(data);
            }
        }
    }
}
