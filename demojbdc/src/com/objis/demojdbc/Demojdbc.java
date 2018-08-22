package com.objis.demojdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Demojdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStatements MS = new MyStatements();

		String url = "jdbc:mysql://localhost/formation?autoReconnect=true&useSSL=false";
		String user ="root";
		String pwd ="root";


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = (Connection) DriverManager.getConnection(url, user, pwd);
			Statement st = cn.createStatement();
			String sql = "SELECT * FROM formation.CLIENTS";
			ResultSet result = st.executeQuery(sql);


			int ncVar ;
			String nomcVar;
			String villeVar;
			while(result.next()) {
				ncVar = result.getInt("nc");
				nomcVar = result.getString("nomc");
				villeVar = result.getString("ville");

				System.out.println("Client n°: " + ncVar + " : " + nomcVar + " habite à : " + villeVar );
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("*******************************************");
		System.out.println();
		System.out.println("*******************************************");
		//partie 2 
		MS.exercice2();
		//partie 3 
		System.out.println("*******************************************");
		System.out.println();
		System.out.println("*******************************************");
		MS.exercice3();
		
		//partie 4
		System.out.println("*******************************************");
		System.out.println();
		System.out.println("*******************************************");
		MS.exercice4();
		
		
		//partie 5
		System.out.println("*******************************************");
		System.out.println();
		System.out.println("*******************************************");
		MS.exercice5();
		
	}

}
