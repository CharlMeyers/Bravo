package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the active database table.
 * 
 */
@Entity
@Table(name="active")
@NamedQuery(name="Active.findAll", query="SELECT a FROM Active a")
public class Active implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int activeID;

	@Column(nullable=false)
	private int accreditationPoints;

	//bi-directional many-to-one association to Activestate
	@OneToMany(mappedBy="active")
	private List<Activestate> activestates;

	public Active() {
	}

	public int getActiveID() {
		return this.activeID;
	}

	public void setActiveID(int activeID) {
		this.activeID = activeID;
	}

	public int getAccreditationPoints() {
		return this.accreditationPoints;
	}

	public void setAccreditationPoints(int accreditationPoints) {
		this.accreditationPoints = accreditationPoints;
	}

	public List<Activestate> getActivestates() {
		return this.activestates;
	}

	public void setActivestates(List<Activestate> activestates) {
		this.activestates = activestates;
	}

	public Activestate addActivestate(Activestate activestate) {
		getActivestates().add(activestate);
		activestate.setActive(this);

		return activestate;
	}

	public Activestate removeActivestate(Activestate activestate) {
		getActivestates().remove(activestate);
		activestate.setActive(null);

		return activestate;
	}

}