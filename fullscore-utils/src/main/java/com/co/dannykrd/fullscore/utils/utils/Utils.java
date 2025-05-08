package com.co.dannykrd.fullscore.utils.utils;

import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

import org.springframework.http.RequestEntity;

public class Utils {

	public static String downloadSvgAsBase64(String svgUrl) {
        try (InputStream in = new URL(svgUrl).openStream()) {
            byte[] svgBytes = in.readAllBytes();
            String base64 = Base64.getEncoder().encodeToString(svgBytes);
            return "data:image/svg+xml;base64," + base64;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static Locale getLocale(RequestEntity<?> request) {
		List<Locale> locales = request.getHeaders().getAcceptLanguageAsLocales();
        return locales.isEmpty() ? Locale.getDefault() : locales.get(0);
	}
	
	public static String maskEmail(String email) {
		String[] emailParts = email.split("@");
	    String emailPoint = emailParts[0];
	                    
	    String asterisk = "";
	    for(int x = 0; x< emailPoint.length()-4;x++){
	    	asterisk += "*";
	    }
	    return emailPoint.substring(0, 2).concat(asterisk).concat( emailPoint.substring(emailPoint.length()-2)).concat("@").concat(emailParts[1]);
	}
}
