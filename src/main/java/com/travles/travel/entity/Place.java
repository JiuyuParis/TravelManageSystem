package com.travles.travel.entity;

public class Place {
	private Integer id;
	private String name;
	private String picpath;
	private String hottime;
	private Double hotticket;
	private Double dimticket;
	private String placedes;
	private String provinceid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getHottime() {
		return hottime;
	}
	public void setHottime(String hottime) {
		this.hottime = hottime;
	}
	public Double getHotticket() {
		return hotticket;
	}
	public void setHotticket(Double hotticket) {
		this.hotticket = hotticket;
	}
	public Double getDimticket() {
		return dimticket;
	}
	public void setDimticket(Double dimticket) {
		this.dimticket = dimticket;
	}
	public String getPlacedes() {
		return placedes;
	}
	public void setPlacedes(String placedes) {
		this.placedes = placedes;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public Place(Integer id, String name, String picpath, String hottime, Double hotticket, Double dimticket,
			String placedes, String provinceid) {
		super();
		this.id = id;
		this.name = name;
		this.picpath = picpath;
		this.hottime = hottime;
		this.hotticket = hotticket;
		this.dimticket = dimticket;
		this.placedes = placedes;
		this.provinceid = provinceid;
	}
	public Place() {
		super();
	}
	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", picpath=" + picpath + ", hottime=" + hottime + ", hotticket="
				+ hotticket + ", dimticket=" + dimticket + ", placedes=" + placedes + ", provinceid=" + provinceid
				+ "]";
	}
	
}
