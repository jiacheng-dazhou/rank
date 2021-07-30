package com.fei.rank.application.entity;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName = "of")
@Builder
public class EmployeeEntity {
    private String name;
    private String employeeId;
    private String departmentName;
    private String employeePhoto;
    private String role;
    private String departmentCode;
    private String individualCode;
}
