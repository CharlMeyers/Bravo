package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the notactive database table.
 * 
 */
@Entity
@Table(name="notactive")
@NamedQuery(name="Notactive.findAll", query="SELECT n FROM Notactive n")
public class Notactive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int notActiveID;

	@Column(nullable=false, length=255)
	private String deactivationReason;

	//bi-directional many-to-one association to Activestate
	@OneToMany(mappedBy="notactive")
	private List<Activestate> activestates;

	public Notactive() {
	}

	public int getNotActiveID() {
		return this.notActiveID;
	}

	public void setNotActiveID(int notActiveID) {
		this.notActiveID = notActiveID;
	}

	public String getDeactivationReason() {
		return this.deactivationReason;
	}

	public void setDeactivationReason(String deactivationReason) {
		this.deactivationReason = deactivationReason;
	}

	public List<Activestate> getActivestates() {
		return this.activestates;
	}

	public void setActivestates(List<Activestate> activestates) {
		this.activestates = activestates;
	}

	public Activestate addActivestate(Activestate activestate) {
		getActivestates().add(activestate);
		activestate.setNotactive(this);

		return activestate;
	}

	public Activestate removeActivestate(Activestate activestate) {
		getActivestates().remove(activestate);
		activestate.setNotactive(null);

		return activestate;
	}

}