package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class StringToFloat extends ConverterAbstract<String, Float> {
	@Override
	public Float convert(String inobj) {
		return Float.parseFloat(inobj);
	}

}
