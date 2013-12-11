package com.javatpoint.mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Index;

@Entity
@NamedQueries({
	@NamedQuery(name = "findAllField", query = "select u from UserDbo as u"),
	@NamedQuery(name = "findByEmailId", query = "select u from UserDbo as u where u.email=:email") })
public class UserDbo {

	@Id
	@SequenceGenerator(name="user_id_gen",sequenceName="user_sequence" ,initialValue=1)
	@GeneratedValue(generator="user_id_gen")
	private Integer id;

	@Index(name="entityIndexCol")
	@Column(unique = true)
	private String email;

	private String phone;
	private String password;
	private String name;
	private String firstName;
	private String lastName;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false)
	private CompanyDbo company;

	@ManyToOne
	private UserDbo manager;
	
	@OneToMany(mappedBy = "manager")
	private List<UserDbo> employees = new ArrayList<UserDbo>();

	private boolean isNewPasswordChange;

	public boolean isNewPasswordChange() {
		return isNewPasswordChange;
	}

	public void setNewPasswordChange(boolean isNewPasswordChange) {
		this.isNewPasswordChange = isNewPasswordChange;
	}

	public Integer getId() {
		return id;
	}

	public List<UserDbo> getEmployees() {
		return employees;
	}

	public void setEmployees(List<UserDbo> employees) {
		this.employees = employees;
	}

	public void addEmployee(UserDbo employee) {
		this.employees.add(employee);
	}

	public void deleteEmployee(UserDbo employee) {
		this.employees.remove(employee);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompanyDbo getCompany() {
		return company;
	}

	public void setCompany(CompanyDbo company) {
		this.company = company;
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

	public void setManager(UserDbo manager) {
		this.manager = manager;
	}

	public static List<UserDbo> findAllField(EntityManager mgr) {
		Query query = mgr.createNamedQuery("findAll");
		return query.getResultList();
	}

	public static UserDbo findByEmailId(EntityManager mgr, String email) {
		Query query = mgr.createNamedQuery("findByEmailId");
		query.setParameter("email", email);
		try {
			return (UserDbo) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
