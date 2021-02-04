package com.example.mapper;

import com.example.entity.Dept;

import java.io.PrintStream;

public interface DeptMapper {

    public Dept selectDeptByDeptno(Integer deptno);

    //分步查询
    public Dept selectDeptByStep(Integer deptno);


    public Dept selectDeptByStep2(Integer deptno);
}
