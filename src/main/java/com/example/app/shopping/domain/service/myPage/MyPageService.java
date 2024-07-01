package com.example.app.shopping.domain.service.myPage;

import com.example.app.shopping.domain.dto.ShippingAddressDto;
import com.example.app.shopping.domain.dto.WishDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.mapper.ShippingAddressMapper;
import com.example.app.shopping.domain.mapper.WishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
    public Map<String, Object> addWish(WishDto wishDto) {
        Map<String, Object> result = new HashMap<>();

        WishDto wishlistDto = wishMapper.findWish(wishDto);

        if (wishlistDto != null) {
            result.put("success", false);
            result.put("msg", "이미 찜리스트에 등록된 상품입니다.");

            return result;
        }

        int returnVal = wishMapper.insertWish(wishDto);

        if (returnVal < 1) {
            result.put("success", false);
            result.put("msg", "찜리스트에 등록을 실패하였습니다. 현상이 계속된다면 관리자에게 문의바랍니다.");
        } else {
            result.put("success", true);
            result.put("msg", "찜리스트 등록에 성공하였습니다. 마이페이지에서 확인가능합니다.");
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteWish(List<Long> pIdList, String uId) {
        for (Long pId : pIdList) {
            wishMapper.deleteWishByPidAndUid(pId, uId);
        }
    }

    // 유저의 배송지가 존재하는지 확인
    public ShippingAddressDto isExistShippingAddress(String Uid) {
        return shippingAddressMapper.findShippingAddressByUid(Uid);
    }
}
