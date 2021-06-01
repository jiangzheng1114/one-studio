package org.one.system.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.system.controller.web.UserController;
import org.one.system.entity.OneWebview;
import org.one.system.service.OneWebviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app/webview")
public class AppWebviewController {
	
	private final static Logger logger = LoggerFactory.getLogger(AppWebviewController.class);
	
	@Autowired
	private OneWebviewService oneWebviewService;
	
	@RequestMapping(value = "/getUrl")
	@ResponseBody
	public RespEntity<OneWebview> getUrl(HttpServletRequest request){
		RespEntity<OneWebview> resp = new RespEntity<>();
		try {
			OneWebview webview = oneWebviewService.getForApp();
			resp.setHttpCode(HttpCode.Success);
			resp.setData(webview);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("AppWebviewController.getUrl:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}

}
