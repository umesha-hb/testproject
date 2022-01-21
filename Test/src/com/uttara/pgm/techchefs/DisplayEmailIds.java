package com.uttara.pgm.techchefs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayEmailIds {

	@GetMapping("/restService/{urlParameter}" )
	public Map<String,String> restService(@PathVariable("urlParameter") String urlParameter){
	     
	     
	    Map<String,String> response = new HashMap<>();
	     System.out.println("---------here---");     
	    response.put("urlParameter",urlParameter);
	     
	     
	    return response;
	     
	}
}
