package com.uidevicetest;

import java.io.File;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.os.RemoteException;
import android.view.KeyEvent;

public class Browser extends UiAutomatorTestCase {
	
	UiDevice mdevice=UiDevice.getInstance();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void testBrowser() throws RemoteException, UiObjectNotFoundException {
		//亮屏-解锁-单机浏览器-单击网址输入框-输入www.baidu.com-按回车键-旋转屏幕-截图
		if (!mdevice.isScreenOn()) {
			mdevice.wakeUp();
		}
		mdevice.swipe(536, 1496, 1080, 1496, 10);
		mdevice.pressHome();
		UiObject browser=new UiObject(new UiSelector().text("浏览器"));
		sleep(1000);
		if (!browser.exists()) {
		}
		browser.click();
		sleep(3000);
		//点击输入网址区域并点击重新输入
		//方法1
		mdevice.click(589, 151);//点击浏览器的坐标
		mdevice.pressDelete();//删除浏览器网址区域的东西
		mdevice.pressKeyCode(KeyEvent.KEYCODE_W);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_W);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_W);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_PERIOD);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_B);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_A);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_I);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_D);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_U);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_PERIOD);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_C);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_O);
		mdevice.pressKeyCode(KeyEvent.KEYCODE_M);
		
		mdevice.pressEnter();
		
		mdevice.setOrientationLeft();
		mdevice.takeScreenshot(new File("/sdcard/test2.png"));
//		UiObject input=new UiObject(new UiSelector().resourceId("com.android.browser:id/url"));
//		input.clearTextField();
		
	}

}
