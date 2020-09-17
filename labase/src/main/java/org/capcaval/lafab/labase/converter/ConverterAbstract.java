package org.capcaval.lafab.labase.converter;

import org.capcaval.lafab.labase.lang.ReflectionTools;

import java.lang.reflect.Method;

public abstract class ConverterAbstract<I, O> implements Converter<I, O> {

	@Override
	public Class<I> getInputType() {
		Method method = ReflectionTools.getMethodFromGenericInheritance("convert", this.getClass());
		// ReflectionTools.
		Class<?> type = method.getParameterTypes()[0];

		return (Class<I>)type;
	}

	@Override
	public Class<O> getOutputType() {
		Method method = ReflectionTools.getMethodFromGenericInheritance("convert", this.getClass());
		// ReflectionTools.
		Class<?> type = method.getReturnType();

		return (Class<O>)type;
	}
}
