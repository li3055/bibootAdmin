package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-02-05 16:01:38
 */
public class RunResultEntity implements Serializable {
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
	private Date startdate;
	//
	private Date enddate;
	//
	private Date createTime;
	//
	private Integer dataCount;
	//
	private BigDecimal totalProfit;
	//
	private BigDecimal rewardRisk;
	//
	private BigDecimal maximumDrawdown;
	//
	private BigDecimal numberOfTicks;
	//
	private BigDecimal avgProfit;
	//
	private BigDecimal numberOfTrades;
	//
	private BigDecimal averageProfitableTrades;
	//
	private BigDecimal transactionCost;
	//
	private BigDecimal buyAndHold;
	//
	private BigDecimal strategyVsHold;
	//
	private Long startTime;
	//
	private Date endTime;

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
	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}
	/**
	 * 获取：
	 */
	public Integer getDataCount() {
		return dataCount;
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
	public void setNumberOfTicks(BigDecimal numberOfTicks) {
		this.numberOfTicks = numberOfTicks;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getNumberOfTicks() {
		return numberOfTicks;
	}
	/**
	 * 设置：
	 */
	public void setAvgProfit(BigDecimal avgProfit) {
		this.avgProfit = avgProfit;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getAvgProfit() {
		return avgProfit;
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
	public void setTransactionCost(BigDecimal transactionCost) {
		this.transactionCost = transactionCost;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getTransactionCost() {
		return transactionCost;
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
	public void setStrategyVsHold(BigDecimal strategyVsHold) {
		this.strategyVsHold = strategyVsHold;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getStrategyVsHold() {
		return strategyVsHold;
	}
	/**
	 * 设置：
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：
	 */
	public Long getStartTime() {
		return startTime;
	}
	/**
	 * 设置：
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：
	 */
	public Date getEndTime() {
		return endTime;
	}
}
