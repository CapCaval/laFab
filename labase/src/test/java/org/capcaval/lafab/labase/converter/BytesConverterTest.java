package org.capcaval.lafab.labase.converter;

import junit.framework.Assert;
import org.capcaval.lafab.labase.converter.basicconverters.bytes.ByteArrayToDouble;
import org.capcaval.lafab.labase.converter.basicconverters.bytes.DoubleToByteArray;

public class BytesConverterTest {

    @org.junit.Test
    public void doubleConverterTest() {
        ByteArrayToDouble byteArrayToDouble = new ByteArrayToDouble();
        DoubleToByteArray doubleToByteArray = new DoubleToByteArray();

        double value = 12.5;

        System.out.println(Double.toHexString(value));

        byte[] byteArray = doubleToByteArray.convert(value);
        double finalValue = byteArrayToDouble.convert(byteArray);

        Assert.assertEquals(value, finalValue);
    }

}
