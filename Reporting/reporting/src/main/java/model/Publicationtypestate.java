package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the publicationtypestate database table.
 * 
 */
@Entity
@Table(name="publicationtypestate")
@NamedQuery(name="Publicationtypestate.findAll", query="SELECT p FROM Publicationtypestate p")
public class Publicationtypestate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int publicationTypeStateID;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateEffective;

	//bi-directional many-to-one association to Publicationtype
	@OneToMany(mappedBy="publicationtypestate")
	private List<Publicationtype> publicationtypes;

	//bi-directional many-to-one association to Activestate
	@ManyToOne
	@JoinColumn(name="ActiveStateID", nullable=false)
	private Activestate activestate;

	public Publicationtypestate() {
	}

	public int getPublicationTypeStateID() {
		return this.publicationTypeStateID;
	}

	public void setPublicationTypeStateID(int publicationTypeStateID) {
		this.publicationTypeStateID = publicationTypeStateID;
	}

	public Date getDateEffective() {
		return this.dateEffective;
	}

	public void setDateEffective(Date dateEffective) {
		this.dateEffective = dateEffective;
	}

	public List<Publicationtype> getPublicationtypes() {
		return this.publicationtypes;
	}

	public void setPublicationtypes(List<Publicationtype> publicationtypes) {
		this.publicationtypes = publicationtypes;
	}

	public Publicationtype addPublicationtype(Publicationtype publicationtype) {
		getPublicationtypes().add(publicationtype);
		publicationtype.setPublicationtypestate(this);

		return publicationtype;
	}

	public Publicationtype removePublicationtype(Publicationtype publicationtype) {
		getPublicationtypes().remove(publicationtype);
		publicationtype.setPublicationtypestate(null);

		return publicationtype;
	}

	public Activestate getActivestate() {
		return this.activestate;
	}

	public void setActivestate(Activestate activestate) {
		this.activestate = activestate;
	}

}