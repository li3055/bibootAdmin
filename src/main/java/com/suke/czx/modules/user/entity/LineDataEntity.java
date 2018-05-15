package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-05-13 09:51:55
 */
public class LineDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String symbol;
	//
	private String timeStyle;
	//
	private BigDecimal shortValue;
	//
	private BigDecimal longValue;
	//
	private Date openTimeDate;
	//
	private Date startDateFrom;
	//
	private Long openTime;
	//
	private Long closeTime;
	//
	private String lineStyle;
	//
	private Integer shortNumber;
	//
	private Integer longNumber;
	//
	private Date createTime;
	//short/long -1
	private BigDecimal spread;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * 获取：
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * 设置：
	 */
	public void setTimeStyle(String timeStyle) {
		this.timeStyle = timeStyle;
	}
	/**
	 * 获取：
	 */
	public String getTimeStyle() {
		return timeStyle;
	}
	/**
	 * 设置：
	 */
	public void setShortValue(BigDecimal shortValue) {
		this.shortValue = shortValue;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getShortValue() {
		return shortValue;
	}
	/**
	 * 设置：
	 */
	public void setLongValue(BigDecimal longValue) {
		this.longValue = longValue;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getLongValue() {
		return longValue;
	}
	/**
	 * 设置：
	 */
	public void setOpenTimeDate(Date openTimeDate) {
		this.openTimeDate = openTimeDate;
	}
	/**
	 * 获取：
	 */
	public Date getOpenTimeDate() {
		return openTimeDate;
	}
	/**
	 * 设置：
	 */
	public void setStartDateFrom(Date startDateFrom) {
		this.startDateFrom = startDateFrom;
	}
	/**
	 * 获取：
	 */
	public Date getStartDateFrom() {
		return startDateFrom;
	}
	/**
	 * 设置：
	 */
	public void setOpenTime(Long openTime) {
		this.openTime = openTime;
	}
	/**
	 * 获取：
	 */
	public Long getOpenTime() {
		return openTime;
	}
	/**
	 * 设置：
	 */
	public void setCloseTime(Long closeTime) {
		this.closeTime = closeTime;
	}
	/**
	 * 获取：
	 */
	public Long getCloseTime() {
		return closeTime;
	}
	/**
	 * 设置：
	 */
	public void setLineStyle(String lineStyle) {
		this.lineStyle = lineStyle;
	}
	/**
	 * 获取：
	 */
	public String getLineStyle() {
		return lineStyle;
	}
	/**
	 * 设置：
	 */
	public void setShortNumber(Integer shortNumber) {
		this.shortNumber = shortNumber;
	}
	/**
	 * 获取：
	 */
	public Integer getShortNumber() {
		return shortNumber;
	}
	/**
	 * 设置：
	 */
	public void setLongNumber(Integer longNumber) {
		this.longNumber = longNumber;
	}
	/**
	 * 获取：
	 */
	public Integer getLongNumber() {
		return longNumber;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：short/long -1
	 */
	public void setSpread(BigDecimal spread) {
		this.spread = spread;
	}
	/**
	 * 获取：short/long -1
	 */
	public BigDecimal getSpread() {
		return spread;
	}
}
