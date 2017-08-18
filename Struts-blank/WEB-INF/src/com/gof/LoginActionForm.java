package com.gof;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ActionMap;

import org.apache.struts.action.ActionForm;

import com.connection.DBUtil;

public class LoginActionForm extends ActionForm {
	private String username;
	private String password;
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs =null;
	
	public LoginActionForm(){
		super();
		conn = DBUtil.getConnection();
	}
	public LoginActionForm(String username, String password){
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean checkLogin(){
		String sql = "Select username, password from MSTUSER" +
				"Where username = ? and password = ? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			int count = 0 ;
			while (rs.next()) {
				count++;
				
			}
			if(count == 1){ return true;}
			
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(LoginActionForm.class.getName()).log(Level.SEVERE, sql);
		}
		return false;
	}
	public void reset (ActionMap mapping, HttpServletRequest request){
		super.rest(mapping, request);
		username = "";
		password = "";
		
	}
}
