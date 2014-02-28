package org.rest.action;



/**
 * ���ؽ��
 * @author Administrator
 *
 */
public class ActionResult {

	private boolean successful;
	private int errorId;
	private String errorMessage;
	
	public ActionResult() {
		setError(99,"�����ڲ�����û�����÷��ؽ��");
	}
	public int getErrorId() {
		return errorId;
	}
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public boolean isSuccessful() {
		return successful;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
	public void setError(int id,String message){
		this.setSuccessful(false);
		this.setErrorId(id);
		this.setErrorMessage(message);
	}
	
	public void setOK(){
		this.setSuccessful(true);
		this.setErrorId(0);
		this.setErrorMessage("");
	}
}
