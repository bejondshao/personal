package com.bejond.spring.sample.injectCollection;
import java.util.*;
/**
 * Created by bejond on 15-9-30.
 */
public class JavaCollection {
	List list;
	Set set;
	Map map;
	Properties property;

	public List getList() {
		System.out.print("List: " + list);
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Map getMap() {
		System.out.print("Map: " + map);
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Properties getProperty() {
		System.out.print("Properties: " + property);
		return property;
	}

	public void setProperty(Properties property) {
		this.property = property;
	}

	public Set getSet() {
		System.out.print("Set: " + set);
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
}
