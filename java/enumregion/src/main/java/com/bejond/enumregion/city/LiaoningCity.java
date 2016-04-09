package com.bejond.enumregion.city;

import com.bejond.enumregion.City;
import com.bejond.enumregion.District;

/**
 * Created by bejond on 4/9/16.
 */
public enum LiaoningCity implements City {
	沈阳市(District.Shenyang.class), 大连市(District.Dalian.class);

	private District[] districts;

	LiaoningCity(Class<? extends District> district) {
		districts = district.getEnumConstants();
	}

	public District[] getDistricts() {
		return districts;
	}
}
