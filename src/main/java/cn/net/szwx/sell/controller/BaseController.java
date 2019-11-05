package cn.net.szwx.sell.controller;

import cn.net.szwx.sell.common.Constants;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class BaseController {
    public JSONObject resultSuccess() {
        return resultSuccess("成功");
    }

    public JSONObject resultSuccess(String info) {
        JSONObject json = new JSONObject();
        json.put("status", Constants.SUCCESS);
        json.put("info", info);
        return json;
    }

    public JSONObject resultError() {
        return resultError("失败");
    }

    public JSONObject resultError(String info) {
        JSONObject json = new JSONObject();
        json.put("status", Constants.FAILURE);
        if (StringUtils.isNotBlank(info)) {
            json.put("info", info);
        }
        return json;
    }
}
