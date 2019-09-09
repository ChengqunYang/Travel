package com.monster.travel.service.impl;

import com.monster.travel.dao.FavoriteDao;
import com.monster.travel.dao.impl.FavoriteDaoImpl;
import com.monster.travel.domain.Favorite;
import com.monster.travel.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {

        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite != null;  //如果查出的favorite对象有值则返回true
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid), uid);
    }
}
