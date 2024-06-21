package com.example.app.shopping.domain.service.myPage;

import com.example.app.shopping.domain.dto.ShippingAddressDto;
import com.example.app.shopping.domain.dto.WishDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.mapper.ShippingAddressMapper;
import com.example.app.shopping.domain.mapper.WishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MyPageService {
    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    @Autowired
    private WishMapper wishMapper;

    @Transactional(rollbackFor = Exception.class)
    public int getWishCount(String Uid) {
        return wishMapper.findWishCountByUid(Uid);
    }

    @Transactional(rollbackFor = Exception.class)
    public void modifyShippingAddress(ShippingAddressDto shippingAddressDto) {
        shippingAddressMapper.updateShippingAddress(shippingAddressDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void registerShippingAddress(ShippingAddressDto shippingAddressDto) {
        shippingAddressMapper.insertShippingAddress(shippingAddressDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, Object>> getWishList(Criteria criteria, int offset, String Uid) {
        return wishMapper.findWishListByCriteriaAndUid(criteria, offset, Uid);
    }

    @Transactional(rollbackFor = Exception.class)
    public String addWish(Long Pid, String Uid) {
        WishDto wishlistDto = wishMapper.findWishByPidAndUid(Pid, Uid);

        if (wishlistDto != null) {
            return "FAILURE_DUPLICATE_WISH";
        }

        wishMapper.insertWish(Pid, Uid);

        return "SUCCESS";
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteWish(Long pId, String uId) {
        wishMapper.deleteWishByPidAndUid(pId, uId);
    }

    // 유저의 배송지가 존재하는지 확인
    public ShippingAddressDto isExistShippingAddress(String Uid) {
        return shippingAddressMapper.findShippingAddressByUid(Uid);
    }
}
