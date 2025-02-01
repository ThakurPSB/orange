package orange.piyushmain.Errors;

public class invalidBrowserError extends Error {
	
	private String browserName;
	//constructor to get the browser name into error message
	public invalidBrowserError(String browserName) {
		this.browserName = browserName;
	}
	@Override
	public String getMessage() {
		return "Invalid browser name: "+ this.browserName;
	}
}