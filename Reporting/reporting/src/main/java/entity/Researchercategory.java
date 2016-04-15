package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the researchercategory database table.
 * 
 */
@Entity
@Table(name="researchercategory")
@NamedQuery(name="Researchercategory.findAll", query="SELECT r FROM Researchercategory r")
public class Researchercategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int researchCategoryID;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date effectiveDate;

	@Column(nullable=false, length=50)
	private String name;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="researchercategory")
	private List<Person> persons;

	public Researchercategory() {
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
		person.setResearchercategory(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setResearchercategory(null);

		return person;
	}

}