package com.gosuncn.pfr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class TblFeature implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 特征ID
     */
    @TableId(value = "FEATURE_ID", type = IdType.AUTO)
    private Integer featureId;

    /**
     * 人员ID
     */
    @TableField("RESIDENT_ID")
    private Integer residentId;

    /**
     * 特征类型，见tbl_property表FEATURE_TYPE
     */
    @TableField("FEATURE_TYPE")
    private Integer featureType;

    /**
     * 特征模板数据，如指纹模板
     */
    @TableField("FEATURE_DATA")
    private String featureData;

    /**
     * 存储的UUID
     */
    @TableField("STORE_UUID")
    private String storeUuid;

    /**
     * 特征文件URL
     */
    @TableField("FEATURE_URL")
    private String featureUrl;

    /**
     * 人脸检测返回的faceId
     */
    @TableField("FACE_ID")
    private Integer faceId;

    /**
     * 采集时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 最新更新时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;


}
