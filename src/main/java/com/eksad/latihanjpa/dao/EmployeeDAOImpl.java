package com.eksad.latihanjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.eksad.latihanjpa.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@PersistenceContext
	EntityManager entitymanager; //fungsi entity, menjembatanin antar db dan program yg dibuat
	
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("select e from Employee e", Employee.class).getResultList();
		//select e from employee e artinya, memanggil e dalam employee buat dimasukkan di nama alias e 
	}

	@Override
	public Employee getById(int id) {
		return entitymanager.find(Employee.class, id);
	}
	
	@Transactional
	@Override
	public void save(Employee employee) {
		entitymanager.persist(employee);

		
	}

	@Transactional // : ini buat ada ketika app kita melakukan transaksi(saving/delete) ke dalam db
	@Override
	public void update(Employee employee) {
		entitymanager.merge(employee);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		Employee employee = getById(id);
		entitymanager.remove(employee);
		
	}
	
	
	@Override
	public List<Employee> getByName(String name) {
		return entitymanager.createQuery("SELECT e FROM Employee e WHERE e.name LIKE  ?0", Employee.class) //fungsi ?0 untuk masukin parameter ke 0
		.setParameter(0,"%"+ name + "%")
		.getResultList(); //why select e from nama table e, ini jpql, dimana kita memanggil suatu objek dari kelas kita (meng-query database)
	
		//createnativequery : buat manggil dari database
		//createquery : buat manggil langsung dari class karena sudah di generate dari orm (object relation manager)
	}

	
	
	
	

}
