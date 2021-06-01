package org.one.system.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.one.common.util.ImageHelper;
import org.one.system.entity.OneFile;
import org.one.system.mapper.OneFileMapper;
import org.one.system.service.OneFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service("oneFileService")
@Transactional
public class OneFileServiceImpl implements OneFileService {
	
	@Autowired
	private OneFileMapper oneFileMapper;

	@Override
	public Long insertFile(OneFile file) {
		oneFileMapper.insertSelective(file);
		return file.getId();
	}

	@Override
	public OneFile getById(Long id) {
		return oneFileMapper.selectByPrimaryKey(id);
	}

	@Override
	public OneFile uploadImage(MultipartFile file) {
		OneFile oneFile = new OneFile();
		try {
	        byte[] bytes = file.getBytes();
	        String oldname = file.getOriginalFilename();
	        String type = oldname.substring(oldname.lastIndexOf(".")+1);;
	        String newname = System.currentTimeMillis() + "." + type;
	        String path = OneFile.getImgPath() + newname;
	        String httppath = OneFile.getImgHttpPath() + newname;
	        Path newpath = Paths.get(path);
	        Files.write(newpath, bytes);
	        //创建缩略图
	        String smallname = ImageHelper.thumbnailImage(newname);
	        String smallhttppath = OneFile.getImgHttpPath() + smallname;
	        //写入数据库
	        oneFile.setOldname(oldname);
	        oneFile.setNewname(newname);
	        oneFile.setType(type);
	        oneFile.setSize(file.getSize());
	        oneFile.setPath(path);
	        oneFile.setHttppath(httppath);
	        oneFile.setSmallhttppath(smallhttppath);
	        oneFileMapper.insertSelective(oneFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return oneFile;
	}

	@Override
	public OneFile uploadFile(MultipartFile file) {
		OneFile oneFile = new OneFile();
		try {
	        byte[] bytes = file.getBytes();
	        String oldname = file.getOriginalFilename();
	        String type = oldname.substring(oldname.lastIndexOf(".")+1);;
	        String newname = System.currentTimeMillis() + "." + type;
	        String path = OneFile.getFilePath()+ newname;
	        String httppath = OneFile.getHttpFilePath() + newname;
	        Path newpath = Paths.get(path);
	        Files.write(newpath, bytes);
	        //写入数据库
	        oneFile.setOldname(oldname);
	        oneFile.setNewname(newname);
	        oneFile.setType(type);
	        oneFile.setSize(file.getSize());
	        oneFile.setPath(path);
	        oneFile.setHttppath(httppath);
	        oneFileMapper.insertSelective(oneFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return oneFile;
	}

	@Override
	public int insertFileTemp(OneFile record) {
		return oneFileMapper.insertFileTemp(record);
	}

	@Override
	public List<OneFile> getFileTempByContext(String context) {
		return oneFileMapper.getFileTempByContext(context);
	}
	
}
