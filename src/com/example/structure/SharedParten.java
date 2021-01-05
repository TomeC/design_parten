package com.example.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 享元模式
 * @program: SharedParten
 * @Date: 2020/11/14 21:35
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
class Shared {
}
class SharedFac {
    private static Map<Integer, Shared> sharedMap = new HashMap<>();
    static {
        sharedMap.put(1, new Shared());
        sharedMap.put(2, new Shared());
    }
    public static Shared get(Integer i) {
        return sharedMap.get(i);
    }
}
public class SharedParten {
    public static void main(String[] args) {
        Shared s1 = SharedFac.get(1);
        Shared s11 = SharedFac.get(1);
        System.out.println(s1 == s11);

        Shared s2 = SharedFac.get(1);
        System.out.println(s1 == s2);
    }
}
