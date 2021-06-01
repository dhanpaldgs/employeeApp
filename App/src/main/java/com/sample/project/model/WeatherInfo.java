package com.sample.project.model;

import java.util.List;

public class WeatherInfo {
	private String code;
	private Long calctime;
	private Long cnt;
	List<CityInfo> list;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getCalctime() {
		return calctime;
	}
	public void setCalctime(Long calctime) {
		this.calctime = calctime;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	public List<CityInfo> getList() {
		return list;
	}
	public void setList(List<CityInfo> list) {
		this.list = list;
	}
	
	
	
}
