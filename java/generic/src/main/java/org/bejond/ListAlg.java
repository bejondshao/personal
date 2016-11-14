package org.bejond;

import java.util.List;

/**
 * Created by Bejond on 2016/11/14.
 */
public class ListAlg {

	public static <T extends Comparable> Pair<T> minMax(List<T> list) {

		if (list.size() <= 0) {
			return null;
		}

		T min = list.get(0);
		T max = list.get(0);

		for (T t : list) {
			if (min.compareTo(t) > 0) {
				min = t;
			}
			else if (max.compareTo(t) < 0) {
				max = t;
			}
		}

		return new Pair<T>(min, max);
	}
}
