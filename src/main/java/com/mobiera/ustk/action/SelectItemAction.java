package com.mobiera.ustk.action;

import java.util.List;

import com.mobiera.java.sim.tools.CharsetException;

public interface SelectItemAction extends Action {
	public String getTitle();
	public void setTitle(String text) throws CharsetException;
	public List<ItemAction> getItems();
	public void setItems(List<ItemAction> items);
}
