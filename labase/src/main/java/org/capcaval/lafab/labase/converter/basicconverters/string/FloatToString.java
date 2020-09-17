package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class FloatToString extends ConverterAbstract<Float, String> {
	@Override
	public String convert(Float inobj) {
		return Float.toString(inobj);
	}

}
