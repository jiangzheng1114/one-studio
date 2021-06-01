package org.one.system.service.impl;

import org.one.system.entity.OneWebview;
import org.one.system.mapper.OneWebviewMapper;
import org.one.system.service.OneWebviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneWebviewServiceImpl implements OneWebviewService{
	
	@Autowired
	private OneWebviewMapper oneWebviewMapper;

	@Override
	public OneWebview getForApp() {
		OneWebview oneWebview = new OneWebview();
		oneWebview.setStatus(OneWebview.Status.Normal.getCode());
		oneWebview.setType(OneWebview.Type.App.getCode());
		return oneWebviewMapper.findList(oneWebview).get(0);
	}

}
