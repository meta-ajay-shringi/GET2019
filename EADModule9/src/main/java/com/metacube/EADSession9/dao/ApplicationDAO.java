package com.metacube.EADSession9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.metacube.EADSession9.mapper.EmployeeInfoMapper;
import com.metacube.EADSession9.mapper.EmployeeMapper;
import com.metacube.EADSession9.mapper.FriendsExtractor;
import com.metacube.EADSession9.mapper.ProfileMapper;
import com.metacube.EADSession9.model.EmployeeCommands;
import com.metacube.EADSession9.model.EmployeeInfo;
import com.metacube.EADSession9.model.ProfileCommands;

/**
 * DAO layer
 *
 */
@Repository
public class ApplicationDAO {

private JdbcTemplate jdbcTemplate;
	
private final String SQL_FIND_Employee = "select * from employeedetails where email = ?";
private final String SQL_FIND_PROFILE = "CALL getProfileByEmail(?) ";
private final String SQL_GET_FRIENDS = "CALL FRIENDS(?)";
private final String SQL_INSERT_USER = "INSERT INTO employeedetails(name, gender,email,password, phoneNumber, organization) values(?,?,?,?,?,?)";
private final String SQL_FIND_INFO = "call InfoLatest(?,?)";
private final String SQL_INSERT_VEHICLE = "INSERT INTO vehicledetails(empId, name, vehicleNumber, identification, type) values(?,?,?,?,?)";
private final String SQL_INSERT_PLAN = "INSERT INTO plan_details(empId, vehicleNumber, plan, price) values(?,?,?,?)";
private final String SQL_UPLOAD_IMAGE = "INSERT INTO images(email,name) values(?,?)";
private final String SQL_UPDATE_IMAGE = "UPDATE images SET name = ? WHERE email=? ";
private final String SQL_UPDATE_EMPLOYEE = "UPDATE employeeDetails SET name = ? , gender= ? , password= ?, phoneNumber= ?, organization= ? WHERE email = ?";

	@Autowired
	public ApplicationDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addEmployee(EmployeeCommands emp) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER); 
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getGender());
                ps.setString(3, emp.getEmail());
                ps.setString(4, emp.getPassword());
                ps.setString(5, emp.getPhoneNumber());
                ps.setString(6, emp.getOrganization());
                return ps;
            }
        });
		
		return (row > 0);
	}


	public boolean update(EmployeeCommands empObj) {		
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
            	PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_EMPLOYEE);
                ps.setString(1, empObj.getName());
                ps.setString(2, empObj.getGender());
                ps.setString(3, empObj.getPassword());
                ps.setString(4, empObj.getPhoneNumber());
                ps.setString(5, empObj.getOrganization());
                ps.setString(6, empObj.getEmail());
                return ps;
            }
        });      
		
		return (row > 0);
	}

	public List<String> getFriends(String email) {
		return jdbcTemplate.query(SQL_GET_FRIENDS, new Object[]{email}, new FriendsExtractor());
	}

	public boolean addVehicle(int empId, String name, String type,
			String vehicleNumber, String identification) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_VEHICLE); 
                System.out.println(empId+name+type+vehicleNumber+identification);
                ps.setInt(1,empId);
                ps.setString(2,name);
                ps.setString(5,type);
                ps.setString(3,vehicleNumber);
                ps.setString(4,identification);
                return ps;
            }
        });
		
		return (row > 0);
	}

	public boolean addPlan(int empId, String vehicleNumber, String plan,
			double price) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PLAN); 
                ps.setInt(1,empId);
                ps.setString(3,plan);
                ps.setString(2,vehicleNumber);
                ps.setDouble(4,price);
                return ps;
            }
        });
		
		return (row > 0);
	}

	public EmployeeCommands getEmployee(String email) {
		try{
		return jdbcTemplate.queryForObject(SQL_FIND_Employee, new Object[] {email}, new EmployeeMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}	
	}
	
	public ProfileCommands getProfile(String email) {
		return jdbcTemplate.queryForObject(SQL_FIND_PROFILE, new Object[]{email} , new ProfileMapper());
	}

	public EmployeeInfo getEmpoyeeInfo(String email, String password) {
		try{	
		     
			return jdbcTemplate.queryForObject(SQL_FIND_INFO, new Object[]{email,password}, new EmployeeInfoMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}	
		
	}

	public boolean uploadPhoto(String email,String imgName) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_UPLOAD_IMAGE); 
                ps.setString(1,email);
                ps.setString(2,imgName);
                return ps;
            }
        });
		
		return (row > 0);
	}

	public boolean updateUploadPhoto(String email, String imgName) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_IMAGE); 
                ps.setString(1, imgName);
                ps.setString(2, email);
                return ps;
            }
        });  
		return (row > 0);
	}

	
}
