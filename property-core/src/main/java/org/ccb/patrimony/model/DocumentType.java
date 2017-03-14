package org.ccb.patrimony.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.ccb.core.model.PersistableEntity;

@Entity
@Table(name = "ptm_document_type")
@AttributeOverride(name = "id", column = @Column(name = "id_document_type"))
public class DocumentType extends PersistableEntity{

	private String name;

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
