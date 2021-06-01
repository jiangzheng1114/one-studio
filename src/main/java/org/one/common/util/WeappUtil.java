//package org.one.common.util;
//
//import java.io.InputStream;
//import java.util.concurrent.TimeUnit;
//
//import org.one.common.base.code.ConfigCode;
//import org.one.system.controller.weapp.WeappBaseController;
//import org.one.system.service.OneFileService;
//import org.one.system.service.RedisService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.alibaba.fastjson.JSONObject;
//
//public class WeappUtil {
//	
//	private final static Logger logger = LoggerFactory.getLogger(WeappBaseController.class);
//
//	public static String getAccessToken() {
//		RedisService redisService = SpringUtil.getBean("redisService", RedisService.class);
//		ConfigCode configCode = SpringUtil.getBean("configCode", ConfigCode.class);
//		Object accessToken = redisService.get("accessToken");
//		try {
//			if(accessToken == null) {
//				HttpsClient httpsClient = new HttpsClient();
//				String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?"
//						+ "grant_type=client_credential&appid=" + configCode.getWeappAppid() + "&secret=" + configCode.getWeappSecret();
//				Response response = httpsClient.get(accessTokenUrl);
//				accessToken = response.asJSONObject().getString("access_token");
//				redisService.set("accessToken", accessToken, 7000, TimeUnit.SECONDS);
//			}
//		} catch (Exception e) {
//			logger.error("小程序获取AccessToken失败", e);
//		}
//		return accessToken.toString();
//	}
//	
//	/**
//	 * 小程序码打开路径
//	 * @param path
//	 */
//	public static void getWxacode(String path) {
//		OneFileService oneFileService = SpringUtil.getBean("oneFileService", OneFileService.class);
//		try {
//			String accessToken = getAccessToken();
//			String wxacodeUrl = "https://api.weixin.qq.com/wxa/getwxacode?access_token="+accessToken;
//			JSONObject options = new JSONObject();
//			options.put("path", path);
//			HttpsClient httpsClient = new HttpsClient();
//			Response response = httpsClient.post(wxacodeUrl, options);
//			InputStream inputStream =  response.asStream();
//			MultipartFile multipartFile = new MockMultipartFile("小程序码.jpg", "小程序码.jpg", null, inputStream);
//			oneFileService.uploadImage(multipartFile);
//		} catch (Exception e) {
//			logger.error("小程序获取小程序码失败", e);
//		}
//	}
//}
