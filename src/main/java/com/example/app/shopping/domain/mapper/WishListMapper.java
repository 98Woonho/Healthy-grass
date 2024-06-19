package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.WishlistDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.WildcardType;

@Mapper
public interface WishListMapper {
    void insertWish(@Param("Pid") Long Pid, @Param("Uid") String Uid);

    WishlistDto findWishByPidAndUid(@Param("Pid") Long Pid, @Param("Uid") String Uid);
}
