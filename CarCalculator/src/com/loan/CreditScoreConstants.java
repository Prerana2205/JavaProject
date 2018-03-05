package com.loan;

public enum CreditScoreConstants {

	SUPERPRIME("Super prime","781-850");
	
	
	private String key;
	private String value;
	private CreditScoreConstants(final String key, final String value){
		this.key= key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
