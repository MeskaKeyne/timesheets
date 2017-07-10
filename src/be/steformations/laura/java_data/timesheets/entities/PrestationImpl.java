package be.steformations.laura.java_data.timesheets.entities;

import java.util.Date;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.entities.Project;

public class PrestationImpl implements Prestation {

	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private Date day;
	@javax.persistence.ManyToOne
	@javax.persistence.JoinColumn(name="employee")
	private EmployeeImpl employee;
	@javax.persistence.ManyToOne
	@javax.persistence.JoinColumn(name="project")
	private ProjectImpl project;
	private int duration;
	private String comment;
	
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public Date getDay() {
		return day;
	}
	
	@Override
	public Employee getEmployee() {
		return employee;
	}
	
	@Override
	public Project getProject() {
		return project;
	}
	
	@Override
	public int getDuration() {
		return duration;
	}
	
	@Override
	public String getComment() {
		return comment;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public void setEmployee(EmployeeImpl employee) {
		this.employee = employee;
	}

	public void setProject(ProjectImpl project) {
		this.project = project;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + duration;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
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
		PrestationImpl other = (PrestationImpl) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (duration != other.duration)
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prestation [id=" + id + ", day=" + day + ", employee=" + employee + ", project=" + project
				+ ", duration=" + duration + "]";
	}
}