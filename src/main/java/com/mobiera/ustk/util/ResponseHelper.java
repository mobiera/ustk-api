package com.mobiera.ustk.util;

public class ResponseHelper {
	public static String USTK_RESPONSE_SEPARATOR = "¤U¤"; //§
	
	public static String getTransactionId(String message) {
		if (!message.startsWith(USTK_RESPONSE_SEPARATOR)) {
			return null;
		}
		String[] sp = message.substring(USTK_RESPONSE_SEPARATOR.length()).split(USTK_RESPONSE_SEPARATOR);
		
		return sp[0];
	}
	
	public static String getUstkValue(String message) {
		if (!message.startsWith(USTK_RESPONSE_SEPARATOR)) {
			return null;
		}
		String[] sp = message.substring(USTK_RESPONSE_SEPARATOR.length()).split(USTK_RESPONSE_SEPARATOR);
		if (sp.length > 1) {
			return sp[1];
		}
		return null;
	}
	

	@Deprecated
	public static String getValue(String message) {
		
		return getUstkValue(message);
	}
	
	
	public static String buildUstkString(String campaignId, String endpointId, String requestId, Long adId, Long campaignScheduleId, Boolean testing) {
		
		String retval = USTK_RESPONSE_SEPARATOR;
		if (campaignId!= null) retval = retval + campaignId;
		retval = retval + "-";
		if (endpointId!= null) retval = retval + endpointId;
		retval = retval + "-";
		if (requestId!= null) retval = retval + requestId;
		retval = retval + "-";
		if (adId!= null) retval = retval + adId;
		retval = retval + "-";
		if (campaignScheduleId!= null) retval = retval + campaignScheduleId;
		retval = retval + "-";
		if (testing != null) {
			if (testing) {
				retval = retval + "t";
			} else {
				retval = retval + "n";
			}
		}
		return retval;

	}

	/**
	 * Separator that delimits an optional <b>action result</b> extension appended
	 * after the ustk response body, e.g. by the micro applet. The reply on the
	 * wire is {@code <ustk response>¤A¤<token>} where {@code <token>} is
	 * {@code <O|C><lastActionId>} (`O0`/`O1`/`O2` = OK, `C1`/`C2` = cancelled).
	 */
	public static String USTK_ACTION_SEPARATOR = "¤A¤";

	/**
	 * Builds the response string an applet that cannot wrap the value itself
	 * (the micro applet) must echo back: a full double-separator ustk response
	 * ({@code ¤U¤¤U¤<fields>}) terminated with the action separator, so that the
	 * applet's 2-byte result token lands right after {@code ¤A¤}. Pass this as
	 * the REPLY_APPENDIX value.
	 */
	public static String buildMicroResponseString(String campaignId, String endpointId, String requestId, Long adId, Long campaignScheduleId, Boolean testing) {
		return USTK_RESPONSE_SEPARATOR + buildUstkString(campaignId, endpointId, requestId, adId, campaignScheduleId, testing) + USTK_ACTION_SEPARATOR;
	}

	public static UstkParams parseUstkString(String message) {
		if (message == null) return null;

		// Strip the optional action result extension "<base>¤A¤<token>" first, so the
		// base (the ¤U¤¤U¤<fields> ustk response) parses exactly as without it.
		Integer lastActionId = null;
		UstkActionResult result = null;
		int actionIdx = message.indexOf(USTK_ACTION_SEPARATOR);
		if (actionIdx >= 0) {
			String token = message.substring(actionIdx + USTK_ACTION_SEPARATOR.length());
			message = message.substring(0, actionIdx);
			if (token.length() >= 2) {
				char r = token.charAt(0);
				char d = token.charAt(1);
				if ((r == 'O' || r == 'C') && (d >= '0' && d <= '9')) {
					result = (r == 'C') ? UstkActionResult.CANCEL : UstkActionResult.OK;
					lastActionId = d - '0';
				}
			}
		}

		String value = getUstkValue(message);
		if (value == null) return null;
		String[] infos = value.split("-");
		UstkParams params = null;
		if (infos != null) {
			if (infos.length == 5) {
				params = UstkParams.build(infos[0], infos[1], infos[2], infos[3], infos[4], null);
			} else if (infos.length == 6) {
				boolean test = false;
				if (infos[4].equals("t")) {
					test = true;
				}
				params = UstkParams.build(infos[0], infos[1], infos[2], infos[3], infos[4], test);
			}
		}
		if (params != null) {
			params.setLastActionId(lastActionId);
			params.setResult(result);
		}
		return params;
	}
	
	public static String SLEEPY_FLOW_SEPARATOR = "¤S¤";
	
	
	
	public static String getSleepyFlowStkActionId(String message) {
		if (!message.startsWith(SLEEPY_FLOW_SEPARATOR)) {
			return null;
		}
		String[] sp = message.substring(SLEEPY_FLOW_SEPARATOR.length()).split(SLEEPY_FLOW_SEPARATOR);
		
		return sp[0];
	}
	
	public static String getSleepyFlowValue(String message) {
		if (!message.startsWith(SLEEPY_FLOW_SEPARATOR)) {
			return null;
		}
		String[] sp = message.substring(SLEEPY_FLOW_SEPARATOR.length()).split(SLEEPY_FLOW_SEPARATOR);
		if (sp.length > 1) {
			return sp[1];
		}
		return null;
	}
	
	
	public static String buildSleepyFlowString(String value) {
		
		String retval = SLEEPY_FLOW_SEPARATOR + value;
		return retval;
		
	}
	
	
	public static String DISCOVERY_SEPARATOR = "¤D¤";
	
	
	public static String buildDiscoString(String impl) {
		
		String retval = DISCOVERY_SEPARATOR;
		if (impl!= null) {
			retval = retval + impl;
		}
		retval = retval + "-";
		return retval;
		
	}
	
	public static String getDiscoveryValue(String message) {
		if (!message.startsWith(DISCOVERY_SEPARATOR)) {
			return null;
		}
		String[] sp = message.split(DISCOVERY_SEPARATOR);
		if (sp.length > 1) {
			return sp[1];
		}
		return null;
	}
	
	
	public static DiscoParams parseDiscoString(String message) {
		if (!message.startsWith(DISCOVERY_SEPARATOR)) {
			return null;
		}
		String value = getDiscoveryValue(message);
		String[] infos = value.split("-");
		if (infos != null) {
			if (infos.length == 1) {
				return DiscoParams.build(infos[0], null);
			} else if (infos.length == 2) {
				return DiscoParams.build(infos[0], infos[1]);
			}
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		String info = "¤D¤PICO-";
		DiscoParams params = parseDiscoString(info);
		
		System.out.println(params.getImpl());
		System.out.println(params.getBytes());
		
	}
	
}
