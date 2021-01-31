package com.mudemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mudemo.dao.GoodsDao;
import com.mudemo.model.Goods;
import com.mudemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guozhengMu
 * @version 1.0
 * @date 2019/8/26 16:55
 * @description
 * @modify
 */
@Service(value = "GoodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public JSONObject getGoodsList(int pageNum, int pageSize) {
        JSONObject result = new JSONObject();
        try {
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Goods> pageInfo = new PageInfo(goodsDao.getGoodsList());

            result.put("code", "0");
            result.put("msg", "操作成功！");
            result.put("data", pageInfo.getList());
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询异常！");
        }
        return result;
    }

    @Override
    public JSONObject addGood(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            goodsDao.addGood(request);
            result.put("code", "0");
            result.put("msg", "操作成功！");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "新增商品异常！");
        }
        return result;
    }

    @Override
    public JSONObject updateGood(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            goodsDao.updateGood(request);
            result.put("code", "0");
            result.put("msg", "操作成功！");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "修改商品异常！");
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public JSONObject deleteGood(int id) {
        JSONObject result = new JSONObject();
        try {
            goodsDao.deleteGood(id);
            result.put("code", "0");
            result.put("msg", "操作成功！");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "删除商品异常！");
        }
        return result;
    }

    @Override
    public JSONObject searchGoods(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            int pageNum = request.getInteger("pageNum");
            int pageSize = request.getInteger("pageSize");
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Goods> pageInfo = new PageInfo(goodsDao.searchGoods(request));

            result.put("code", "0");
            result.put("msg", "操作成功！");
            result.put("data", pageInfo.getList());
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询商品异常！");
        }
        return result;
    }
}
