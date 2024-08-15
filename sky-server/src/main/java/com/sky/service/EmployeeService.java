package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeEditPasswordDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;


public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     * @param employeeDTO
     */
    void addEmployee(EmployeeDTO employeeDTO);

    /**
     * 分页查询员工
     * @param employeePageQueryDTO
     * @return
     */
    PageResult getEmployeePage(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用禁用员工账号
     * @param status
     * @param id
     */
    void setEmployeeStatus(Integer status, Long id);

    /**
     * 编辑员工
     * @param employeeDTO
     */
    void updateEmployee(EmployeeDTO employeeDTO);

    /**
     * 通过id查询员工
     * @param id
     * @return
     */
    Employee getEmployeeById(Long id);

    /**
     * 修改密码
     * @param employeeEditPasswordDTO
     */
    void editPassword(EmployeeEditPasswordDTO employeeEditPasswordDTO);
}
