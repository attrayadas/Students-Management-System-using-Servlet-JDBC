package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	private JdbcUtil() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		HikariConfig config = new HikariConfig(
				"C:\\Users\\Attraya\\git\\repository3\\Students Management System using Servlet JDBC\\src\\main\\java\\in\\ineuron\\properties\\db.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		Connection connection = dataSource.getConnection();
		return connection;

	}

	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Attraya\\git\\repository3\\Students Management System using Servlet JDBC\\src\\main\\java\\in\\ineuron\\properties\\db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
