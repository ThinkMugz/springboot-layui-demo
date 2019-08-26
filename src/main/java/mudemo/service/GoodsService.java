package mudemo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;


@Service
public interface GoodsService {
    JSONObject getGoodsList(int pageNum, int pageSize);

    JSONObject addGood(JSONObject request);

    JSONObject updateGood(JSONObject request);

    JSONObject deleteGood(int id);
}
