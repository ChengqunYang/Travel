package com.monster.travel.dao;

import com.monster.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    /**
     * 根据cid查询总记录数
     *
     * @param cid
     * @return
     */
    int findTotalCount(int cid, String rname);

    /**
     * 根据cid,start,pageSize查询当前页的数据
     *
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    List<Route> findByPage(int cid, int start, int pageSize, String rname);

    /**
     *根据id查询
     * @param rid
     * @return
     */
    Route findOne(int rid);
}
