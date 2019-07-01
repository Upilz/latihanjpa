package com.eksad.latihanjpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eksad.latihanjpa.dao.EmployeeDAO;
import com.eksad.latihanjpa.model.Employee;

@Configuration
public class Action {

	@Autowired
	EmployeeDAO employeeDAO;

	@Bean // method
	public List<Employee> getAll() {
		List<Employee> employees = employeeDAO.getAll();
		for (Employee employee : employees) {
		/*	System.out.println("ID: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Address: " + employee.getAddress());
			System.out.println("DOB: " + employee.getDob());

			System.out.println("=================================================================");
		*/
		}
		return employees;
	}

	@Bean
	public Employee getById() {
		Employee employee = employeeDAO.getById(8);
	
		/*System.out.println("Get By ID" + " " + "ID: " + employee.getId());
		System.out.println("Name: " + employee.getName());
		System.out.println("Address: " + employee.getAddress());
		System.out.println("DOB: " + employee.getDob());

		System.out.println("=================================================================");*/
		return employee;
	}

	/*@Bean
	public boolean save() {
		try {
			Employee employee = new Employee();

			employee.setName("Ben");
			employee.setAddress("UK");
			
			String dateString = "2000-11-01";
			Date date = new SimpleDateFormat ("yyyy-MM-dd").parse(dateString);
			
			employee.setDob(date);

			employeeDAO.save(employee);
			System.out.println("Data Berhasil Tersimpan");
			return true;
		} catch (Exception e) {
			System.out.println("Gagal Menyimpan Data");
			e.printStackTrace();
			return false;
		}
	}*/
	
	/*@Bean
	public boolean update () {
		try {
			Employee employee = new Employee();
			
			employee.setId(16);
			employee.setName("Zara");
			employee.setAddress("Michigan");
			
			String dateString = "2000-11-01";
			Date date = new SimpleDateFormat ("yyyy-MM-dd").parse(dateString);
			
			employee.setDob(date);

			employeeDAO.update(employee);
			System.out.println("Data Berhasil Tersimpan");
			return true;
		} catch (Exception e) {
			System.out.println("Gagal Menyimpan Data");
			e.printStackTrace();
			return false;
		}
	}*/
	
	/*@Bean
	public boolean delete () {
		try {
			employeeDAO.delete(20);
			System.out.println("Data Berhasil Dihapus");
			return true;
		} catch (Exception e) {
			System.out.println("Data Gagal Dihapus");
			e.printStackTrace();
			return false;
		}
	}*/
	
	@Bean
	public List<Employee> getByName(){
/*dibuat variabel employees untuk run getbyname*/	
		List <Employee> employees = employeeDAO.getByName("Bass");
		for (Employee employee : employees) {
				System.out.println("ID: " + employee.getId());
				System.out.println("Name: " + employee.getName());
				System.out.println("Address: " + employee.getAddress());
				System.out.println("DOB: " + employee.getDob());

				System.out.println("=================================================================");
			
			}
			return employees;
	}
}
