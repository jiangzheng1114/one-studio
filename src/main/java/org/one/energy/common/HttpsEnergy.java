/*
package org.one.energy.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.one.energy.entity.TEnergyData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpsEnergy {

    public static final String enterpriseCode = "91340200743082289Q";

    public static final String region = "340207";

    // 注册
    public static JSONObject register() throws Exception {
        HttpsUtil httpsUtil = new HttpsUtil();
        Map map = new HashMap<String, Object>();
		map.put("enterpriseCode", enterpriseCode);// 企业的统一社会信用代码
		map.put("region", region);// 企业所在行政区域的行政区划代码
		String res = httpsUtil.post("https://60.173.251.252:8743/sx/inf/upload/register", new Gson().toJson(map));
        return JSON.parseObject(res);
    }

    public static void main(String[] args) throws Exception{
//        JSONObject res = HttpsEnergy.register();
//        System.out.println(res);
    }
}
*/
