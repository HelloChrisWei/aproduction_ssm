package com.cskaoyan.controller.Device;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringtoDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Date parse = simpleDateFormat.parse(s);
            return parse;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
