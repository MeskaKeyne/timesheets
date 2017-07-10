package be.steformations.laura.java_data.timesheets.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.entities.Project;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.laura.java_data.timesheets.entities.EmployeeImpl;
import be.steformations.laura.java_data.timesheets.entities.PrestationImpl;
import be.steformations.laura.java_data.timesheets.entities.ProjectImpl;

public class TimesheetsDataServiceJpa implements TimesheetsDataService {

	private EntityManager em;
	
	public TimesheetsDataServiceJpa() {
		super();
		this.em = Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
	}

	
	@Override
	public List<? extends Employee> findAllEmployees() {
		TypedQuery<EmployeeImpl> query = em.createNamedQuery("findAllEmployees", EmployeeImpl.class);
		return query.getResultList();
	}

	@Override
	public Employee findOneEmployeeById(long id) {
		return em.find(EmployeeImpl.class, id);
	}

	@Override
	public Employee findOneEmployeeByFirstnameAndName(String firstname, String name) {
		EmployeeImpl employee = null;
		TypedQuery<EmployeeImpl> query = em.createNamedQuery("findOneEmployeeByFirstnameAndName", EmployeeImpl.class);
		query.setParameter(1, firstname);
		query.setParameter(2, name);
		try {
			employee = query.getSingleResult();
		} catch(javax.persistence.NoResultException e){
		}
		return employee;
	}

	@Override
	public Employee findOneEmployeeByLoginAndPassword(String login, String password) {
		EmployeeImpl employee = null;
		TypedQuery<EmployeeImpl> query = em.createNamedQuery("findOneEmployeeByLoginAndPassword", EmployeeImpl.class);
		query.setParameter(1, login);
		query.setParameter(2, password);
		try {
			employee = query.getSingleResult();
		} catch(javax.persistence.NoResultException e){
		}
		return employee;
	}

	@Override
	public List<? extends Project> findAllProjects() {
		TypedQuery<ProjectImpl> query = em.createNamedQuery("findAllProjects", ProjectImpl.class);
		return query.getResultList();
	}

	@Override
	public Project findOneProjectById(long id) {
		return em.find(ProjectImpl.class, id);
	}

	@Override
	public Project findOneProjectByName(String name) {
		ProjectImpl project = null;
		TypedQuery<ProjectImpl> query = em.createNamedQuery("findOneProjectByName", ProjectImpl.class);
		query.setParameter(1, name);
		try {
			project = query.getSingleResult();
		} catch(javax.persistence.NoResultException e){
		}
		return project;
	}

	@Override
	public Prestation findOnePrestationById(long id) {
		return em.find(PrestationImpl.class, id);
	}

	@Override
	public List<? extends Prestation> findAllPrestationsByEmployeeId(long id) {
		TypedQuery<PrestationImpl> query = em.createNamedQuery("findAllPrestationsByEmployeeId", PrestationImpl.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

	@Override
	public List<? extends Prestation> findAllPrestationsByProjectId(long id) {
		TypedQuery<PrestationImpl> query = em.createNamedQuery("findAllPrestationsByProjectId", PrestationImpl.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

	@Override
	public Prestation addPrestation(long employeeId, long projectId, String comment, Date day, int duration) {
		PrestationImpl prestation = null;
		
		if (day != null && duration >= 0 && this.findOneEmployeeById(employeeId) != null && this.findOneProjectById(projectId) != null){
			prestation = new PrestationImpl();
			prestation.setEmployee((EmployeeImpl)this.findOneEmployeeById(employeeId));
			prestation.setProject((ProjectImpl)this.findOneProjectById(projectId));
			prestation.setComment(comment);
			prestation.setDay(day);
			prestation.setDuration(duration);
			
			this.em.getTransaction().begin();
			this.em.persist(prestation);
			this.em.getTransaction().commit();	
			}
		return prestation;
	}

	@Override
	public Prestation deletePrestation(long id) {
		PrestationImpl p = (PrestationImpl)this.findOnePrestationById(id);
		if (p != null){
			this.em.getTransaction().begin();
			this.em.remove(p);
			this.em.getTransaction().commit();
		}
		return p;
	}


}
