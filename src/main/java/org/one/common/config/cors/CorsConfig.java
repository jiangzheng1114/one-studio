
/** 
 * @单位名称：暂无公司
 * @Copyright (c) 2018 All Rights Reserved.
 * @系统名称：Victor
 * @工程名称：world-base
 * @文件名称: CorsConfig.java
 * @类路径: com.world.config.cors
 */

		package org.one.common.config.cors;

import org.one.common.base.code.ApplyCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/** 
 *
 * @see
 * @author  wangyao
 * @date	2018年1月27日 下午5:37:07
 * @version
 * @desc    TODO
 */
@Configuration
public class CorsConfig {
	private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addExposedHeader(ApplyCode.TOKEN);
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }
 
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
	
}