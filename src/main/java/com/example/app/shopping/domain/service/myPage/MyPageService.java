package com.example.app.shopping.domain.service.myPage;

import com.example.app.shopping.domain.dto.ShippingAddressDto;
import com.example.app.shopping.domain.mapper.ShippingAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyPageService {
    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    @Transactional(rollbackFor = Exception.class)
    public void modifyShippingAddress(ShippingAddressDto shippingAddressDto) {
        shippingAddressMapper.updateShippingAddress(shippingAddressDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void registerShippingAddress(ShippingAddressDto shippingAddressDto) {
        shippingAddressMapper.insertShippingAddress(shippingAddressDto);
    }

    // 유저의 배송지가 존재하는지 확인
    public ShippingAddressDto isExistShippingAddress(String Uid) {
        return shippingAddressMapper.findShippingAddressByUid(Uid);
    }
}
