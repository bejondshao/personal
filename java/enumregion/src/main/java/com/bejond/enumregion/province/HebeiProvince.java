package com.bejond.enumregion.province;

import com.bejond.enumregion.Province;
import com.bejond.enumregion.city.HebeiCity;

/**
 * Created by bejond on 4/9/16.
 */
public enum HebeiProvince implements Province {
	河北省(HebeiCity.class);

	private HebeiCity[] hebeiCities;

	HebeiProvince(Class<? extends HebeiCity> hebeiCity) {
		hebeiCities = hebeiCity.getEnumConstants();
	}

	public HebeiCity[] getHebeiCities() {
		return hebeiCities;
	}
}
