package com.bejond.enumregion.city;

import com.bejond.enumregion.City;
import com.bejond.enumregion.District;

/**
 * Created by bejond on 4/9/16.
 */
public enum DirectCity implements City {
	北京市(District.Beijing.class), 上海市(District.Shanghai.class),
	天津市(District.Tianjin.class), 重庆市(District.Chongqing.class);

	private District[] districts;

	DirectCity(Class<? extends District> district) {
		districts = district.getEnumConstants();
	}

	public District[] getDistricts() {
		return districts;
	}
}
