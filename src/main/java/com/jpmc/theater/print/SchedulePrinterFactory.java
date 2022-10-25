package com.jpmc.theater.print;

public class SchedulePrinterFactory {
	public static SchedulePrinter getSchedulePrinter(PrintType printType) {
		if(printType.equals(PrintType.JSON)) 
			return new SchedulePrinterJSON();
		else
			return new SchedulePrinterText();
		
	}
}
