package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class StringToString extends ConverterAbstract<String, String> {
	@Override
	public String convert(String inobj) {
		if(inobj==null){
			inobj="";
		}
		
		return inobj;
	}

}
