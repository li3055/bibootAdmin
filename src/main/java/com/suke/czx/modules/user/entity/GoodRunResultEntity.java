package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-02-04 09:11:43
 */
public class GoodRunResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String symbol;
	//
	private String timeStyle;
	//
	private String strategyName;
	//
	private BigDecimal trailingBuy;
	//
	private BigDecimal buyValue;
	//
	private BigDecimal sellValue;
	//
	private BigDecimal trailingProfit;
	//
	private BigDecimal totalProfit;
	//
	private BigDecimal rewardRisk;
	//
	private BigDecimal maximumDrawdown;
	//
	private BigDecimal numberOfTrades;
	//
	private Integer waveTime;
	//
	private Date createTime;
	//
	private BigDecimal averageProfitableTrades;
	//
	private BigDecimal buyAndHold;
	//
	private Date startdate;
	//
	private Date enddate;
	//
	private Integer timeWidthMin;
	//
	private String versionStr;

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
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	/**
	 * 获取：
	 */
	public String getStrategyName() {
		return strategyName;
	}
	/**
	 * 设置：
	 */
	public void setTrailingBuy(BigDecimal trailingBuy) {
		this.trailingBuy = trailingBuy;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getTrailingBuy() {
		return trailingBuy;
	}
	/**
	 * 设置：
	 */
	public void setBuyValue(BigDecimal buyValue) {
		this.buyValue = buyValue;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getBuyValue() {
		return buyValue;
	}
	/**
	 * 设置：
	 */
	public void setSellValue(BigDecimal sellValue) {
		this.sellValue = sellValue;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getSellValue() {
		return sellValue;
	}
	/**
	 * 设置：
	 */
	public void setTrailingProfit(BigDecimal trailingProfit) {
		this.trailingProfit = trailingProfit;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getTrailingProfit() {
		return trailingProfit;
	}
	/**
	 * 设置：
	 */
	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getTotalProfit() {
		return totalProfit;
	}
	/**
	 * 设置：
	 */
	public void setRewardRisk(BigDecimal rewardRisk) {
		this.rewardRisk = rewardRisk;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getRewardRisk() {
		return rewardRisk;
	}
	/**
	 * 设置：
	 */
	public void setMaximumDrawdown(BigDecimal maximumDrawdown) {
		this.maximumDrawdown = maximumDrawdown;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getMaximumDrawdown() {
		return maximumDrawdown;
	}
	/**
	 * 设置：
	 */
	public void setNumberOfTrades(BigDecimal numberOfTrades) {
		this.numberOfTrades = numberOfTrades;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getNumberOfTrades() {
		return numberOfTrades;
	}
	/**
	 * 设置：
	 */
	public void setWaveTime(Integer waveTime) {
		this.waveTime = waveTime;
	}
	/**
	 * 获取：
	 */
	public Integer getWaveTime() {
		return waveTime;
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
	 * 设置：
	 */
	public void setAverageProfitableTrades(BigDecimal averageProfitableTrades) {
		this.averageProfitableTrades = averageProfitableTrades;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getAverageProfitableTrades() {
		return averageProfitableTrades;
	}
	/**
	 * 设置：
	 */
	public void setBuyAndHold(BigDecimal buyAndHold) {
		this.buyAndHold = buyAndHold;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getBuyAndHold() {
		return buyAndHold;
	}
	/**
	 * 设置：
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	/**
	 * 获取：
	 */
	public Date getStartdate() {
		return startdate;
	}
	/**
	 * 设置：
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	/**
	 * 获取：
	 */
	public Date getEnddate() {
		return enddate;
	}
	/**
	 * 设置：
	 */
	public void setTimeWidthMin(Integer timeWidthMin) {
		this.timeWidthMin = timeWidthMin;
	}
	/**
	 * 获取：
	 */
	public Integer getTimeWidthMin() {
		return timeWidthMin;
	}
	/**
	 * 设置：
	 */
	public void setVersionStr(String versionStr) {
		this.versionStr = versionStr;
	}
	/**
	 * 获取：
	 */
	public String getVersionStr() {
		return versionStr;
	}
}
