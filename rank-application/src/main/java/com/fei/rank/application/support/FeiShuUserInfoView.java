package com.fei.rank.application.support;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lqy on 2019/9/29.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeiShuUserInfoView implements Serializable {

    private static final long serialVersionUID = -351195584315276544L;

    //登录的用户名
    private String account;

    private String pwd;

    //姓名
    private String name;

    //姓名拼英
    private String namePy;

    //帐号id
    private Integer accountId;

    //员工id
    private String employeeId;

    //员工头像
    private String employeePhoto;

    //邮箱
    private String email;

    //更新时间
    private Date updateTime;

    //员工状态 0正常 其他不正常
    private Integer status;

    //员工性别
    private Integer gender;

    //员工类型 1:正式员工；2:实习生；3:外包；4:劳务；5:顾问
    private Integer employeeType;

    //员工手机号
    private String mobile;

    //直接部门领导人id
    private String leaderEmployeeId;

    //直接部门领导人名称
    private String leaderEmployeeName;

    //所在部门id（飞书）
    private String feishuDepartments;

    //所在部门名称（飞书）
    private String feishuDepartmentName;

    //上级部门id（飞书）
    private String parentFeishuDepartmentId;

    //上级部门名称（飞书）
    private String parentFeishuDepartmentName;

    //部门状态（飞书）
    private Integer feishuDepartmentStatus;

    //部门负责人id
    private String departmentLeaderEmployeeId;

    //部门负责人名称
    private String departmentLeaderEmployeeName;

    //组织架构码
    private String organizationCode;

    //组织架构名称
    private String organizationName;

    //个人编码
    private String individualCode;

    //个人特征编码
    private String featuresCode;

    //角色
    private String role;

    //身份类型，业务角色
    private String identityType;

    //入职时间
    private Date joinTime;

    //用户自定义信息-工作地
    private String workPlace;

    //城市
    private String city;

    private String customAttrs;

    private String employeeBelongTo;

    private String unionId;

    public String getEmployeeBelongTo() {
        return employeeBelongTo;
    }

    public void setEmployeeBelongTo(String employeeBelongTo) {
        this.employeeBelongTo = employeeBelongTo;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getCustomAttrs() {
        return customAttrs;
    }

    public void setCustomAttrs(String customAttrs) {
        this.customAttrs = customAttrs;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePy() {
        return namePy;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(String employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLeaderEmployeeId() {
        return leaderEmployeeId;
    }

    public void setLeaderEmployeeId(String leaderEmployeeId) {
        this.leaderEmployeeId = leaderEmployeeId;
    }

    public String getLeaderEmployeeName() {
        return leaderEmployeeName;
    }

    public void setLeaderEmployeeName(String leaderEmployeeName) {
        this.leaderEmployeeName = leaderEmployeeName;
    }

    public String getFeishuDepartments() {
        return feishuDepartments;
    }

    public void setFeishuDepartments(String feishuDepartments) {
        this.feishuDepartments = feishuDepartments;
    }

    public String getFeishuDepartmentName() {
        return feishuDepartmentName;
    }

    public void setFeishuDepartmentName(String feishuDepartmentName) {
        this.feishuDepartmentName = feishuDepartmentName;
    }

    public String getParentFeishuDepartmentId() {
        return parentFeishuDepartmentId;
    }

    public void setParentFeishuDepartmentId(String parentFeishuDepartmentId) {
        this.parentFeishuDepartmentId = parentFeishuDepartmentId;
    }

    public String getParentFeishuDepartmentName() {
        return parentFeishuDepartmentName;
    }

    public void setParentFeishuDepartmentName(String parentFeishuDepartmentName) {
        this.parentFeishuDepartmentName = parentFeishuDepartmentName;
    }

    public Integer getFeishuDepartmentStatus() {
        return feishuDepartmentStatus;
    }

    public void setFeishuDepartmentStatus(Integer feishuDepartmentStatus) {
        this.feishuDepartmentStatus = feishuDepartmentStatus;
    }

    public String getDepartmentLeaderEmployeeId() {
        return departmentLeaderEmployeeId;
    }

    public void setDepartmentLeaderEmployeeId(String departmentLeaderEmployeeId) {
        this.departmentLeaderEmployeeId = departmentLeaderEmployeeId;
    }

    public String getDepartmentLeaderEmployeeName() {
        return departmentLeaderEmployeeName;
    }

    public void setDepartmentLeaderEmployeeName(String departmentLeaderEmployeeName) {
        this.departmentLeaderEmployeeName = departmentLeaderEmployeeName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getIndividualCode() {
        return individualCode;
    }

    public void setIndividualCode(String individualCode) {
        this.individualCode = individualCode;
    }

    public String getFeaturesCode() {
        return featuresCode;
    }

    public void setFeaturesCode(String featuresCode) {
        this.featuresCode = featuresCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
