package org.ccb.property.rest.controller;

import org.ccb.patrimony.model.DocumentType;
import org.ccb.patrimony.service.DocumentTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/document-type")
public class DocumentTypeController extends DefaultController<DocumentType, DocumentTypeService>{

}
