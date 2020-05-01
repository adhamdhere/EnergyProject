package com.rtnr.data;

public class ClimateData {
	
	private MonthlyValues temperature;
	private MonthlyValues precipitation;
	private MonthlyValues sunshine;
	private MonthlyValues pressure;

	public MonthlyValues getTemperature() {
		return temperature;
	}
	public void setTemperature(MonthlyValues temperature) {
		this.temperature = temperature;
	}
	public MonthlyValues getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(MonthlyValues precipitation) {
		this.precipitation = precipitation;
	}
	public MonthlyValues getSunshine() {
		return sunshine;
	}
	public void setSunshine(MonthlyValues sunshine) {
		this.sunshine = sunshine;
	}
	public MonthlyValues getPressure() {
		return pressure;
	}
	public void setPressure(MonthlyValues pressure) {
		this.pressure = pressure;
	}

}
