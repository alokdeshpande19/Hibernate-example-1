package com.javatpoint.mypackage;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class UserDbo {

    @Id
    @GeneratedValue
    private int id;

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	private String phone;
	
	private boolean isAdmin;

	
	@ManyToOne
	private CompanyDbo company;
    
	@OneToOne
	private UserDbo manager;
	
	@OneToMany
	private Set<UserDbo> employees = new HashSet<UserDbo>();


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CompanyDbo getCompany() {
		return company;
	}

	public void setCompany(CompanyDbo company) {
		this.company = company;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserDbo getManager() {
		return manager;
	}

	public void setManager1(UserDbo manager) {
		this.manager = manager;
	}

	public Set<UserDbo> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<UserDbo> employees) {
		this.employees = employees;
	}

/*	public void addEmployee(UserDbo employee) {
		this.employees.add(employee);
	}

	public void deleteEmployee(UserDbo employee) {
		this.employees.remove(employee);
	}*/

	/*public Set<TimeCardDbo> getTimecards() {
		return timecards;
	}

	public void setTimecards(Set<TimeCardDbo> timecards) {
		this.timecards = timecards;
	}

	public void addTimecards(TimeCardDbo timecard) {
		this.timecards.add(timecard);
	}*/

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
