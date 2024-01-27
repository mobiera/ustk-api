package com.mobiera.ustk.command;

import java.io.Serializable;
import java.util.List;

import com.mobiera.ustk.action.Action;

public interface Command extends Serializable {
	public byte[] getBytes() throws Exception;
	public List<Action> getActions();
	public void setActions(List<Action> actions);

}
