package com.bejond.enumregion.province;

import com.bejond.enumregion.Province;
import com.bejond.enumregion.city.LiaoningCity;

/**
 * Created by bejond on 4/9/16.
 */
public enum LiaoningProvince implements Province {
	辽宁省(LiaoningCity.class);

	private LiaoningCity[] liaoningCities;

	LiaoningProvince(Class<? extends LiaoningCity> liaoningCity) {
		liaoningCities = liaoningCity.getEnumConstants();
	}

	public LiaoningCity[] getLiaoningCities() {
		return liaoningCities;
	}
}
