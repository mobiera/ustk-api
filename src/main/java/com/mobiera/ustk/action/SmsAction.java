package com.mobiera.ustk.action;

import com.mobiera.java.sim.tools.CharsetException;

public interface SmsAction extends Action {
	
	public String getTpda();
	public void setTpda(String tpda);
	public void setData(String data) throws CharsetException;
	public String getData();
}
