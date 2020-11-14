package com.example.artsunitedeventforms.data.enums;

public enum Forms {
	
	AUC_REPORT("Auc Event Report", "Arts United Center Event Report","operations@artsunited"),
	AL_REPORT("Al Event Report", "ArtsLab/Auer Center Event Report","operations@artsunited"),
	AUC_MONITOR("Auc Desk Monitor", "Arts United Center Desk Monitor","operations@artsunited"),
	AL_MONITOR("Al Desk Monitor", "ArtsLab/Auer Center Desk monitor","operations@artsunited"),
	AUC_TECH("Auc Tech", "Arts United Center Tech Report","tech@artsunited.org"),
	AL_TECH("Al Tech", "ArtsLab/Auer Center Tech Report","tech@artsunited.org");
	
	private String fullName;
	private String title;
	private String email;
	
	Forms(String fullName,String title,String email) {
		
		this.fullName = fullName;
		this.title = title;
		this.email = email;
	}
	
	public String getFullName() {
		
		return fullName;
	}
	
	public String getTitle() {
		
		return title;
	}
	
	public String getEmail() {
		
		return email;
	}
}
