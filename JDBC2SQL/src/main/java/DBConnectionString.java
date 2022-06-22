
public class DBConnectionString {
	
	private String url; 
	private String serverAddress; 
	private String port; 
	private String dataBaseName;
	private String serverName;
	private String userName;
	private String password;
	
	
	public DBConnectionString(String serverAddress, String port, String dataBaseName, String serverName) {
		this.serverAddress = serverAddress;
		this.port = port; 
		this.dataBaseName = dataBaseName;
		this.serverName = serverName;
		this.userName = userName;
		this.password = password;
		buildUrl();
	}


	private void buildUrl() {
		
		
	}


	public String getUrl() {
		return url;
	}


}
