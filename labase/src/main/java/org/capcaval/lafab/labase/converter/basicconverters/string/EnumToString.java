package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class EnumToString extends ConverterAbstract<Enum<?>, String> {
	@Override
	public String convert(Enum inobj) {
		Class<?> c = inobj.getDeclaringClass();
		
		return c.getSimpleName()+"."+inobj.toString();
	}

}
