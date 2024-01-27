package com.mobiera.ustk.action;

import com.mobiera.java.sim.tools.CharsetException;

public interface ItemAction extends Action {
	public String getText();
	public void setText(String text) throws CharsetException;
	//public String getValue();
	//public void setValue(String text);
	
}
