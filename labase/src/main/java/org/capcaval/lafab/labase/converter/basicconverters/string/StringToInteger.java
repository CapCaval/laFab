package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;


public class StringToInteger extends ConverterAbstract<String, Integer> {
	@Override
	public Integer convert(String inobj) {
		return Integer.decode(inobj);
	}
}
