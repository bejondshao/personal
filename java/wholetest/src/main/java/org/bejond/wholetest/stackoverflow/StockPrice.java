package org.bejond.wholetest.stackoverflow;

import java.util.HashMap;
import java.util.Map;

public class StockPrice extends HashMap<String, Double> {

	Map<String, Double> values = new HashMap<>();

	@Override
	public Double put(String key, Double value) {
		Double var = values.get(key);
		if ( var == null || var != null && var > value ) {
			values.put(key, value);
			return value;
		}

		return var;
	}

	public void put(Input input) {
		for (String time : input.getTimes()) {
			put(time, input.getValue());
		}
	}
}
