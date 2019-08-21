package com.gosuncn.pfr.bean.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public final class InitParameters {
    public static Map<String,String> COMPANY_BY_DEVICE = new HashMap<>();
    public static Map<String,Integer> PERSON_TYPE_BY_FACE_CODE = new HashMap<>();
    //用于下发设备
    public static BiFunction<String,Integer,String> deviceUrlPrefix = (x, y)-> "http://" + x +  ":" + Optional.ofNullable(y).orElse(80) + "/v1/MEGBOX/";
    //用于保存图片
    public static UnaryOperator<String> appendFileStoreUrl = (x) -> "http://" + x + "/api/v1/fileStoreBase64";;

    //删除人脸
    public static final String INTERFACE_FACES_FACETOKEN = "faces/faceToken/";
    //删除人脸原图
    public static final String INTERFACE_FACES_IMAGE = "faces/image/";
    //下发新增人脸
    public static final String INTERFACE_FACES= "faces";
    //绑定post解除delete分组 /faceGroups/{groupName}/{faceToken}
    public static final String INTERFACE_FACE_GROUPS= "faceGroups";
    //绑定post解除delete分组 /faceGroups/{groupName}/{faceToken}
}
