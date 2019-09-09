package com.monster.travel.dao;

import com.monster.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {
    /**
     * 根据route的id查询图片
     * @param rid
     * @return
     */
    List<RouteImg> findById(int rid);
}
