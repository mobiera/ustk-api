package com.mobiera.ustk.action;

import java.io.IOException;
import java.io.Serializable;

import com.cloudhopper.commons.charset.Charset;
import com.mobiera.java.sim.tools.CharsetException;
import com.mobiera.ustk.exception.InvalidDataLengthException;
import com.mobiera.ustk.exception.MissingAttributeException;

public interface Action extends Serializable {
	public byte[] getBytes(boolean debug) throws CharsetException, IOException, MissingAttributeException, InvalidDataLengthException;
	public Charset getCharset();
	public void setCharset(Charset charset);
	public void setOkAction(Action action);
	public void setBackAction(Action action);
	public void setCancelAction(Action action);
	public void setPreviousStartPosition(int offset);
	public int getPreviousStartPosition();
	public int getStartPosition();
	public void setStartPosition(int startPosition);
}
