package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;


public class IntegerToString extends ConverterAbstract<Integer, String> {
	@Override
	public String convert(Integer inobj) {
		return Integer.toString(inobj);
	}
}
