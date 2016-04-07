package com.bejond.wholetest;

/**
 * Created by bejond on 4/7/16.
 */
public enum Province {
	LIAONING(new ProvinceDescription("Liaoning", 14.59)),
	JILIN(new ProvinceDescription("Jilin", 18.74)),
	HEILONGJIANG(new ProvinceDescription("Heilongjiang", 45.48));

	private ProvinceDescription provinceDescription;

	private Province(ProvinceDescription provinceDescription) {
		this.provinceDescription = provinceDescription;
	}

	public ProvinceDescription getProvinceDescription() {
		return provinceDescription;
	}
}
