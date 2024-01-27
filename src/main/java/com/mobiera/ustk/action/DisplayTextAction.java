package com.mobiera.ustk.action;

import com.mobiera.java.sim.tools.CharsetException;

public interface DisplayTextAction extends Action {
	public String getText();
	public void setText(String text) throws CharsetException;
}
