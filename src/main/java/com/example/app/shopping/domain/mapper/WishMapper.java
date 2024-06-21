package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.WishDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WishMapper {
    void insertWish(@Param("Pid") Long Pid, @Param("Uid") String Uid);

    WishDto findWishByPidAndUid(@Param("Pid") Long Pid, @Param("Uid") String Uid);

    List<Map<String, Object>> findWishListByCriteriaAndUid(@Param("criteria") Criteria criteria, @Param("offset") int offset, @Param("Uid") String Uid);

    int findWishCountByUid(@Param("Uid") String Uid);

    void deleteWishByPidAndUid(@Param("Pid") Long pId, @Param("Uid") String uId);
}
