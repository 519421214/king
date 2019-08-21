package com.gosuncn.pfr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gosuncn.pfr.entity.TblResident;
import com.gosuncn.pfr.mapper.TblResidentMapper;
import com.gosuncn.pfr.service.ITblResidentService;
import com.gosuncn.pfr.utils.Log;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tools
 * @since 2019-08-15
 */
@Service
public class TblResidentServiceImpl extends ServiceImpl<TblResidentMapper, TblResident> implements ITblResidentService {

    @Override
    public void faceRegisterAgain() {
        QueryWrapper<TblResident> personWrapper = new QueryWrapper();
        personWrapper.isNull("PERSON_ID");
        List<TblResident> residents = this.list(personWrapper);
        int registerNum = 0;
        if (!ObjectUtils.isEmpty(residents)) {

        }
        Log.info("人脸重新注册情况：未注册总数：{}，重新注册数：{}",residents.size(),registerNum);
    }
}
