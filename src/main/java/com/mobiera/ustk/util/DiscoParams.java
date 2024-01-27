package com.mobiera.ustk.util;

public class DiscoParams {
	String impl;
	String bytes;
	
	public static DiscoParams build(String impl, String bytes) {
		DiscoParams params = new DiscoParams();
		params.setImpl(impl);
		params.setBytes(bytes);
		return params;
	}

	public String getImpl() {
		return impl;
	}

	public void setImpl(String impl) {
		this.impl = impl;
	}

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}
	
	
}
