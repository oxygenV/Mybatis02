import com.example.entity.Dept;
import com.example.entity.Emp;
import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init()  {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selEmpByEmpNo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selEmpByEmpNo(7369);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void selectDeptByDeptno(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.selectDeptByDeptno(10);
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void selectEmpByStep(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpByStep(7369);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void selectDeptByStep2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.selectDeptByStep2(10);
        System.out.println(dept.getDname());
        sqlSession.close();
    }

    @Test
    public void selectEmpByCondition(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpno(7369);
        emp.setEname("SMITH");
//        emp.setSal(2500.0);
        Emp emp2 = mapper.selectEmpByCondition(emp);
        System.out.println(emp2);
        sqlSession.close();
    }

    @Test
    public void getEmpByDeptnos(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        List<Integer> list = new ArrayList();
//        list.add(10);
//        list.add(20);
//        list.add(30);
        List<Emp> empByDeptnos = mapper.getEmpByDeptnos(Arrays.asList(10,20,30));
        for (Emp empByDeptno : empByDeptnos) {
            System.out.println(empByDeptno);
        }
//        sqlSession.close();
    }

    @Test
    public void test0(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selEmpByEmpNo(7369);
        Emp emp2 = mapper.selEmpByEmpNo(7369);
        System.out.println(emp);
        System.out.println(emp2);
        sqlSession.close();
    }

    @Test
    public void test01(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpMapper mapper2 = sqlSession2.getMapper(EmpMapper.class);
        Emp emp = mapper.selEmpByEmpNo(7369);
        System.out.println(emp);
        sqlSession.close();
        System.out.println("=====================");
        Emp emp1 = mapper2.selEmpByEmpNo(7369);
        System.out.println(emp1);
        sqlSession2.close();
    }


}
