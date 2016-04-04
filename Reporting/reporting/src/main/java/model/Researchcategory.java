package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the researchcategory database table.
 * 
 */
@Entity
@NamedQuery(name="Researchcategory.findAll", query="SELECT r FROM Researchcategory r")
public class Researchcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int researchCategoryID;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	private String name;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="researchcategory")
	private List<Person> persons;

	public Researchcategory() {
	}

	public int getResearchCategoryID() {
		return this.researchCategoryID;
	}

	public void setResearchCategoryID(int researchCategoryID) {
		this.researchCategoryID = researchCategoryID;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setResearchcategory(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setResearchcategory(null);

		return person;
	}

}