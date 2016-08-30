package cn.ssm.test.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomDataConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return s.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return null;
	}


}
