package org.capcaval.lafab.labase.converter.basicconverters.string;

import org.capcaval.lafab.labase.converter.ConverterAbstract;

public class LongToString extends ConverterAbstract<Long, String> {
    @Override
    public String convert(Long inobj) {
        return Long.toString(inobj);
    }

}
