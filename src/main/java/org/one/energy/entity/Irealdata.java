package org.one.energy.entity;

import java.util.Date;

import org.one.common.base.BaseEntity;

public class Irealdata extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5607971296120998789L;

	private String ikey;

    private String icode;

    private String idesc;

    private String icls;

    private Integer ino;

    private String ivalue;

    private Integer irtuno;

    private String irtuname;

    private String irtudesc;

    private Integer irtutype;

    private Date iupdatetime;

    public String getIkey() {
        return ikey;
    }

    public void setIkey(String ikey) {
        this.ikey = ikey == null ? null : ikey.trim();
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

    public String getIcls() {
        return icls;
    }

    public void setIcls(String icls) {
        this.icls = icls == null ? null : icls.trim();
    }

    public Integer getIno() {
        return ino;
    }

    public void setIno(Integer ino) {
        this.ino = ino;
    }

    public String getIvalue() {
        return ivalue;
    }

    public void setIvalue(String ivalue) {
        this.ivalue = ivalue == null ? null : ivalue.trim();
    }

    public Integer getIrtuno() {
        return irtuno;
    }

    public void setIrtuno(Integer irtuno) {
        this.irtuno = irtuno;
    }

    public String getIrtuname() {
        return irtuname;
    }

    public void setIrtuname(String irtuname) {
        this.irtuname = irtuname == null ? null : irtuname.trim();
    }

    public String getIrtudesc() {
        return irtudesc;
    }

    public void setIrtudesc(String irtudesc) {
        this.irtudesc = irtudesc == null ? null : irtudesc.trim();
    }

    public Integer getIrtutype() {
        return irtutype;
    }

    public void setIrtutype(Integer irtutype) {
        this.irtutype = irtutype;
    }

    public Date getIupdatetime() {
        return iupdatetime;
    }

    public void setIupdatetime(Date iupdatetime) {
        this.iupdatetime = iupdatetime;
    }
}