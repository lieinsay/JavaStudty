package com.lie.dao;

import com.lie.pojo.Department;
import com.lie.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

// 员工dao
@Repository
public class EmployeeDao {

    // 模拟数据库中的数据
    private  static Map<Integer, Employee> employees = null;
    // 员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new LinkedHashMap<Integer, Employee>(); // 创建一个部门表
        employees.put(1001, new Employee(1001,"aa","153573@qq.com",1,new Department(101,"教学部"),new Date()));
        employees.put(1002, new Employee(1002,"bb","a153573@qq.com",0,new Department(102,"市场部"),new Date()));
        employees.put(1003, new Employee(1003,"cc","b153573@qq.com",1,new Department(103,"运营部"),new Date()));
        employees.put(1004, new Employee(1004,"dd","c153573@qq.com",0,new Department(104,"财务部"),new Date()));
        employees.put(1005, new Employee(1005,"ee","d153573@qq.com",1,new Department(105,"开发部"),new Date()));
        employees.put(1006, new Employee(1006,"ff","e153573@qq.com",0,new Department(106,"宣传部"),new Date()));
    }

    // 主键自增
    private static Integer initId = 1007;

    // 增加一个员工
    public void  save(Employee employee){
        employee.setId(initId++);
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    // 通过id删除员工
    public void deleteById(Integer id){
        employees.remove(id);
    }


}
