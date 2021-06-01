
/** 
 * @单位名称：暂无公司
 * @Copyright (c) 2018 All Rights Reserved.
 * @系统名称：Victor
 * @工程名称：personal-cake
 * @文件名称: MybatisConfig.java
 * @类路径: system.manage.config
 */

package org.one.common.config.mybatis;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 *
 * @see
 * @author wangyao
 * @date 2018年4月30日 下午8:05:19
 * @version
 * @desc TODO
 */
@Configuration
public class MybatisConfig {
	
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		// 添加配置，也可以指定文件路径
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
	
}
