package org.one.system.service;

import java.util.List;

import org.one.system.entity.OneFile;
import org.springframework.web.multipart.MultipartFile;

public interface OneFileService {
	
	Long insertFile(OneFile file);
	
	OneFile getById(Long id);
	
	OneFile uploadFile(MultipartFile file);
	
	OneFile uploadImage(MultipartFile file);
	
    int insertFileTemp(OneFile record);
    
    List<OneFile> getFileTempByContext(String context);

}
