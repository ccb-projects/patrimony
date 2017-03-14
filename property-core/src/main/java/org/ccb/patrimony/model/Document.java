package org.ccb.patrimony.model;

import java.sql.Blob;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.ccb.core.model.Church;
import org.ccb.core.model.PersistableEntity;

@Entity
@Table(name = "ptm_document")
@AttributeOverride(name = "id", column = @Column(name = "id_document"))
public class Document extends PersistableEntity{

	@ManyToOne
	@JoinColumn(name = "church_id")
	private Church church;

	@ManyToOne
	@JoinColumn(name = "document_type")
	private DocumentType documentType;
	
	@Column(name = "document")
	private Blob document;
	
	@Transient
	private String documentBase64;
	
	public Church getChurch() {
		return church;
	}
	public void setChurch(Church church) {
		this.church = church;
	}
	
	public DocumentType getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	
	public Blob getDocument() {
		return document;
	}
	public void setDocument(Blob document) {
		this.document = document;
	}
	public String getDocumentBase64() {
		return documentBase64;
	}
	public void setDocumentBase64(String documentBase64) {
		this.documentBase64 = documentBase64;
	}
	
}
