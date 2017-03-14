package org.ccb.patrimony.service.impl;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.ccb.core.service.impl.GenericServiceImpl;
import org.ccb.patrimony.model.Document;
import org.ccb.patrimony.repository.DocumentRepository;
import org.ccb.patrimony.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl extends GenericServiceImpl<Document> implements DocumentService {

	@Autowired 
	private DocumentRepository repository;
	
	@Override
	public Document save(Document entity) throws Exception {
		convertBase64ToBlob(entity);
		return super.save(entity);
	}

	@Override
	public Document update(Document entity) throws Exception {
		convertBase64ToBlob(entity);
		return super.update(entity);
	}

	private void convertBase64ToBlob(Document entity) throws SerialException, SQLException {
		byte[] documentBytes = Base64.getDecoder().decode(entity.getDocumentBase64());
		Blob documentBlob = new SerialBlob(documentBytes);
		entity.setDocument(documentBlob);
	}

	@Override
	public List<Document> findByChurchId(Long churchId) {
		List<Document> documents = getRepository().findByChurchId(churchId);
		return documents;
	}
	
	@Override
	public DocumentRepository getRepository() {
		return repository;
	}
}
