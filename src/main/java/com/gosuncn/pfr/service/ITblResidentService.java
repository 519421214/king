package com.gosuncn.pfr.service;

import com.gosuncn.pfr.entity.TblResident;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tools
 * @since 2019-08-15
 */
public interface ITblResidentService extends IService<TblResident> {
    void faceRegisterAgain();
}
