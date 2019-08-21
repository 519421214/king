package com.gosuncn.pfr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author tools
 * @since 2019-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TblResident implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 人员ID
     */
    @TableId(value = "RESIDENT_ID", type = IdType.AUTO)
    private Integer residentId;

    /**
     * 人员编号,不能重复
     */
    @TableField("RESIDENT_CODE")
    private String residentCode;

    /**
     * 姓名（境外人的姓）
     */
    @TableField("RESIDENT_NAME")
    private String residentName;

    /**
     * 人员类别 1 租客 2房东   值在tbl_property定义
     */
    @TableField("RESIDENT_TYPE")
    private Integer residentType;

    /**
     * 境外人的名
     */
    @TableField("GIVEN_NAME")
    private String givenName;

    /**
     * 性别,  0:男  1:女
     */
    @TableField("SEX")
    private Integer sex;

    /**
     * 身份证号, 不能重复（证件号码）
     */
    @TableField("ID_NUMBER")
    private String idNumber;

    /**
     * 国籍 见tbl_country
     */
    @TableField("COUNTRY")
    private String country;

    /**
     * 民族 见tbl_nation
     */
    @TableField("NATION")
    private Integer nation;

    /**
     * 户籍地址
     */
    @TableField("PERMANENT_ADDRESS")
    private String permanentAddress;

    /**
     * 移动电话
     */
    @TableField("MOBILE_PHONE")
    private String mobilePhone;

    /**
     * 固定电话
     */
    @TableField("TELEPHONE")
    private String telephone;

    /**
     * 人员状况
     */
    @TableField("RESIDENT_STATUS")
    private String residentStatus;

    /**
     * 重点人员关注字段
     */
    @TableField("RESIDENT_SPECAIL_LABEL")
    private Integer residentSpecailLabel;

    /**
     * 文化程度,见字典EDUCATION
     */
    @TableField("EDUCATION")
    private Integer education;

    /**
     * 婚姻情况
     */
    @TableField("MARITAL_STATUS")
    private String maritalStatus;

    /**
     * 配偶姓名
     */
    @TableField("SPOUSE_NAME")
    private String spouseName;

    /**
     * 职业
     */
    @TableField("OCCUPATION")
    private String occupation;

    /**
     * 是否核查 '0'否  ‘1’是  ‘2’不通过
     */
    @TableField("IS_CHECKED")
    private String isChecked;

    /**
     * 核查时间
     */
    @TableField("CHECKED_TIME")
    private LocalDateTime checkedTime;

    /**
     * 生育动态
     */
    @TableField("BIRTH_DYNAMICS")
    private String birthDynamics;

    /**
     * 避孕动态
     */
    @TableField("CONTRACEPTION_DYNAMICS")
    private String contraceptionDynamics;

    /**
     * 持证情况
     */
    @TableField("HOLD_CERTIFICATE_STATUS")
    private String holdCertificateStatus;

    /**
     * 是否已注销, 0正常  1注销
     */
    @TableField("IS_CANCEL")
    private Integer isCancel;

    /**
     * 注销时间
     */
    @TableField("CANCEL_TIME")
    private LocalDateTime cancelTime;

    /**
     * 工作单位
     */
    @TableField("COMPANY")
    private String company;

    /**
     * 单位地址
     */
    @TableField("COMPANY_ADDRESS")
    private String companyAddress;

    /**
     * 单位负责人
     */
    @TableField("COMPANY_PRINCIPAL")
    private String companyPrincipal;

    /**
     * 单位联系电话
     */
    @TableField("COMPANY_PRINCIPAL_PHONE")
    private String companyPrincipalPhone;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 注册时间
     */
    @TableField("REGISTER_TIME")
    private LocalDateTime registerTime;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 录入类型：1读卡录入 2手工录入。默认为2
     */
    @TableField("CHECKIN_TYPE")
    private Integer checkinType;

    /**
     * 居住类型 见字典
     */
    @TableField("LIVING_WAY")
    private Integer livingWay;

    /**
     * 证件类型 见字典
     */
    @TableField("CERTIFICATE_TYPE")
    private Integer certificateType;

    /**
     * 证件有效期
     */
    @TableField("VALID_DATE")
    private LocalDate validDate;

    /**
     * 出生日期
     */
    @TableField("BIRTH_DATE")
    private LocalDate birthDate;

    /**
     * 微信用户唯一标识
     */
    @TableField("WX_OPENID")
    private String wxOpenid;

    /**
     * APP登录权鉴
     */
    @TableField("APP_PERMISSION")
    private Integer appPermission;

    /**
     * 人员类型，参见属性表
     */
    @TableField("PERSON_TYPE")
    private Integer personType;

    /**
     * 人脸注册返回personId
     */
    @TableField("PERSON_ID")
    private Integer personId;


}
