package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.ShippingAddressDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShippingAddressMapper {
    ShippingAddressDto findShippingAddressByUid(@Param("Uid") String Uid);

    void updateShippingAddress(ShippingAddressDto shippingAddressDto);

    void insertShippingAddress(ShippingAddressDto shippingAddressDto);
}
