package com.mobiera.ustk.util;

/**
 * Outcome of a ustk response that carries an action result extension (the
 * {@code ¤A¤} separator), e.g. the micro applet reply. {@code OK} means the
 * user accepted the action(s); {@code CANCEL} means the user cancelled / went
 * back.
 */
public enum UstkActionResult {
	OK,
	CANCEL;
}
