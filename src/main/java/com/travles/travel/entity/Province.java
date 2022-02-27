package com.travles.travel.entity;

public class Province {
	private Integer id;
	private String name;
	private String tags;
	private Integer placecounts;
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
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getPlacecounts() {
		return placecounts;
	}
	public void setPlacecounts(Integer placecounts) {
		this.placecounts = placecounts;
	}
	public Province(Integer id, String name, String tags, Integer placecounts) {
		super();
		this.id = id;
		this.name = name;
		this.tags = tags;
		this.placecounts = placecounts;
	}
	public Province() {
		super();
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + ", tags=" + tags + ", placecounts=" + placecounts + "]";
	}
	
}
