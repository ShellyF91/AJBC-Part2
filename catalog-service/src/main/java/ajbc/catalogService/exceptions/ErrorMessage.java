package ajbc.catalogService.exceptions;

public class ErrorMessage {
	

	private String errorMessage;
	private InternalErrorCode errorCode;
	public ErrorMessage() {
		
	}
	
	
	public ErrorMessage(String errorMessage, InternalErrorCode errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public InternalErrorCode getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(InternalErrorCode errorCode) {
		this.errorCode = errorCode;
	}




}
