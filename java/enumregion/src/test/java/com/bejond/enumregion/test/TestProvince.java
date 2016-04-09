package com.bejond.enumregion.test;

import com.bejond.enumregion.District;
import com.bejond.enumregion.city.LiaoningCity;
import com.bejond.enumregion.province.LiaoningProvince;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bejond on 4/9/16.
 */
public class TestProvince {
	@Test
	public void testGetDistrictsByCityName() {
		/*Province province = Liaoning.大连市;
		for (Province city : province.getClass().getEnumConstants())
			Province district = city.getClass().getEnumConstants();*/
		String city = "dalian";
		city = city.toLowerCase();
		//city = (char)(city.charAt(0) - 32) + city.substring(1);
		System.out.println(city);

		/**
		 * this cityMap should be done by other class or method.
		 */
		Map<String, String> cityMap = new HashMap<String, String>();
		cityMap.put("dalian", "大连市");
		cityMap.put("shenyang", "沈阳市");

		String cityName = cityMap.get(city);

		LiaoningCity liaoningCity = LiaoningCity.valueOf(cityName);

		for (District district : liaoningCity.getDistricts()) {
			System.out.println(district);
		}
	}

	@Test
	public void getDistrictsByProvinceName() {
		String name = "liaoning";
		name = name.toLowerCase();

		/**
		 * this provinceMap should be done by other class or method.
		 */
		Map<String, String> provinceMap = new HashMap<String, String>();
		provinceMap.put("liaoning", "辽宁省");
		provinceMap.put("hebei", "河北省");

		String provinceName = provinceMap.get(name);

		String enumName = (char)(name.charAt(0) - 32) + name.substring(1) + "Province";

		/**
		 * this is stupid
		 */
		if (enumName.equals(LiaoningProvince.class.getSimpleName())) {
			for (LiaoningProvince liaoningProvince : LiaoningProvince.values()) {
				System.out.println(liaoningProvince.name());
				for (LiaoningCity liaoningCity0 : liaoningProvince.getLiaoningCities()) {
					System.out.println(liaoningCity0.name() + "--");
				}

				for (LiaoningCity liaoningCity : LiaoningCity.values()) {
					System.out.println(liaoningCity.name());

					for (District district : liaoningCity.getDistricts()) {
						System.out.println(district);
					}
					System.out.println();
				}
			}
		}

		/*Province province = Province.valueOf(provinceName);

		for (Enum city : province.getClass().getEnumConstants()) { // get cities
			System.out.println(city.name());

			for (District district : ((LiaoningCity) city).getDistricts()) {
				System.out.println(district.toString());
			}
			break;

		}*/
	}
}
