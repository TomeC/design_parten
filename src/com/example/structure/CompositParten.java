package com.example.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合模式
 * @program: CompositParten
 * @Date: 2020/11/13 22:42
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */
abstract class HumanResource {
    protected int id;
    protected int salary;

    public HumanResource(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }
    public abstract int calSalary();
}
class Employee extends HumanResource {
    public Employee(int id, int salary) {
        super(id, salary);
    }

    @Override
    public int calSalary() {
        return salary;
    }
}
class Department extends HumanResource {
    private List<HumanResource> resources;
    public Department(int id) {
        super(id, 0);
        resources = new LinkedList<>();
    }

    @Override
    public int calSalary() {
        int total = 0;
        for (HumanResource resource : resources) {
            total += resource.calSalary();
        }
        System.out.println(""+id+":"+total);
        return total;
    }
    public void add(HumanResource resource) {
        resources.add(resource);
    }
}
public class CompositParten {
    public static void main(String[] args) {
        Department root = new Department(1);
        HumanResource b1 = new Employee(11, 100);
        HumanResource b2 = new Employee(12, 80);
        root.add(b1);
        root.add(b2);
        Department d1 = new Department(2);
        d1.add(new Employee(21, 30));
        d1.add(new Employee(22, 29));
        Department d2 = new Department(3);
        d2.add(new Employee(31, 33));
        d2.add(new Employee(32, 34));
        root.add(d1);
        root.add(d2);
        System.out.println(root.calSalary());
    }
}
