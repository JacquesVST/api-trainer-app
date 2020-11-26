package com.jvst.api.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DataUtil {

	public static Timestamp dataStringParaTS(String dataString) {
		String[] dataSeparada = dataString.split("/");
		String dataFormatada = dataSeparada[2] + "-" + dataSeparada[1] + "-" + dataSeparada[0] + " 00:00:00";
		return Timestamp.valueOf(dataFormatada);
	}

	public static String dataTSParaString(Timestamp dataTS) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(dataTS);
	}

}
