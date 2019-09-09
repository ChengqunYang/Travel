package com.monster.travel.dao;

import com.monster.travel.domain.Favorite;

public interface FavoriteDao {

    /**
     * 根据rid和uid查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    Favorite findByRidAndUid(int rid,int uid);

    /**
     * 根据rid查询收藏次数
     * @param rid
     * @return
     */
    int findCountByRid(int rid);

    /**
     * 根据rid和uid来添加收藏
     * @param i
     * @param uid
     */
    void add(int i, int uid);
}
