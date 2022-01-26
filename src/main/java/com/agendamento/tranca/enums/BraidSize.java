package com.agendamento.tranca.enums;

public enum BraidSize {
	
	CHANNEL("CHANNEL"),
	BUSTO("BUSTO"),
	CINTURA("CINTUR"),
	QUADRIL("QUADRI"),
	OUTROS("OUTROS");
	
	private String braidSize;

	private BraidSize(String braidSize) {
		this.braidSize = braidSize;
	}
	
}
