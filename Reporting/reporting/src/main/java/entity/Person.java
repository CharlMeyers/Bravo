package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name="person")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int personID;

	@Column(nullable=false, length=50)
	private String emails;

	@Column(nullable=false, length=30)
	private String firstNames;

	@Column(nullable=false, length=50)
	private String surname;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="OrganizationID", nullable=false)
	private Organization organization;

	//bi-directional many-to-one association to Researchercategory
	@ManyToOne
	@JoinColumn(name="ResearchCategoryID", nullable=false)
	private Researchercategory researchercategory;

	//bi-directional many-to-one association to Researchgroup
	@ManyToOne
	@JoinColumn(name="ResearchGroupID", nullable=false)
	private Researchgroup researchgroup;

	//bi-directional many-to-one association to Publicationauthor
	@OneToMany(mappedBy="person")
	private List<Publicationauthor> publicationauthors;

	public Person() {
	}

	public int getPersonID() {
		return this.personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getEmails() {
		return this.emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getFirstNames() {
		return this.firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Researchercategory getResearchercategory() {
		return this.researchercategory;
	}

	public void setResearchercategory(Researchercategory researchercategory) {
		this.researchercategory = researchercategory;
	}

	public Researchgroup getResearchgroup() {
		return this.researchgroup;
	}

	public void setResearchgroup(Researchgroup researchgroup) {
		this.researchgroup = researchgroup;
	}

	public List<Publicationauthor> getPublicationauthors() {
		return this.publicationauthors;
	}

	public void setPublicationauthors(List<Publicationauthor> publicationauthors) {
		this.publicationauthors = publicationauthors;
	}

	public Publicationauthor addPublicationauthor(Publicationauthor publicationauthor) {
		getPublicationauthors().add(publicationauthor);
		publicationauthor.setPerson(this);

		return publicationauthor;
	}

	public Publicationauthor removePublicationauthor(Publicationauthor publicationauthor) {
		getPublicationauthors().remove(publicationauthor);
		publicationauthor.setPerson(null);

		return publicationauthor;
	}

}