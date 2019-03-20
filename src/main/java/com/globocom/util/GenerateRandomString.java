package com.globocom.util;

public class GenerateRandomString {
	//private static final Logger LOGGER = LoggerFactory.getLogger(GenerateRandomString.class);
	private static final String ALPHA_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		GenerateRandomString grs = new GenerateRandomString();
		//LOGGER.info(grs.getAlphaNumeric(10));
		//LOGGER.info(grs.getAlphaNumeric(20));
	}

	public String getAlphaNumeric(int len) {
		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			int ndx = (int) (Math.random() * ALPHA_NUM.length());
			sb.append(ALPHA_NUM.charAt(ndx));
		}
		return sb.toString();
	}
}
