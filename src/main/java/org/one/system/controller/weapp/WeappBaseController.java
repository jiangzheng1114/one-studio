//package org.one.system.controller.weapp;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.one.common.base.RespEntity;
//import org.one.common.base.code.ConfigCode;
//import org.one.common.base.code.HttpCode;
//import org.one.common.util.HttpsClient;
//import org.one.common.util.Response;
//import org.one.common.util.WeappUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSONObject;
//
//@Controller
//@RequestMapping("/weapp")
//public class WeappBaseController {
//	
//	private final static Logger logger = LoggerFactory.getLogger(WeappBaseController.class);
//	
//	@Autowired
//	private ConfigCode configCode;
//	
//	@RequestMapping(value = "/onLogin")
//	@ResponseBody
//	public RespEntity<String> onLogin(HttpServletRequest request, String code) throws IOException{
//		RespEntity<String> resp = new RespEntity<>();
//		HttpsClient httpsClient = new HttpsClient();
//		String url = "https://api.weixin.qq.com/sns/jscode2session?";
//		String optionStr = "appid=" + configCode.getWeappAppid() + "&secret=" + configCode.getWeappSecret() + "&js_code=" + code
//				+ "&grant_type=authorization_code";
//		try {
//			Response response = httpsClient.get(url + optionStr);
//			logger.info("WxResponse={}", response.asString());
//			String openid = response.asJSONObject().getString("openid");
//			resp.setHttpCode(HttpCode.Success);
//			resp.setData(openid);
//		} catch (Exception e) {
//			resp.setHttpCode(HttpCode.Error);
//			logger.error("小程序登录失败", e);
//		}
//		return resp;
//	}
//	
//	/**
//	 * demo 已无效
//	 * @param request
//	 * @param name
//	 * @param age
//	 * @param phone
//	 * @param openid
//	 * @param formid
//	 * @return
//	 * @throws IOException
//	 */
//	@RequestMapping(value = "/sendTemplate")
//	@ResponseBody
//	public RespEntity<String> sendTemplate(HttpServletRequest request,
//			String name, String age, String phone,
//			String openid, String formid) throws IOException{
//		RespEntity<String> resp = new RespEntity<>();
//		try {
//			HttpsClient httpsClient = new HttpsClient();
//			//模板消息-请求URL
//			String accessToken = WeappUtil.getAccessToken();
//			String sendUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+accessToken;
//			//模板消息-请求参数
//			JSONObject options = new JSONObject();
//			options.put("touser", openid);
//			options.put("template_id", configCode.getSureTemplateId());
//			options.put("form_id", formid);
//			options.put("page", "pages/index/index?query=11");
//			JSONObject data = new JSONObject();
//			JSONObject keyword1Value = new JSONObject();
//			keyword1Value.put("value", name);
//			data.put("keyword1", keyword1Value);
//			JSONObject keyword2Value = new JSONObject();
//			keyword2Value.put("value", age);
//			data.put("keyword2", keyword2Value);
//			JSONObject keyword3Value = new JSONObject();
//			keyword3Value.put("value", phone);
//			data.put("keyword3", keyword3Value);
//			options.put("data", data);
//			Response response = httpsClient.post(sendUrl, options);
//			logger.info("WxResponse={}", response.asString());
//			resp.setHttpCode(HttpCode.Success);
//		} catch (Exception e) {
//			resp.setHttpCode(HttpCode.Error);
//			logger.error("小程序模板消息发送失败", e);
//		}
//		return resp;
//	}
//	
//	@RequestMapping(value = "/getWxacode")
//	@ResponseBody
//	public RespEntity<String> getWxacode(HttpServletRequest request){
//		RespEntity<String> resp = new RespEntity<>();
//		WeappUtil.getWxacode("pages/index/index?query=12");
//		return resp;
//	}
//	
//	
//}
