package com.fx.market.dto;

public class PhotoDto {
	
	private String photos_id;
	private String name;
	private String path;
	private String created_at;
	
	public PhotoDto() {
	}
	
	public PhotoDto(String photos_id, String name, String path, String created_at) {
		this.photos_id = photos_id;
		this.name = name;
		this.path = path;
		this.created_at = created_at;
	}
	
	public String getPhotos_id() {
		return photos_id;
	}
	public void setPhotos_id(String photos_id) {
		this.photos_id = photos_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
	
}
