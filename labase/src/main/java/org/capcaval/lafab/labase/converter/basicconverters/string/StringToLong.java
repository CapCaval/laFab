package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class StringToLong extends ConverterAbstract<String, Long> {
	@Override
	public Long convert(String inobj) {
		return Long.parseLong(inobj);
	}

}
