package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publicationtarget database table.
 * 
 */
@Entity
@Table(name="publicationtarget")
@NamedQuery(name="Publicationtarget.findAll", query="SELECT p FROM Publicationtarget p")
public class Publicationtarget implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int publicationTargetID;

	@Column(nullable=false, length=255)
	private String name;

	@Column(nullable=false, length=255)
	private String website;

	//bi-directional many-to-one association to Publication
	@OneToMany(mappedBy="publicationtarget")
	private List<Publication> publications;

	public Publicationtarget() {
	}

	public int getPublicationTargetID() {
		return this.publicationTargetID;
	}

	public void setPublicationTargetID(int publicationTargetID) {
		this.publicationTargetID = publicationTargetID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Publication addPublication(Publication publication) {
		getPublications().add(publication);
		publication.setPublicationtarget(this);

		return publication;
	}

	public Publication removePublication(Publication publication) {
		getPublications().remove(publication);
		publication.setPublicationtarget(null);

		return publication;
	}

}