package org.ccb.property.rest.controller;

import java.util.List;
import java.util.Optional;

import org.ccb.patrimony.model.Document;
import org.ccb.patrimony.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/document")
public class DocumentController extends DefaultController<Document, DocumentService> {

	
	@RequestMapping(path = "/find-church/{id}",
			method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Document>> findByChurch(@PathVariable Long id) {
		List<Document> documents = getService().findByChurchId(id);
		
		return Optional
					.ofNullable(documents)
					.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
					.orElse(new ResponseEntity<List<Document>>(HttpStatus.NOT_FOUND));
	}
	
}
