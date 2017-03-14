package org.ccb.property.rest.controller;

import org.ccb.core.model.Church;
import org.ccb.core.service.ChurchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/church")
public class ChurchController extends DefaultController<Church, ChurchService> {

}
