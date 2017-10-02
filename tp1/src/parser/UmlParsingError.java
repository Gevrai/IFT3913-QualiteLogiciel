package parser;

public class UmlParsingError extends Exception {
	
	String errorMessage;

	public UmlParsingError(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "UmlParsingError :" + errorMessage ;
	}

}
