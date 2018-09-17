package com.uidevicetest;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Demo2 extends UiAutomatorTestCase {
	public void press() {
//		getUiDevice().pressMenu();
//		getUiDevice().pressHome();
		//以上在调用的时候会出现空指针异常
		
		UiDevice.getInstance().pressMenu();
		UiDevice.getInstance().pressHome();
		//下面调用的时候不会出现空指
		
	}

}
