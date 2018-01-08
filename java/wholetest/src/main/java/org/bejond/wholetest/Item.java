package org.bejond.wholetest;

/**
 * Created by bejond on 4/8/16.
 */
public interface Item {
	enum Computer implements Item {
		LEVNOVO, IMAC, ACER, DELL
	}

	enum Phone implements Item {
		LEVNOVO, IPHONE, NOKIA, SUMSANG
	}

	enum Car implements Item {
		BMW, KIA, BYD, BENZ
	}
}
