package com.jad.jad.biz.mapstruct.convert;

import com.jad.jad.biz.mapstruct.model.AddressDO;
import com.jad.jad.biz.mapstruct.model.AddressVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nice
 * @create 2022/1/20 2:13 下午
 * @desc
 */
@Mapper
public interface AddressConvert {

    AddressConvert INSTANCE = Mappers.getMapper(AddressConvert.class);

    AddressVO toAddressVO(AddressDO address);

    AddressDO toAddressDO(AddressVO address);

}
