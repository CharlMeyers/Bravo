package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the researchgroup database table.
 * 
 */
@Entity
@Table(name="researchgroup")
@NamedQuery(name="Researchgroup.findAll", query="SELECT r FROM Researchgroup r")
public class Researchgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int researchGroupID;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date endDate;

	@Column(nullable=false, length=50)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date startDate;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="researchgroup")
	private List<Person> persons;

	public Researchgroup() {
	}

	public int getResearchGroupID() {
		return this.researchGroupID;
	}

	public void setResearchGroupID(int researchGroupID) {
		this.researchGroupID = researchGroupID;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setResearchgroup(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setResearchgroup(null);

		return person;
	}

}