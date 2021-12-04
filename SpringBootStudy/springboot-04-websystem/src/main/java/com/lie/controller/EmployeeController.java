package com.lie.controller;

import com.lie.dao.DepartmentDao;
import com.lie.dao.EmployeeDao;
import com.lie.pojo.Department;
import com.lie.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String emps(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/addemp")
    public String addempSelet(Model model){
        // 查查所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/addemp")
    public String addempSubmit(Employee employee,Model model){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //去员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        // 查出原来的数据
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        // 查查所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "addemp";
    }
}
