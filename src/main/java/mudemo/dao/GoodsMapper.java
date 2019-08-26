package mudemo.dao;

import com.alibaba.fastjson.JSONObject;
import mudemo.model.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("SELECT * FROM mutest.goods")
    List<Good> getGoodsList();

    @Insert("INSERT INTO mutest.goods(type,name,price,size,status,description)VALUES(#{type},#{name},#{price},#{size},#{status},#{description})")
    int addGood(JSONObject request);

    @Update("UPDATE mutest.goods SET type=#{type},name=#{name},price=#{price},size=#{size},status=#{status},description=#{description} WHERE id=#{id}")
    void updateGood(JSONObject request);

    @Delete("DELETE FROM mutest.goods WHERE id=#{id}")
    void deleteGood(@Param("id") int id);
}
