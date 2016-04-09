package com.bejond.enumregion.city;

import com.bejond.enumregion.City;
import com.bejond.enumregion.District;

/**
 * Created by bejond on 4/9/16.
 */
public enum HebeiCity implements City {
	石家庄市(District.Shijiazhuang.class);

	private District[] districts;

	HebeiCity(Class<? extends District> district) {
		districts = district.getEnumConstants();
	}

	public District[] getDistricts() {
		return districts;
	}
}
