package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeEditPasswordDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入一条员工记录
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     * 分页查询员工记录
     *
     * @param employeePageQueryDTO
     * @return
     */
    Page<Employee> getEmployeePage(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用禁用员工账号
     * @param status
     * @param id
     */
    void setEmployeeStatus(Integer status, Long id);

    /**
     * 编辑员工
     * @param employee
     */
    void updateEmployee(Employee employee);

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
