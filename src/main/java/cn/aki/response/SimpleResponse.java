package cn.aki.response;

public class SimpleResponse extends Response<Void, Void>{
	private boolean success;

	@Override
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
}
