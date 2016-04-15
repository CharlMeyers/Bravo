package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@Table(name="organization")
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int organizationID;

	@Column(nullable=false, length=50)
	private String names;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="organization")
	private List<Person> persons;

	public Organization() {
	}

	public int getOrganizationID() {
		return this.organizationID;
	}

	public void setOrganizationID(int organizationID) {
		this.organizationID = organizationID;
	}

	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setOrganization(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setOrganization(null);

		return person;
	}

}