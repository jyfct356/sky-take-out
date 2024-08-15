package com.sky.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class EmployeeEditPasswordDTO implements Serializable {
    private Long empId;
    private String oldpassword;
    private String newPassword;
}
