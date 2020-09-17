package org.capcaval.lafab.labase.converter;

/**
 * Generic interface to convert from a first type to a second one.
 * @param <I> Input type
 * @param <O> Output type
 */
public interface Converter <I,O>{
	/**
	 * Convert from parameter to return value.
	 * @param inobj input instance to be converted
	 * @return converted instance
	 */
	O convert(I inobj);

	/**
	 * Return the input type.
	 * @return input type
	 */
	Class<I> getInputType();

	/**
	 * Return the output type.
	 * @return output type
	 */
	Class<O> getOutputType();
}
