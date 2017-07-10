package be.steformations.laura.java_data.timesheets.entities;

import be.steformations.java_data.timesheets.entities.Employee;

@javax.persistence.Table

public class EmployeeImpl implements Employee {

	private Long id;
	private String firstname;
	private String name;
	private String login;
	private String password;
	private java.util.List<ProjectImpl> managedProjects;
	private java.util.List<PrestationImpl> prestations;
	
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getFirstname() {
		return firstname;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getLogin() {
		return login;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public java.util.List<ProjectImpl> getManagedProjects() {
		if (managedProjects == null) {
			managedProjects = new java.util.ArrayList<ProjectImpl>();
		}
		return managedProjects;
	}
	
	@Override
	public java.util.List<PrestationImpl> getPrestations() {
		if(prestations == null) {
			prestations = new java.util.ArrayList<PrestationImpl>();
		}
		return prestations;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeImpl other = (EmployeeImpl) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", name=" + name + ", login=" + login + ", password="
				+ password + "]";
	}
}
