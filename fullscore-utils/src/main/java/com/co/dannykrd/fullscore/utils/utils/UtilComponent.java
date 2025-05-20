package com.co.dannykrd.fullscore.utils.utils;

import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

import com.co.dannykrd.fullscore.utils.objects.PageRq;
import com.co.dannykrd.fullscore.utils.objects.TypeOrder;

@Component
public class UtilComponent {

	public String downloadSvgAsBase64(String svgUrl) {
        try (InputStream in = new URL(svgUrl).openStream()) {
            byte[] svgBytes = in.readAllBytes();
            String base64 = Base64.getEncoder().encodeToString(svgBytes);
            return "data:image/svg+xml;base64," + base64;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public Locale getLocale(RequestEntity<?> request) {
		List<Locale> locales = request.getHeaders().getAcceptLanguageAsLocales();
        return locales.isEmpty() ? Locale.getDefault() : locales.get(0);
	}
	
	public String maskEmail(String email) {
		String[] emailParts = email.split("@");
	    String emailPoint = emailParts[0];
	                    
	    String asterisk = "";
	    for(int x = 0; x< emailPoint.length()-4;x++){
	    	asterisk += "*";
	    }
	    return emailPoint.substring(0, 2).concat(asterisk).concat( emailPoint.substring(emailPoint.length()-2)).concat("@").concat(emailParts[1]);
	}
	
	public Pageable buildPageable(PageRq pageRequest) {
		Sort sort= Sort.by(TypeOrder.ASC.equals(pageRequest.getTypeOrder()) ? Sort.Direction.ASC : Sort.Direction.DESC, pageRequest.getColumnOrder());
		Pageable pageable = PageRequest.of(pageRequest.getNumber(), pageRequest.getSize(), sort);
		return pageable;
	}
}
