package com.msi.micromocks.dto;

public class MockItemInternalRequestControllerDTO {
	private String endPoint;
	
	private VariantControllerDTO variantControllerDTO;

	public MockItemInternalRequestControllerDTO() {
		
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public VariantControllerDTO getVariantControllerDTO() {
		return variantControllerDTO;
	}

	public void setVariantControllerDTO(VariantControllerDTO variantControllerDTO) {
		this.variantControllerDTO = variantControllerDTO;
	}
	
	
	
}
