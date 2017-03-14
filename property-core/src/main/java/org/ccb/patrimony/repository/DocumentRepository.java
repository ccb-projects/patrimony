package org.ccb.patrimony.repository;

import java.util.List;

import org.ccb.core.repository.PersistableRepository;
import org.ccb.patrimony.model.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends PersistableRepository<Document> {
	
	@Query("select d.church, d.documentType from Document d where d.church.id = ?1")
	List<Document> findByChurchId(Long churchId);

}
