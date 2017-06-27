package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	
	
	//private SimpleConnectionMaker SimpleConnectionMaker; //1.3

	public UserDao() {
		ConnectionMaker = new SimpleConnectionMaker(); //1.3
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		//Connection c= SimpleConnectionMaker.makeNewConnection(); //1.3
		Connection c = connectionMaker.makeConnection();
		/*
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/springbook?autoReconnect=true&useSSL=false", "spring", "book");
		*/ //1.1
		/*
		Connection c = getConnection();
		*/ // 1.2
		PreparedStatement ps = c.prepareStatement(
				"INSERT INTO users(id, name, password) VALUES (?,?,?)");
		ps.setString(1,  user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();

	}

	public User get(String id) throws ClassNotFoundException ,SQLException {
		/*
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/springbook?autoReconnect=true&useSSL=false", "spring", "book");
		*/ //1.1
		// Connection c= SimpleConnectionMaker.makeNewConnection(); //1.3
		Connection c = connectionMaker.makeConnection();
		/*
		Connection c = getConnection();
		*/ // 1.2
		PreparedStatement ps = c.prepareStatement(
				"SELECT * FROM users WHERE id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}

	/*
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/springbook?autoReconnect=true&useSSL=false", "spring", "book");
		return c;
	}
	*/ //1.2
}
