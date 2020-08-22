package com.kuang.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//实体类必须可以序列化
@Data
@NoArgsConstructor
@Accessors(chain=true) // 链式写法
public class Dept implements Serializable {

    private Long deptno;
    private String dname;

    // 这个数据存在哪个数据库；微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private  String db_source;

    /*
    链式写法
    Dept dept = new Dept();
    dept.setDeptNo(10).setDname("www").setDb_source("001");
    牛逼！
     */

    public Dept(String dname){
        this.dname = dname;
    }

}
