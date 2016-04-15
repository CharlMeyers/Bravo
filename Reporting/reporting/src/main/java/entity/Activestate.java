package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the activestate database table.
 * 
 */
@Entity
@Table(name="activestate")
@NamedQuery(name="Activestate.findAll", query="SELECT a FROM Activestate a")
public class Activestate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int activeStateID;

	//bi-directional many-to-one association to Active
	@ManyToOne
	@JoinColumn(name="ActiveID")
	private Active active;

	//bi-directional many-to-one association to Notactive
	@ManyToOne
	@JoinColumn(name="NotActiveID")
	private Notactive notactive;

	//bi-directional many-to-one association to Publicationtypestate
	@OneToMany(mappedBy="activestate")
	private List<Publicationtypestate> publicationtypestates;

	public Activestate() {
	}

	public int getActiveStateID() {
		return this.activeStateID;
	}

	public void setActiveStateID(int activeStateID) {
		this.activeStateID = activeStateID;
	}

	public Active getActive() {
		return this.active;
	}

	public void setActive(Active active) {
		this.active = active;
	}

	public Notactive getNotactive() {
		return this.notactive;
	}

	public void setNotactive(Notactive notactive) {
		this.notactive = notactive;
	}

	public List<Publicationtypestate> getPublicationtypestates() {
		return this.publicationtypestates;
	}

	public void setPublicationtypestates(List<Publicationtypestate> publicationtypestates) {
		this.publicationtypestates = publicationtypestates;
	}

	public Publicationtypestate addPublicationtypestate(Publicationtypestate publicationtypestate) {
		getPublicationtypestates().add(publicationtypestate);
		publicationtypestate.setActivestate(this);

		return publicationtypestate;
	}

	public Publicationtypestate removePublicationtypestate(Publicationtypestate publicationtypestate) {
		getPublicationtypestates().remove(publicationtypestate);
		publicationtypestate.setActivestate(null);

		return publicationtypestate;
	}

}