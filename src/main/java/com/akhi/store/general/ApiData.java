package com.akhi.store.general;

public class ApiData {
	
	private Object data;
	
	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiData [data=" + data + ", success=" + success + "]";
	}
	
	

}
