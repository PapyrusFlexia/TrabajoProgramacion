package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	static String timezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String dbName = "lamarcadeleste";
	static String url = "jdbc:mysql://localhost:3306/" + dbName + timezone;
	static String user = "root";
	static String pass = "manolo";
	/*static String driver = "com.mysql.cj.jdbc.Driver";*/

	static Connection conexion;
	static Statement consulta;
	static ResultSet resultado;

	public static void conectar() {
		try {
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion estableida de la base de datos");
			consulta = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Ha fallado la conexion con la base de datos");
			e.printStackTrace();
		}
	}

	public static ResultSet EjecutarSentencia(String sentencia) {
		try {
			resultado = consulta.executeQuery(sentencia);
			System.out.println("Done");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public static void EjecutarUpdate(String sentencia) {
		try {
			consulta.executeUpdate(sentencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void CerrarConexion() {
		try {
			consulta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
