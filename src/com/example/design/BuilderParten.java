package com.example.design;

/**
 * @description: 建造模式
 * @program: BuilderParten
 * @Date: 2020/11/6 10:57
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
class ResourceConf {
    private int maxTotal;
    private int maxIdle;

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }
    private ResourceConf(Builder builder) {
        maxTotal = builder.getMaxTotal();
        maxIdle = builder.getMaxIdle();
    }
    public static class Builder {
        private int maxTotal;
        private int maxIdle;
        public ResourceConf build() {
            return new ResourceConf(this);
        }

        public Builder setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public int getMaxTotal() {
            return maxTotal;
        }
        public int getMaxIdle() {
            return maxIdle;
        }
    }
}
public class BuilderParten {
    public static void main(String[] args) {
        ResourceConf conf = new ResourceConf.Builder()
                .setMaxTotal(10)
                .setMaxIdle(5)
                .build();
        System.out.println(conf.getMaxTotal());
        System.out.println(conf.getMaxIdle());
    }
}
