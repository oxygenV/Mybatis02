package com.example.mapper;

import com.example.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    public Emp selEmpByEmpNo(Integer empno);

//    association 分步查询
    public Emp selectEmpByStep(Integer empno);

    public Emp selectEmpByStep2(Integer deptno);

    public Emp selectEmpByCondition(Emp emp);

    public List<Emp> getEmpByDeptnos(@Param("deptnos") List<Integer> deptnos);
}
