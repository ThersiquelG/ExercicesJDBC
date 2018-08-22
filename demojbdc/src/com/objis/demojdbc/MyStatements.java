package com.objis.demojdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class MyStatements {

	public void exercice2() {


		String url = "jdbc:mysql://localhost/formation?AutoReconnect&useSSL=FALSE";
		String user ="root";
		String pwd ="root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = (Connection) DriverManager.getConnection(url, user, pwd);
			Statement st = cn.createStatement();
			String sql = "SELECT * FROM `PRODUITS` WHERE `COUL` = 'Rouge' AND `PDS` > 2000;";
			ResultSet result = st.executeQuery(sql);

			int numProduit;
			String coulVar;
			int pdsVar;
			String nomProduit ;
			while(result.next()) {
				numProduit = result.getInt("NP");
				coulVar = result.getString("COUL");
				pdsVar = result.getInt("PDS");
				nomProduit = result.getString("NOMP");

				System.out.println("Vous avez demander tout les produits de couleur Rouge et dont le poid est supérieur à 2000.");
				System.out.println("Produit n° : " + numProduit + " : " + nomProduit + " " + coulVar + " " + " " + pdsVar);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exercice3() {
		String url = "jdbc:mysql://localhost/formation?AutoReconnect&useSSL=FALSE" ;
		String usr = "root";
		String pwd = "root" ;

		try {
			Connection cn = (Connection) DriverManager.getConnection(url, usr, pwd);
			Statement st = cn.createStatement();
			String sql = "SELECT * FROM `REPRESENTANTS` INNER JOIN `VENTES` ON `VENTES`.`NR` = `REPRESENTANTS`.`NR`WHERE `QT` > 1";
			ResultSet result = st.executeQuery(sql);

			int numRep ;
			String nomRep;
			while(result.next()) {
				numRep = result.getInt("NR");
				nomRep = result.getString("NOMR");

				System.out.println("Vous avez demander : les représentants ayant effectué plus d'une vente.");
				System.out.println("Représentant n° : " + numRep + " Mr : " + nomRep);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exercice4() {
		String url = "jdbc:mysql://localhost/formation?AutoReconnect&useSSL=FALSE";
		String usr = "root";
		String pwd = "root";

		try {
			Connection cn = (Connection)DriverManager.getConnection(url, usr, pwd);
			Statement st = cn.createStatement();
			String sql = "SELECT * FROM `CLIENTS` INNER JOIN `VENTES` ON `VENTES`.`NC` = `CLIENTS`.`NC` WHERE `VILLE` = 'Lyon' AND `QT` > 180;";
			ResultSet result = st.executeQuery(sql);

			int numClient ;
			String nomClient;
			String villeVar ;
			int qte ;
			while(result.next()) {
				numClient = result.getInt("NC");
				nomClient = result.getString("NOMC");
				villeVar = result.getString("VILLE");
				System.out.println("Vous avez demander d'afficher le ou les clients habitant à Lyon et qui ont commandé plus de 180 pdts.");
				System.out.println("Client n°: " + numClient + " " + "Mr." + nomClient +  " vit à : " + villeVar);
			}

		} catch(SQLException e) {
			e.printStackTrace();


		}
	}

	public void exercice5() {
		String url = "jdbc:mysql://localhost/formation?AutoReconnect&useSSL=FALSE";
		String usr="root";
		String pwd ="root";

		try {
			Connection cn = (Connection) DriverManager.getConnection(url, usr, pwd);
			Statement st = cn.createStatement();
			String sql ="SELECT * FROM `REPRESENTANTS`\n" + 
					"INNER JOIN `CLIENTS`, `PRODUITS`, `VENTES`\n" + 
					"WHERE `COUL` = 'Rouge' AND `QT` > 100 AND `VENTES`.`NR` = `REPRESENTANTS`.`NR` AND `VENTES`.`NC` = `CLIENTS`.`NC` AND `VENTES`.`NP` = `PRODUITS`.`NP`;";
			ResultSet result = st.executeQuery(sql);

			String nomRep;
			String nomClient;
			String nomProduit;

			int qte;
			while(result.next()) {
				nomRep = result.getString("NOMR");
				nomClient = result.getString("NOMC");
				nomProduit = result.getString("NOMP");

				System.out.println("Vous avez demander : Les noms des représentants et clients qui ont acheté/vendu des produits rouges à plus de 100 quantitées");
				System.out.println("Le représentant : " + nomRep + " a vendu " + nomProduit + " à  un dénommé " + nomClient + " de couleur " + result.getString("COUL"));
			}

		}

		catch(SQLException e) {
			e.printStackTrace();

		}
	}
}
