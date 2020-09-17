package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class DoubleToString extends ConverterAbstract<Double, String> {
	@Override
	public String convert(Double inobj) {
		return Double.toString(inobj);
	}

}
