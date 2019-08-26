package mudemo.controller;

import com.alibaba.fastjson.JSONObject;
import mudemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guozhengMu
 * @version 1.0
 * @date 2019/8/26 16:51
 * @description
 * @modify
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/goodsList", method = RequestMethod.GET)
    public JSONObject getGoodsList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return goodsService.getGoodsList(pageNum, pageSize);
    }

    @RequestMapping(value = "/updateGood", method = RequestMethod.POST)
    public JSONObject updateGood(@RequestBody JSONObject request) {
        return goodsService.updateGood(request);
    }

    @RequestMapping(value = "/addGood", method = RequestMethod.POST)
    public JSONObject addGood(@RequestBody JSONObject request) {
        return goodsService.addGood(request);
    }

    @RequestMapping(value = "/deleteGood", method = RequestMethod.GET)
    public JSONObject deleteGood(@RequestParam("id") int id) {
        return goodsService.deleteGood(id);
    }
}
