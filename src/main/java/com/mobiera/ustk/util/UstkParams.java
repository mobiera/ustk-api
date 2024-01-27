package com.mobiera.ustk.util;

public class UstkParams {
	String campaignId;
	String endpointId;
	String requestId;
	String adId;
	String campaignScheduleId;
	Boolean testing;
	
	public static UstkParams build(String campaignId, String enpointId, String requestId, String adId, String campaignScheduleId, Boolean testing) {
		
		// ¤U¤¤U¤58129251--60568407-85353303-85453443-n
		
		UstkParams params = new UstkParams();
		
		if ((campaignId != null) && (!campaignId.isBlank())) params.setCampaignId(campaignId);
		
		if ((enpointId != null) && (!enpointId.isBlank())) params.setEndpointId(enpointId);
		if ((requestId != null) && (!requestId.isBlank())) params.setRequestId(requestId);
		if ((adId != null) && (!adId.isBlank())) params.setAdId(adId);
		if ((campaignScheduleId != null) && (!campaignScheduleId.isBlank())) params.setCampaignScheduleId(campaignScheduleId);
		params.setTesting(testing);
		return params;
	}
	
	public Long getCampaignScheduleIdId() {
		if (campaignScheduleId != null) {
			if (!campaignScheduleId.isEmpty()) {
				try {
					Long campaignSchedule = Long.parseLong(campaignScheduleId);
					return campaignSchedule;
				} catch (Exception e) {
					
				}
						
			}
		}
		return null;
	}
	public Long getCampaignIdId() {
		if (campaignId != null) {
			if (!campaignId.isEmpty()) {
				try {
					Long campaign = Long.parseLong(campaignId);
					return campaign;
				} catch (Exception e) {
					
				}
						
			}
		}
		return null;
	}
	
	public Long getEndpointIdId() {
		if (endpointId != null) {
			if (!endpointId.isEmpty()) {
				try {
					Long endpoint = Long.parseLong(endpointId);
					return endpoint;
				} catch (Exception e) {
					
				}
						
			}
		}
		return null;
	}
	
	public Long getRequestIdId() {
		if (requestId != null) {
			if (!requestId.isEmpty()) {
				try {
					Long request = Long.parseLong(requestId);
					return request;
				} catch (Exception e) {
					
				}
						
			}
		}
		return null;
	}
	
	public Long getAdIdId() {
		if (adId != null) {
			if (!adId.isEmpty()) {
				try {
					Long ad = Long.parseLong(adId);
					return ad;
				} catch (Exception e) {
					
				}
						
			}
		}
		return null;
	}
	
	
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	
	public void setEndpointId(String endpointId) {
		this.endpointId = endpointId;
	}
	
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public String getEndpointId() {
		return endpointId;
	}

	public String getRequestId() {
		return requestId;
	}

	public Boolean getTesting() {
		return testing;
	}

	public void setTesting(Boolean testing) {
		this.testing = testing;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getCampaignScheduleId() {
		return campaignScheduleId;
	}

	public void setCampaignScheduleId(String campaignScheduleId) {
		this.campaignScheduleId = campaignScheduleId;
	}
}
