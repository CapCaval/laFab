package org.capcaval.lafab.labase.converter.basicconverters.bytes;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class ByteArrayToDouble extends ConverterAbstract<byte[], Double> {

	@Override
	public Double convert(byte[] byteArray) {
    	long longValue = 0;
    	
    	for( int i = 0; i < 8; i++){
    		// calculate the bit shift and the mask
    		int bitShift = 64 -((i+1)*8);
    		long mask = (long)0xff << bitShift;
    		
    		System.out.println(Long.toHexString(mask));
    		
    		// shift and apply mask
    		longValue = longValue | ((long)(byteArray[i]) << bitShift) & mask;
    	}
		
		return Double.longBitsToDouble(longValue);
	}

}
