package org.ccb.property.rest.controller;

import java.util.Optional;

import org.ccb.core.model.PersistableEntity;
import org.ccb.core.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DefaultController<E extends PersistableEntity, S extends GenericService<E>> {
	
	private final Logger log = LoggerFactory.getLogger(DefaultController.class);
	
	@Autowired
	private S service;
	
	public S getService() {
		return service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody E save(@RequestBody E entity) throws Exception {
		log.info("Create new {} entity: {}", entity.getClass(), entity);
		return service.save(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody E update(@RequestBody E entity) throws Exception {
		log.info("Update {} entity: {}", entity.getClass(), entity);
		return service.update(entity);
	}
	
	@RequestMapping(path = "/{id}",
			method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		log.info("Remove entity by id: {}", id);
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(path = "/{id}",
			method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<E> find(@PathVariable Long id) {
		log.info("Request by id: {}", id);
		E entity = service.findOne(id);
		
		return Optional
					.ofNullable(entity)
					.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
					.orElse(new ResponseEntity<E>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity list(Pageable pagination) {
		Page<E> result = service.list(pagination);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
