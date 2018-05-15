package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-05-13 09:49:11
 */
public class KkOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String symbol;
	//
	private String orderId;
	//
	private Double price;
	//
	private String orderType;
	//
	private String backContent;
	//
	private Double allVolum;
	//
	private Double tradedVolum;
	//
	private String status;
	//
	private Double amount;
	//
	private Date openDate;
	//
	private Date closeDate;
	//
	private Integer profitDataId;
	//
	private Date insertTime;
	//
	private Date updateTime;
	//
	private Double unTradeVolum;
	//
	private Integer dcaCount;
	//
	private String strategy;
	//
	private String mark1;
	//
	private String mark2;
	//
	private String mark3;
	//
	private String mark4;

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
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * 设置：
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * 设置：
	 */
	public void setBackContent(String backContent) {
		this.backContent = backContent;
	}
	/**
	 * 获取：
	 */
	public String getBackContent() {
		return backContent;
	}
	/**
	 * 设置：
	 */
	public void setAllVolum(Double allVolum) {
		this.allVolum = allVolum;
	}
	/**
	 * 获取：
	 */
	public Double getAllVolum() {
		return allVolum;
	}
	/**
	 * 设置：
	 */
	public void setTradedVolum(Double tradedVolum) {
		this.tradedVolum = tradedVolum;
	}
	/**
	 * 获取：
	 */
	public Double getTradedVolum() {
		return tradedVolum;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 设置：
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	/**
	 * 获取：
	 */
	public Date getOpenDate() {
		return openDate;
	}
	/**
	 * 设置：
	 */
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	/**
	 * 获取：
	 */
	public Date getCloseDate() {
		return closeDate;
	}
	/**
	 * 设置：
	 */
	public void setProfitDataId(Integer profitDataId) {
		this.profitDataId = profitDataId;
	}
	/**
	 * 获取：
	 */
	public Integer getProfitDataId() {
		return profitDataId;
	}
	/**
	 * 设置：
	 */
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	/**
	 * 获取：
	 */
	public Date getInsertTime() {
		return insertTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setUnTradeVolum(Double unTradeVolum) {
		this.unTradeVolum = unTradeVolum;
	}
	/**
	 * 获取：
	 */
	public Double getUnTradeVolum() {
		return unTradeVolum;
	}
	/**
	 * 设置：
	 */
	public void setDcaCount(Integer dcaCount) {
		this.dcaCount = dcaCount;
	}
	/**
	 * 获取：
	 */
	public Integer getDcaCount() {
		return dcaCount;
	}
	/**
	 * 设置：
	 */
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	/**
	 * 获取：
	 */
	public String getStrategy() {
		return strategy;
	}
	/**
	 * 设置：
	 */
	public void setMark1(String mark1) {
		this.mark1 = mark1;
	}
	/**
	 * 获取：
	 */
	public String getMark1() {
		return mark1;
	}
	/**
	 * 设置：
	 */
	public void setMark2(String mark2) {
		this.mark2 = mark2;
	}
	/**
	 * 获取：
	 */
	public String getMark2() {
		return mark2;
	}
	/**
	 * 设置：
	 */
	public void setMark3(String mark3) {
		this.mark3 = mark3;
	}
	/**
	 * 获取：
	 */
	public String getMark3() {
		return mark3;
	}
	/**
	 * 设置：
	 */
	public void setMark4(String mark4) {
		this.mark4 = mark4;
	}
	/**
	 * 获取：
	 */
	public String getMark4() {
		return mark4;
	}
}
