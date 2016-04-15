package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publicationtype database table.
 * 
 */
@Entity
@Table(name="publicationtype")
@NamedQuery(name="Publicationtype.findAll", query="SELECT p FROM Publicationtype p")
public class Publicationtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int publicationTypeID;

	@Column(nullable=false, length=50)
	private String name;

	//bi-directional many-to-one association to Publication
	@OneToMany(mappedBy="publicationtype")
	private List<Publication> publications;

	//bi-directional many-to-one association to Publicationtypestate
	@ManyToOne
	@JoinColumn(name="PublicationTypeStateID", nullable=false)
	private Publicationtypestate publicationtypestate;

	public Publicationtype() {
	}

	public int getPublicationTypeID() {
		return this.publicationTypeID;
	}

	public void setPublicationTypeID(int publicationTypeID) {
		this.publicationTypeID = publicationTypeID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Publication addPublication(Publication publication) {
		getPublications().add(publication);
		publication.setPublicationtype(this);

		return publication;
	}

	public Publication removePublication(Publication publication) {
		getPublications().remove(publication);
		publication.setPublicationtype(null);

		return publication;
	}

	public Publicationtypestate getPublicationtypestate() {
		return this.publicationtypestate;
	}

	public void setPublicationtypestate(Publicationtypestate publicationtypestate) {
		this.publicationtypestate = publicationtypestate;
	}

}