package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_pwdmanagementsystem","root", "1234");
		return connection;
	}
	
	public void deleteUser(int id) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from user where id=?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		connection.close();
		System.out.println("Your account is deleted successfully!!!");		
	}

	public void signUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");
		preparedstatement.setInt(1, user.getId());
		preparedstatement.setString(2, user.getUsername());
		preparedstatement.setString(4, user.getPassword());
		preparedstatement.setString(5, user.getAddress());
		preparedstatement.setString(3, user.getEmail());
		preparedstatement.execute();
		connection.close();
		System.out.println("Sign in successfull!!!");

	}

	public boolean loginUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from user where email=?");
		preparedStatement.setString(1, user.getEmail());
		ResultSet rs = preparedStatement.executeQuery();
		String password = null;
		while (rs.next()) {
			password = rs.getString("password");
		}
		if (password.equals(user.getPassword())) {
			return true;
		}
		return false;

	}
	
	public void setPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(
		"update user set facebookpwd=?, instagrampwd=?, snapchatpwd=?,whatsapppwd=?, twitterpwd=? where email=?");
		preparedstatement.setString(1, user.getFacebookpwd());
		preparedstatement.setString(2, user.getInstagrampwd());
		preparedstatement.setString(3, user.getSnapchatpwd());
		preparedstatement.setString(4, user.getWhatsapppwd());
		preparedstatement.setString(5, user.getTwitterpwd());
		preparedstatement.setString(6, user.getEmail());
		preparedstatement.execute();
		connection.close();
		System.out.println("Passwords stored successfully!!!");

	}

	public void displayPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from user where email=?");
		preparedStatement.setString(1, user.getEmail());
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			System.out.println("Your facebook password is ==> "+rs.getString("facebookpwd"));
			System.out.println("Your snapchat password is ==> "+rs.getString("snapchatpwd"));
			System.out.println("Your instagram password is ==> "+rs.getString("instagrampwd"));
			System.out.println("Your whatsapp password is ==> "+rs.getString("whatsapppwd"));
			System.out.println("Your twitter password is ==> "+rs.getString("twitterpwd"));
			System.out.println();
		}
		connection.close();
	}
	public void updateFacebookPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  user set facebookpwd=? where email=?");
		preparedStatement.setString(1, user.getFacebookpwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("facebook password updated successfully!!!");
		System.out.println("Your new password is "+user.getFacebookpwd());
	}
	public void updateInstagramPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  user set instagrampwd=? where email=?");
		preparedStatement.setString(1, user.getInstagrampwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("instagram password  updated successfully!!!");
		System.out.println("Your new password is ==> "+user.getInstagrampwd());
	}
	public void updateSnapchatpwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  user set snapchatpwd=? where email=?");
		preparedStatement.setString(1, user.getSnapchatpwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("Snapchat password updated successfully!!!");
		System.out.println("Your new password is ==> "+user.getSnapchatpwd());
	}
	public void updateWhatsappPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  user set whatsapppwd=? where email=?");
		preparedStatement.setString(1, user.getWhatsapppwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("Whatsapp password updated successfully!!!");
		System.out.println("Your new password is ==> "+user.getWhatsapppwd());
	}
	public void updateTwitterPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  user set twitterpwd=? where email=?");
		preparedStatement.setString(1, user.getTwitterpwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("Twitter password updated successfully!!!");
		System.out.println("Your new password is ==> "+user.getTwitterpwd());
	}

}
