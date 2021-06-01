package org.one.system.controller.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.system.entity.OneFile;
import org.one.system.service.OneFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/web/file")
public class FileController {
	
	@Autowired
	private OneFileService oneFileService;
	
	@RequestMapping("/uploadImg")
	@ResponseBody
	public RespEntity<OneFile> uploadImg(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		RespEntity<OneFile> resp = new RespEntity<>();
		OneFile oneFile = oneFileService.uploadImage(file);
		if(oneFile.getId()!=null) {
			resp.setData(oneFile);
			resp.setHttpCode(HttpCode.Success);
			resp.setMessage("上传成功");
		}else {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("上传失败");
		}
		return resp;
	}
	
	@RequestMapping("/uploadFile")
	@ResponseBody
	public RespEntity<OneFile> uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		RespEntity<OneFile> resp = new RespEntity<>();
		OneFile oneFile = oneFileService.uploadFile(file);
		if(oneFile.getId()!=null) {
			resp.setData(oneFile);
			resp.setHttpCode(HttpCode.Success);
			resp.setMessage("上传成功");
		}else {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("上传失败");
		}
		return resp;
	}
	
	@RequestMapping("/getByContext")
	@ResponseBody
	public RespEntity<List<OneFile>> getByContext(HttpServletRequest request, @RequestParam("context") String context) {
		RespEntity<List<OneFile>> resp = new RespEntity<>();
		try {
			List<OneFile> fileTemps = oneFileService.getFileTempByContext(context);
	        resp.setHttpCode(HttpCode.Success);
			resp.setMessage("查询成功");
			resp.setData(fileTemps);
		} catch (Exception e) {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("查询失败");
		}
		return resp;
	}
	
	@RequestMapping("/bigUpload")
	@ResponseBody
	public RespEntity<String> bigUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file
			, @RequestParam("context") String context, @RequestParam("chunk") String chunk) {
		RespEntity<String> resp = new RespEntity<>();
		try {
			byte[] bytes = file.getBytes();
	        String newname = context + "_" + chunk + ".blob";
	        String path = OneFile.getFilePath()+ newname;
	        Path newpath = Paths.get(path);
	        Files.write(newpath, bytes);
	        OneFile oneFile = new OneFile();
	        oneFile.setChunk(chunk);
	        oneFile.setContext(context);
	        oneFileService.insertFileTemp(oneFile);
	        resp.setHttpCode(HttpCode.Success);
			resp.setMessage("上传成功");
			resp.setData(context + "_" + chunk);
		} catch (IOException e) {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("上传失败");
		}
		return resp;
	}
	
	@RequestMapping("/bigMkfile")
	@ResponseBody
	public RespEntity<OneFile> bigMkfile(HttpServletRequest request, @RequestParam("context") String context, 
			@RequestParam("chunks") String chunks, @RequestParam("filename") String filename) {
		RespEntity<OneFile> resp = new RespEntity<>();
		try {
			String contextPath = OneFile.getFilePath() + context + "/";
			int num = Integer.parseInt(chunks);
			List<String> list = new ArrayList<String>();
			for(int i=0; i<num; i++) {
				String name = context + "_" + (i+1) + ".blob";
				list.add(contextPath + name);
			}
			String[] fpaths = new String[list.size()];
			list.toArray(fpaths);
			mergeFiles(fpaths, contextPath + filename);
	        resp.setHttpCode(HttpCode.Success);
			resp.setMessage("合并成功");
		} catch (Exception e) {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("合并失败");
		}
		return resp;
	}
	
	
	@RequestMapping("/recordUpload")
	@ResponseBody
	public RespEntity<String> recordUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file
			, @RequestParam("context") String context, @RequestParam("chunk") String chunk) {
		RespEntity<String> resp = new RespEntity<>();
		try {
			String contextPath = OneFile.getFilePath() + context + "/";
			if(Integer.parseInt(chunk) == 1) {
				OneFile.checkFolder(contextPath);
			}
			byte[] bytes = file.getBytes();
	        String newname = context + "_" + chunk + ".blob";
	        String path = contextPath + newname;
	        Path newpath = Paths.get(path);
	        Files.write(newpath, bytes);
	        resp.setHttpCode(HttpCode.Success);
			resp.setMessage("上传成功");
			resp.setData(context + "_" + chunk);
		} catch (IOException e) {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("上传失败");
		}
		return resp;
	}
	
	
	public boolean mergeFiles(String[] fpaths, String resultPath) {
	    if (fpaths == null || fpaths.length < 1 || StringUtils.isEmpty(resultPath)) {
	        return false;
	    }
	    if (fpaths.length == 1) {
	        return new File(fpaths[0]).renameTo(new File(resultPath));
	    }
	 
	    File[] files = new File[fpaths.length];
	    for (int i = 0; i < fpaths.length; i ++) {
	        files[i] = new File(fpaths[i]);
	        if (StringUtils.isEmpty(fpaths[i]) || !files[i].exists() || !files[i].isFile()) {
	            return false;
	        }
	    }
	 
	    File resultFile = new File(resultPath);
	 
	    try {
	        FileChannel resultFileChannel = new FileOutputStream(resultFile, true).getChannel();
	        for (int i = 0; i < fpaths.length; i ++) {
	            FileChannel blk = new FileInputStream(files[i]).getChannel();
	            resultFileChannel.transferFrom(blk, resultFileChannel.size(), blk.size());
	            blk.close();
	        }
	        resultFileChannel.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	 
	    for (int i = 0; i < fpaths.length; i ++) {
	        files[i].delete();
	    }
	 
	    return true;
	}

}
