package org.bejond.designpattern.proxy;

import org.junit.Test;

public class TestProxy {

	@Test
	public void testProxy() {

		String file1 = "file1";
		String file2 = "file2";
		ImageProxy imageProxy = new ImageProxy();
		imageProxy.load(file1);
		imageProxy.load(file1);
		imageProxy.load(file2);
	}
}
