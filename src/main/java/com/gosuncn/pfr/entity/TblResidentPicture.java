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
 * 人员图像库
 * </p>
 *
 * @author tools
 * @since 2019-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TblResidentPicture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 照片类型。 1 正面  2身份证正面 3 身份证背面
     */
    @TableField("TYPE")
    private Integer type;

    /**
     * 图片URL
     */
    @TableField("PICTURE_URL")
    private String pictureUrl;

    /**
     * 人员身份证号
     */
    @TableField("ID_NUMBER")
    private String idNumber;

    /**
     * 插入日期
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 存储的UUID
     */
    @TableField("STORE_UUID")
    private String storeUuid;

    /**
     * 存储参数
     */
    @TableField("STORE_PARAM")
    private String storeParam;

    /**
     * 人脸注册返回的ID
     */
    @TableField("FACE_ID")
    private Integer faceId;

    /**
     * 特征id
     */
    @TableField("FEATURE_ID")
    private Integer featureId;

    /**
     * 人脸下发状态
     */
    @TableField("FACE_STATUS")
    private Integer faceStatus;


}
