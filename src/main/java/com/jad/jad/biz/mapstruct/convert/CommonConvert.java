package com.jad.jad.biz.mapstruct.convert;

import com.jad.jad.biz.mapstruct.model.UserDAO;
import com.jad.jad.biz.mapstruct.model.UserDO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author nice
 * @create 2022/1/20 10:59 上午
 * @desc
 */
@Mapper(uses = AddressConvert.class)
public interface CommonConvert {

    CommonConvert INSTANCE = Mappers.getMapper(CommonConvert.class);

    @Mapping(source = "province", target = "address.province")
    @Mapping(source = "city", target = "address.city")
    @Mapping(source = "area", target = "address.area")
    @Mapping(target = "ctime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserDO toUserDO(UserDAO user);

    @InheritInverseConfiguration // 表示DO转为DAO使用上面的同样规则
    UserDAO toUserDAO(UserDO user);
}
