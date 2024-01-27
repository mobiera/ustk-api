package com.mobiera.ustk.action;

import com.mobiera.java.sim.tools.CharsetException;

public interface LaunchBrowserAction extends Action {
	
	public String getUrl();
	public void setUrl(String url);
	public void setTitle(String title) throws CharsetException;
	public String getTitle();
}
