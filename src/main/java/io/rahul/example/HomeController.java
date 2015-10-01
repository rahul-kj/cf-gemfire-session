package io.rahul.example;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("session")
public class HomeController implements Serializable {

	private static final long serialVersionUID = -322532956311093586L;

	private static final Logger logger = LoggerFactory
	        .getLogger(HomeController.class);

	@Autowired
	CounterService counterService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
		        DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("sessionMessage", counterService.getCounter(date));

		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Locale locale, Model model) {
		return "hello";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/env", method = RequestMethod.GET, produces = "application/json")
	public String getEnv(HttpServletRequest request, Model model) {
		Map<String, Object> vcap_details = new LinkedHashMap<String, Object>();
		vcap_details.put("VCAP_SERVICES", System.getenv("VCAP_SERVICES"));
		vcap_details.put("VCAP_APPLICATION", System.getenv("VCAP_APPLICATION"));
		vcap_details.put("VCAP_APP_HOST", System.getenv("VCAP_APP_HOST"));
		vcap_details.put("VCAP_APP_PORT", System.getenv("VCAP_APP_PORT"));
		vcap_details.put("USER", System.getenv("USER"));
		vcap_details.put("HOME", System.getenv("HOME"));
		vcap_details.put("MEMORY_LIMIT", System.getenv("MEMORY_LIMIT"));
		vcap_details.put("PORT", System.getenv("PORT"));
		vcap_details.put("PWD", System.getenv("PWD"));
		vcap_details.put("TMPDIR", System.getenv("TMPDIR"));
		vcap_details.put("CF_INSTANCE_ADDR", System.getenv("CF_INSTANCE_ADDR"));
		vcap_details.put("CF_INSTANCE_INDEX", System.getenv("CF_INSTANCE_INDEX"));
		vcap_details.put("CF_INSTANCE_IP", System.getenv("CF_INSTANCE_IP"));
		vcap_details.put("CF_INSTANCE_PORT", System.getenv("CF_INSTANCE_PORT"));
		vcap_details.put("CF_INSTANCE_PORTS", System.getenv("CF_INSTANCE_PORTS"));
		
		
		Map<String, Object> remote_details = new LinkedHashMap<String, Object>();
		remote_details.put("REMOTE ADDRESS: ", request.getRemoteAddr());
		remote_details.put("REMOTE HOST: ", request.getRemoteHost());
		remote_details.put("REMOTE PORT: ", request.getRemotePort());
		remote_details.put("REMOTE USER: ", request.getRemoteUser());

		Map<String, Object> server_details = new LinkedHashMap<String, Object>();
		server_details.put("SERVER NAME: ", request.getServerName());
		server_details.put("SERVER PORT: ", request.getServerPort());

		
		Map<String, Object> header_details = new LinkedHashMap<String, Object>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			header_details.put(headerName, request.getHeader(headerName));
		}

		Map<String, Object> attr_details = new LinkedHashMap<String, Object>();
		Enumeration<String> attributeNames = request.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			attr_details.put(attributeName,
			        request.getAttribute(attributeName));
		}
		
		model.addAttribute("LINK", "hello");
		
		model.addAttribute("vcap_details", vcap_details);
		model.addAttribute("remote_details", remote_details);
		model.addAttribute("server_details", server_details);
		model.addAttribute("header_details", header_details);
		model.addAttribute("attr_details", attr_details);

		return "env";
	}

}
