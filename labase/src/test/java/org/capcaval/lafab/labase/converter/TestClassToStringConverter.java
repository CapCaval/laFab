package org.capcaval.lafab.labase.converter;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class TestClassToStringConverter extends ConverterAbstract<TestClass, String> {

	@Override
	public String convert(TestClass inobj) {
		String str = Integer.toString(inobj.intValue);
		str = str + ";" + Integer.toString(inobj.color.getRGB());
		return str;
	}

}
