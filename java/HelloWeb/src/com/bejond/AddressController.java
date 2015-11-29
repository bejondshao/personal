package com.bejond;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bejond on 15-11-27.
 */
public class AddressController {

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public ModelAndView address() {
		return new ModelAndView("address", "command", new Address());
	}

	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public String addAddress(@ModelAttribute ("SpringWeb")Address address,
		ModelMap model) {
		model.addAttribute("code", address.getCode());
		model.addAttribute("street", address.getStreet());
		model.addAttribute("streetNumber", address.getStreetNumber());

		return "result";
	}
}
