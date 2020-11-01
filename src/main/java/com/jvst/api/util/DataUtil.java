package com.jvst.api.util;

import java.sql.Timestamp;

public class DataUtil {

	public static Timestamp dataStringParaTS(String dataString) {
		String[] dataSeparada = dataString.split("/");
		String dataFormatada = dataSeparada[2] + "-" + dataSeparada[1] + "-" +  dataSeparada[0];
		return Timestamp.valueOf(dataFormatada);
	}
	
}
