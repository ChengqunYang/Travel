package com.monster.travel.service.impl;

import com.monster.travel.dao.CategoryDao;
import com.monster.travel.dao.impl.CategoryDaoImpl;
import com.monster.travel.domain.Category;
import com.monster.travel.service.CategoryService;
import com.monster.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Category> findAll() {
        //1.从redis中查询
            //1.1获取jedis的客户端
        Jedis jedis = JedisUtil.getJedis();
            //1.2使用sortedset排序查询
//        Set<String> categorys = jedis.zrange("category",0,-1);
            //1.3查询sortedset中的分数的(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs = null;
        //2.判断查询的集合是否为空
        if (categorys == null || categorys.size() == 0) {

            //3.如果为空,需要从数据库查询,再将结果存入到redis中
            //3.1从数据库查询
            cs = categoryDao.findAll();
            //3.2将数据存储到redis中的category的key中
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {
            //4.如果不为空,将set集合转化为list集合后返回
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                cs.add(category);
            }
        }

        return cs;
    }
}
