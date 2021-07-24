package com.ptit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.Entity.User;
import com.ptit.getConnection.GetConnection;

@Repository
@Transactional
public class UserDao {
	
	
	@Value("${secretKey}")
	String secretKey;

	
	GetConnection getConnection = new GetConnection(); 
	Connection conn = getConnection.getConnection(); 
	
	public boolean signIn(String username, String password) {

		String sql0 = "select * from applicationdomain.users where username = ?";
		PreparedStatement pstt0;
		try {
			pstt0 = conn.prepareStatement(sql0);
			pstt0.setString(1, username);
			ResultSet rs = pstt0.executeQuery();
			if(rs.next()) {
//				if(AES.decrypt(rs.getString(3), secretKey).equals(password)) {
			if(rs.getString(3).equals(password)) {
					return true; 
				}
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false; 
	}
	
	public boolean signUp(String username, String password) {
		boolean checkExist = false; 
	
		String sql0 = "select * from applicationdomain.users where username = ?";
		PreparedStatement pstt0;
		try {
			pstt0 = conn.prepareStatement(sql0);
			pstt0.setString(1, username);
			ResultSet rs = pstt0.executeQuery();
			if(rs.next()) {
				return true;  
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(checkExist==false) {
//			String passwordEncrypt = AES.encrypt(password, secretKey);
//			String passwordEncrypt =BCrypt.hashpw(password, BCrypt.gensalt(12));
			String passwordEncrypt =password; 
			String sql = "INSERT INTO applicationdomain.users (username, password) VALUES (?, ?)";
			PreparedStatement pstt;
			try {
				pstt = conn.prepareStatement(sql);
				pstt.setString(1, username); 
				pstt.setString(2, passwordEncrypt);
				int result = pstt.executeUpdate(); 
				if(result>0) {
					System.out.println("Đăng ký thành công!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
		return false; 
  }
	
	
	public User getUserByUsername(String username) {
		String sql0 = "select * from applicationdomain.users where username = ?";
		PreparedStatement pstt0;
		try {
			pstt0 = conn.prepareStatement(sql0);
			pstt0.setString(1, username);
			ResultSet rs = pstt0.executeQuery();
			if(rs.next()) {
				User user = new User(username, rs.getString(3));
				return user; 
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null; 
	}
}


























