package com.fis.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {

	private Long id;
	
	private String from;
	
	private String to;
	
	private BigDecimal conversionMultiple;
	
	private BigDecimal quantity;
	
	private BigDecimal totalQuantity;
	
	private int port;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the conversionMultiple
	 */
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	/**
	 * @param conversionMultiple the conversionMultiple to set
	 */
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the totalQuantity
	 */
	public BigDecimal getTotalQuantity() {
		return totalQuantity;
	}

	/**
	 * @param totalQuantity the totalQuantity to set
	 */
	public void setTotalQuantity(BigDecimal totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	protected CurrencyConversion() {
	}

	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalQuantity, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalQuantity = totalQuantity;
		this.port = port;
	}
}