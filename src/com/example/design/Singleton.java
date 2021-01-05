package com.example.design;

/**
 * @description: 单例
 * @program: Hungry
 * @Date: 2020/11/4 15:10
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
class Hungry {
    private int resource;
    // 在加载时初始化时
    private static final Hungry instance = new Hungry();
    private Hungry() {
        resource = 0;
    }
    public static Hungry getInstance() {
        return instance;
    }
    public int getResource() {
        return resource;
    }
}
/**
 * 需要加锁，不推荐
 */
class Lazy {
    private int resource;
    private static Lazy instance;
    private Lazy() {
        resource = 0;
    }
    public static Lazy getInstance() {
        if (instance == null) {
            synchronized (Lazy.class) {
                if (instance == null) {
                    instance = new Lazy();
                }
            }
        }
        return instance;
    }
    public int getResource() {
        return resource;
    }
}
class InnerParten {
    private int resource;
    private InnerParten() {
        resource = 0;
    }
    private static class InnerHolder {
        private static final InnerParten instance = new InnerParten();
    }
    public static InnerParten getInstance() {
        return InnerHolder.instance;
    }
    public int getResource() {
        return resource;
    }
}
enum EnumParten {
    /**
     * 单例
     */
    INSTANCE;
    private int resource;
    EnumParten() {
        resource = 0;
    }
    public int getResource() {
        return resource;
    }
}
public class Singleton {
    public static void main(String[] args) {
        System.out.println(Hungry.getInstance().getResource());
        System.out.println(Lazy.getInstance().getResource());
        System.out.println(InnerParten.getInstance().getResource());
        System.out.println(EnumParten.INSTANCE.getResource());
    }
}
