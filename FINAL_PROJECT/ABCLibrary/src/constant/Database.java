package constant;

public enum Database {
	USERNAME("root"),
	PASSWORD("tfg-126ssX"),
	URL("jdbc:mysql://localhost:3306/abclibrary");

	private String string;
	
	private Database(String string) {
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
}
