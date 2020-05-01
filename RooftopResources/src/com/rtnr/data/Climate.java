package com.rtnr.data;

public class Climate {
	
	private Meta meta;
	private ClimateData data;

	public ClimateData getData() {
		return data;
	}

	public void setData(ClimateData data) {
		this.data = data;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	public class Meta{
		private String source;

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}
		
		
	}
	

}
