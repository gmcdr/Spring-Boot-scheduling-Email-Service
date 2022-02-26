package com.agendamento.tranca.enums;

public enum BraidType {
	
	TWIST("Twist"),
	NAGO("Nagô"),
	BOXBRAIDS("Box Braids"),
	STITCHBRAIDS("Stitich Braids"),
	ENTRELACE("Entrelace"),
	FULANIBRAIDS("Fulani Braids"),
	BOXEADORA("Boxeadora");
	
    private final String displayValue;
    
    private BraidType(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
