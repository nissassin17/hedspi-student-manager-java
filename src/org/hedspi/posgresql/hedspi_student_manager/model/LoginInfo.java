package org.hedspi.posgresql.hedspi_student_manager.model;
public class LoginInfo{
	String host;
	String port;
	String username;
	String password;

	public LoginInfo(String host, String port, String username, String password){
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
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

	public String getUrl(String database) {
		return "jdbc:postgresql://"+host+":" + port +"/" + database+"?user="+username+"&password="+password+"&ssl=true";
	}
}
