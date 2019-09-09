package com.monster.travel.service;

import com.monster.travel.domain.PageBean;
import com.monster.travel.domain.Route;

/**
 * 线路service
 */
public interface RouteService {
    /**
     *  根据类别和关键字进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    Route findOne(String rid);
}
