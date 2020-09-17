package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;


public class StringToDouble extends ConverterAbstract<String, Double> {
	@Override
	public Double convert(String inobj) {
		return Double.parseDouble(inobj);
	}
}
