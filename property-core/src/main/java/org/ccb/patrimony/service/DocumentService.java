package org.ccb.patrimony.service;

import java.util.List;

import org.ccb.core.service.GenericService;
import org.ccb.patrimony.model.Document;

public interface DocumentService extends GenericService<Document> {

	List<Document> findByChurchId(Long churchId);
}
