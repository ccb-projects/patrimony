package org.ccb.property.rest.controller;

import org.ccb.core.model.City;
import org.ccb.core.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController extends DefaultController<City, CityService> {

	
}
