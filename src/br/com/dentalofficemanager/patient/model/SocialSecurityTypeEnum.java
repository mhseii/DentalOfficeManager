package br.com.dentalofficemanager.patient.model;

public enum SocialSecurityTypeEnum {
	RG(1L, "RG"), CPF(2L, "CPF"), CNPJ(3L, "CNPJ");

	private long ssnTypeCode;
	private String ssnTypeName;

	SocialSecurityTypeEnum(long ssnTypeCode, String ssnTypeName) {
		this.ssnTypeCode = ssnTypeCode;
		this.ssnTypeName = ssnTypeName;
	}

	public long getCode() {
		return ssnTypeCode;
	}

	public String getName() {
		return ssnTypeName;
	}

	public static SocialSecurityTypeEnum getEnumFromCode(long code) {
		SocialSecurityTypeEnum selected = SocialSecurityTypeEnum.CPF;
		for (SocialSecurityTypeEnum type : SocialSecurityTypeEnum.values()) {
			if (type.getCode() == code) {
				selected = type;
				break;
			}
		}
		return selected;
	}
	
	public static SocialSecurityTypeEnum getEnumFromName(String name) {
		SocialSecurityTypeEnum selected = SocialSecurityTypeEnum.CPF;
		for (SocialSecurityTypeEnum type : SocialSecurityTypeEnum.values()) {
			if (type.getName().equalsIgnoreCase(name)) {
				selected = type;
				break;
			}
		}
		return selected;
	}
}
