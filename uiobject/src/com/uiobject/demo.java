package com.uiobject;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.NoopRowProcessor;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.graphics.Point;

public class demo extends UiAutomatorTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void testGesture() throws Exception {
		UiObject webview=new UiObject(new UiSelector().className(""));
		webview.pinchOut(20, 10);//放大
		
		Point startPoint1, startPoint2, endPoint1, endPoint2;
		startPoint1=new Point();
		startPoint2=new Point();
		endPoint1=new Point();
		endPoint2=new Point();
		
		startPoint1.x=157;startPoint1.y=183;
		startPoint2.x=122;startPoint2.y=455;
		endPoint1.x=948;endPoint1.y=195;
		endPoint2.x=930;endPoint2.y=493;
		webview.performTwoPointerGesture(startPoint1, startPoint2, endPoint1, endPoint2, steps)

	}
	public void testExits() throws Exception{
		UiObject lObject=new UiObject(new UiSelector().text("联系人"));
		if (lObject.exists()) {
			lObject.click();
		}
		UiObject create=new UiObject(new UiSelector().text("创建联系人"));
		if (create.waitForExists(5000)) {
			System.out.println("没有任何联系人，需要创建");	
			create.click();
		}
		
	}

}
