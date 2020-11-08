package com.example.artsunitedeventforms.data.enums;

public enum Forms {
	
	AUC_REPORT("Auc Event Report", "Arts United Center Event Report"),
	AL_REPORT("Al Event Report", "Arts United Center Event Report"),
	AUC_MONITOR("Auc Desk Monitor", "Arts United Center Event Report"),
	AL_MONITOR("Al Desk Monitor", "Arts United Center Event Report"),
	AUC_TECH("Auc Tech", "Arts United Center Event Report"),
	AL_TECH("Al Tech", "Arts United Center Event Report");
	
	private String fullName;
	private String title;
	
	Forms(String fullName,String title) {
		
		this.fullName = fullName;
		this.title = title;
	}
	
	public String getFullName() {
		
		return fullName;
	}
	
	public String getTitle() {
		
		return title;
	}
}
