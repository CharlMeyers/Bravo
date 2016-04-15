package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publications database table.
 * 
 */
@Entity
@Table(name="publications")
@NamedQuery(name="Publication.findAll", query="SELECT p FROM Publication p")
public class Publication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int publicationID;

	//bi-directional many-to-one association to Publicationauthor
	@OneToMany(mappedBy="publication")
	private List<Publicationauthor> publicationauthors;

	//bi-directional many-to-one association to Publicationdetail
	@ManyToOne
	@JoinColumn(name="PublicationDetailsID", nullable=false)
	private Publicationdetail publicationdetail;

	//bi-directional many-to-one association to Publicationstate
	@ManyToOne
	@JoinColumn(name="PublicationStateID", nullable=false)
	private Publicationstate publicationstate;

	//bi-directional many-to-one association to Publicationtarget
	@ManyToOne
	@JoinColumn(name="PublicationTargetID", nullable=false)
	private Publicationtarget publicationtarget;

	//bi-directional many-to-one association to Publicationtype
	@ManyToOne
	@JoinColumn(name="PublicationTypeID", nullable=false)
	private Publicationtype publicationtype;

	public Publication() {
	}

	public int getPublicationID() {
		return this.publicationID;
	}

	public void setPublicationID(int publicationID) {
		this.publicationID = publicationID;
	}

	public List<Publicationauthor> getPublicationauthors() {
		return this.publicationauthors;
	}

	public void setPublicationauthors(List<Publicationauthor> publicationauthors) {
		this.publicationauthors = publicationauthors;
	}

	public Publicationauthor addPublicationauthor(Publicationauthor publicationauthor) {
		getPublicationauthors().add(publicationauthor);
		publicationauthor.setPublication(this);

		return publicationauthor;
	}

	public Publicationauthor removePublicationauthor(Publicationauthor publicationauthor) {
		getPublicationauthors().remove(publicationauthor);
		publicationauthor.setPublication(null);

		return publicationauthor;
	}

	public Publicationdetail getPublicationdetail() {
		return this.publicationdetail;
	}

	public void setPublicationdetail(Publicationdetail publicationdetail) {
		this.publicationdetail = publicationdetail;
	}

	public Publicationstate getPublicationstate() {
		return this.publicationstate;
	}

	public void setPublicationstate(Publicationstate publicationstate) {
		this.publicationstate = publicationstate;
	}

	public Publicationtarget getPublicationtarget() {
		return this.publicationtarget;
	}

	public void setPublicationtarget(Publicationtarget publicationtarget) {
		this.publicationtarget = publicationtarget;
	}

	public Publicationtype getPublicationtype() {
		return this.publicationtype;
	}

	public void setPublicationtype(Publicationtype publicationtype) {
		this.publicationtype = publicationtype;
	}

}