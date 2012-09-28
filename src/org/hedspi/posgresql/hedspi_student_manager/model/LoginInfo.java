package org.hedspi.posgresql.hedspi_student_manager.model;
public class LoginInfo{
	private String host;
	private String port;
	private String username;
	private String password;
	private String dbname;

	public LoginInfo(String host, String port, String dbname, String username, String password){
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.dbname = dbname;
	}

	/**
	 * Gets the host for this instance.
	 *
	 * @return The host.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * Gets the port for this instance.
	 *
	 * @return The port.
	 */
	public String getPort() {
		return this.port;
	}

	/**
	 * Gets the username for this instance.
	 *
	 * @return The username.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Gets the password for this instance.
	 *
	 * @return The password.
	 */
	public String getPassword() {
		return this.password;
	}

	public String getUrl() {
		return "jdbc:postgresql://"+host+":" + port +"/" + dbname+"?user="+username+"&password="+password+"&ssl=true";
	}

	public String getDbname() {
		return dbname;
	}
}
