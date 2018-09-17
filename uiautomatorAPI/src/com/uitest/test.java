package com.uitest;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import org.junit.platform.engine.TestSource;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

public class test extends UiAutomatorTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jarName, testClass, testName, androidId;
		jarName="demo";
		testClass="com.uitest.test";
		testName="testFling";
		androidId="1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testFling() throws UiObjectNotFoundException {
		UiScrollable scroll=new UiScrollable(new UiSelector().text("123"));
		scroll.click();
		UiObject object=new UiObject(new UiSelector().text("limin"));
		scroll.scrollIntoView(object);
		
	}
	public void testScrollable() throws UiObjectNotFoundException {
		UiScrollable scroll=new UiScrollable(new UiSelector().className(""));
		scroll.scrollBackward(20);
	}
	public void testScrollableIntoview() throws UiObjectNotFoundException {
		UiScrollable scrollable=new UiScrollable(new UiSelector().className(""));
		UiSelector selector=new UiSelector().text("����");
		UiObject object=new UiObject(selector);
//		scrollable.scrollTextIntoView("����");//�����ҵ�����ֹͣ
//		scrollable.scrollToBeginning(50);
	    scrollable.scrollToEnd(50, 5);
	}
	public void testVertical() throws UiObjectNotFoundException {
		UiScrollable scroll=new UiScrollable(new UiSelector().className(""));
		scroll.setAsHorizontalList();
		scroll.setAsVerticalList();
		sleep(2100);
		scroll.scrollForward();//����ȥ
		sleep(2000);
		
	}
	
	

}
