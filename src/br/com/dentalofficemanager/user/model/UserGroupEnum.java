package br.com.dentalofficemanager.user.model;

public enum UserGroupEnum {
	
	// patients
	
	ASSISTANT(777000000L), DENTIST(777001000L), MANAGER(777777000L), ADMINISTRATOR(777777777L);
	
	private long groupCode;
	
	UserGroupEnum(long groupCode) {
		this.groupCode = groupCode;
	}
	
	public long getCode() {
		return this.groupCode;
	}
	
	public static UserGroupEnum getGroupEnum(String groupName) {
		UserGroupEnum userGroup = UserGroupEnum.ASSISTANT;
		for(UserGroupEnum g : UserGroupEnum.values()) {
			if(g.name().equalsIgnoreCase(groupName)) {
				userGroup = g;
				break;
			}
		}
		return userGroup;
	}
	
	public static UserGroupEnum getGroupEnum(long groupCode) {
		UserGroupEnum userGroup = UserGroupEnum.ASSISTANT;
		for(UserGroupEnum g : UserGroupEnum.values()) {
			if(g.getCode() == groupCode) {
				userGroup = g;
				break;
			}
		}
		return userGroup;
	}
	
	public static long getGroupCode(long code) {
		long groupCode = UserGroupEnum.ASSISTANT.getCode();
		for(UserGroupEnum g : UserGroupEnum.values()) {
			if(g.getCode() == code) {
				groupCode = g.getCode();
				break;
			}
		}
		return groupCode;
	}
	
	public static long getGroupCode(UserGroupEnum group) {
		long groupCode = UserGroupEnum.ASSISTANT.getCode();
		for(UserGroupEnum g : UserGroupEnum.values()) {
			if(g.equals(group)) {
				groupCode = g.getCode();
				break;
			}
		}
		return groupCode;
	}
	
}
