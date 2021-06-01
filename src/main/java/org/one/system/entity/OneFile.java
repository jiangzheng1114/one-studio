package org.one.system.entity;

import java.io.File;
import java.util.Date;

import org.one.common.base.BaseEntity;
import org.one.common.base.code.ConfigCode;
import org.one.common.util.SpringUtil;

public class OneFile extends BaseEntity{
	
	private static final long serialVersionUID = -9022509659472939351L;
	
	private Long id;

    private String oldname;

    private String newname;

    private String type;

    private Long size;

    private String path;
    
    private String httppath;
    
    private String smallhttppath;

    private Date createtime;
    
    private String chunk;
    
    private String context;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname == null ? null : oldname.trim();
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname == null ? null : newname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    public String getHttppath() {
		return httppath;
	}

	public void setHttppath(String httppath) {
		this.httppath = httppath;
	}

	public String getSmallhttppath() {
		return smallhttppath;
	}

	public void setSmallhttppath(String smallhttppath) {
		this.smallhttppath = smallhttppath;
	}
	
	public String getChunk() {
		return chunk;
	}

	public void setChunk(String chunk) {
		this.chunk = chunk;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public static final String getImgPath() {
    	ConfigCode code = SpringUtil.getBean(ConfigCode.class);
    	String imgPath = code.getFilePath() + "/imgs/";
    	checkFolder(imgPath);
		return imgPath;
    }
    
    public static final String getFilePath() {
    	ConfigCode code = SpringUtil.getBean(ConfigCode.class);
    	String filePath = code.getFilePath() + "/files/";
    	checkFolder(filePath);
		return filePath;
    }
    
    public static final String getImgHttpPath() {
    	ConfigCode code = SpringUtil.getBean(ConfigCode.class);
    	String imgPath = code.getFileHttpPath() + "/imgs/";
		return imgPath;
    }
    
    public static final String getHttpFilePath() {
    	ConfigCode code = SpringUtil.getBean(ConfigCode.class);
    	String filePath = code.getFileHttpPath() + "/files/";
		return filePath;
    }
    
	public static final void checkFolder(String floder) {
		File file = new File(floder);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
    
}