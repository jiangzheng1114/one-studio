package org.one.energy.entity;

import java.util.Date;

import org.one.common.base.BaseEntity;

public class Irtu extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -181211648484871031L;

	private String ikey;

    private Integer ino;

    private String icode;

    private String idesc;

    private Integer iaddr;

    private Integer istate;

    private Date iupdatetime;

    public String getIkey() {
        return ikey;
    }

    public void setIkey(String ikey) {
        this.ikey = ikey == null ? null : ikey.trim();
    }

    public Integer getIno() {
        return ino;
    }

    public void setIno(Integer ino) {
        this.ino = ino;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode == null ? null : icode.trim();
    }

    public String getIdesc() {
        return idesc;
    }

    public void setIdesc(String idesc) {
        this.idesc = idesc == null ? null : idesc.trim();
    }

    public Integer getIaddr() {
        return iaddr;
    }

    public void setIaddr(Integer iaddr) {
        this.iaddr = iaddr;
    }

    public Integer getIstate() {
        return istate;
    }

    public void setIstate(Integer istate) {
        this.istate = istate;
    }

    public Date getIupdatetime() {
        return iupdatetime;
    }

    public void setIupdatetime(Date iupdatetime) {
        this.iupdatetime = iupdatetime;
    }
}