package com.agendamento.tranca.enums;

public enum BraidSize {
	
	CHANNEL("Channel"),
	BUSTO("Busto"),
	CINTURA("Cintura"),
	QUADRIL("Quadril"),
	OUTROS("Outros");
	
    private final String displayValue;
    
    private BraidSize(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
