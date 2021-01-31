package com.mudemo.dao;

import com.alibaba.fastjson.JSONObject;
import com.mudemo.model.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {
    @Select("SELECT * FROM mutest.goods")
    List<Goods> getGoodsList();

    @Insert("INSERT INTO mutest.goods(type,name,price,size,status,description)VALUES(#{type},#{name},#{price},#{size},#{status},#{description})")
    int addGood(JSONObject request);

    @Update("UPDATE mutest.goods SET type=#{type},name=#{name},price=#{price},size=#{size},status=#{status},description=#{description} WHERE id=#{id}")
    void updateGood(JSONObject request);

    @Delete("DELETE FROM mutest.goods WHERE id=#{id}")
    void deleteGood(@Param("id") int id);

    List<Goods> searchGoods(JSONObject request);
}
