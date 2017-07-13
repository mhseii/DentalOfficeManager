package br.com.dentalofficemanager.patient.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.patient.model.Patient;

@Repository
public class JdbcPatientDao {

	private final Connection connection;

	@Autowired
	public JdbcPatientDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// CRUD although due to laws its a COs
	// interest to keep a patient file for
	// at least five years
	public void addPatient(Patient p) {

		String sql = "INSERT INTO Patient (firstName, lastName, birthDate, cpf, phoneNumber, "
				+ "addressStreet, addressNumber, addressDistrict, addressPostalCode) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setDate(3, new Date(p.getDateOfBirth().getTimeInMillis()));
			ps.setString(4, p.getSsnId());
			ps.setString(5, p.getPhoneNumber());
//			ps.setString(6, p.getAddressStreet());
//			ps.setString(7, p.getAddressNumber());
//			ps.setString(8, p.getAddressDistrict());
//			ps.setString(9, p.getAddressPostalCode());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	// simple method to list all patients
	public List<Patient> listPatient() {

		String sql = "select * from patient";
		List<Patient> patients = new ArrayList<Patient>();
		PreparedStatement ps;

		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				patients.add(buildPatient(rs));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return patients;
	}

	
	// this method differs from listPatient
	// it builds a list based on the users input
	// instead of listing all patients
	// this should be used to search and view
	// detailed info 
	public List<Patient> searchPatient(String query) {

		String sql = "select * from patient where patient.firstName like '" + query.toLowerCase() + "%'";
		List<Patient> matchedPatients = new ArrayList<Patient>();
		PreparedStatement ps;
		
		//System.out.println(sql);
		
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				matchedPatients.add(buildPatient(rs));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return matchedPatients;
	}
	
	// query patients id
	public Patient searchPatientId(Long id) {
		String query = "select * from patient where patient.id = ?"; 
		if (id == null) {
			throw new IllegalStateException("ID cannot be null");
		}
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1,id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildPatient(rs);
			}
			rs.close();
			ps.close();
			return null;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	// fills a model with a patients info
	public Patient buildPatient(ResultSet rs) throws SQLException {

		Patient patient = new Patient();

//		patient.setPatientId(rs.getLong("id"));
		patient.setFirstName(rs.getString("firstName"));
		patient.setLastName(rs.getString("lastName"));
		Date birthDate = rs.getDate("birthDate");
		patient.setDateOfBirth(dateToCalendar(birthDate));
		patient.setSsnId(rs.getString("ssn_id"));
		patient.setPhoneNumber(rs.getString("phoneNumber"));
//		patient.setAddressStreet(rs.getString("addressStreet"));
//		patient.setAddressNumber(rs.getString("addressNumber"));
//		patient.setAddressDistrict(rs.getString("addressDistrict"));
//		patient.setAddressPostalCode(rs.getString("addressPostalCode"));

		return patient;
	}

	// converts db date type into calendar type
	private Calendar dateToCalendar(Date date) {
		Calendar endDate = null;
		if (date != null) {
			endDate = Calendar.getInstance();
			endDate.setTime(date);
		}
		return endDate;
	}

}
