package org.one.common.base.code;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 *
 * @see
 * @author  wangyao
 * @date	2018年5月15日 下午10:36:40
 * @version
 */
@Component
public class ConfigCode {
	
//	@Value("${spring.redis.host}")
//	private String redisHost;
//
//	@Value("${spring.redis.port}")
//	private int redisPort;
//
//	@Value("${spring.redis.timeout}")
//	private int redisTimeout;
//
//	@Value("${spring.redis.expiretime}")
//	private int redisExpire;
	
	@Value("${file.path}")
	private String filePath;
	
	@Value("${file.httppath}")
	private String fileHttpPath;
	
	@Value("${weapp.appid}")
	private String weappAppid;
	
	@Value("${weapp.secret}")
	private String weappSecret;
	
	@Value("${weapp.sure_template_id}")
	private String sureTemplateId;
	
	@Value("${weapp.reject_template_id}")
	private String rejectTemplateId;

	public String getFilePath() {
		return filePath;
	}

	public String getFileHttpPath() {
		return fileHttpPath;
	}

	public String getWeappAppid() {
		return weappAppid;
	}

	public String getWeappSecret() {
		return weappSecret;
	}

	public String getSureTemplateId() {
		return sureTemplateId;
	}

	public String getRejectTemplateId() {
		return rejectTemplateId;
	}
	
}

		