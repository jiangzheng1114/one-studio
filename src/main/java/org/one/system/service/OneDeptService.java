package org.one.system.service;

import java.util.List;

import org.one.common.base.LayPage;
import org.one.system.entity.OneDept;

public interface OneDeptService {
	
	LayPage<OneDept> findDeptsByPage(OneDept oneDept);
	
	List<OneDept> getAllDepts();
	
	Long addDept(OneDept oneDept);
	
}
