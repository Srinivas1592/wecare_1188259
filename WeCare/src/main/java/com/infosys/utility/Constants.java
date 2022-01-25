package com.infosys.utility;

public enum Constants {
	//Exception message constants
  USER_NOT_FOUND("user.not.found"),
  COACH_NOT_FOUND("coach.not.found");
	
	private String type;

	Constants(String string) {
		WeCareConstants(string);
	}

	private void WeCareConstants(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}


