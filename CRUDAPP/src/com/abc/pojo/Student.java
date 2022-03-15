package com.abc.pojo;

public class Student {
	private Integer sid;
	private String sname;
	private Integer sage;
	private String saddress;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	

	@Override
	public int hashCode() {
		return this.sid;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		
		if(this == obj)
			return true;
		
		Student student=(Student)obj;
		if (this.sid==student.sid)
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		return "[sid= " + sid + ", sname= " + sname + ", sage= " + sage + ", saddress= " + saddress + "]";
	}
}
