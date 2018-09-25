package com.report;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.icu.util.BuddhistCalendar;
import android.os.Bundle;

public class demo extends UiAutomatorTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UiAutomatorHelper("demo", "com.report.demo", "testReport", "1");
	

	}
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		System.out.println("setup用例开始执行");
		Bundle bundle=new Bundle();
		bundle.putString("key1*", "value1*");
		bundle.putString("key2", "value2");
		getAutomationSupport().sendStatus(10, bundle);
		
	}
	public void testReport() {
		System.out.println("test,用例");
		Bundle bundle=new Bundle();
		bundle.putString("key1", "value1");
		bundle.putString("key2", "value2");
		getAutomationSupport().sendStatus(11, bundle);
	}
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		System.out.println("teardown 用例完了");
		Bundle bundle=new Bundle();
		bundle.putString("key1-", "value1-");
		bundle.putString("key2-", "value2-");
		getAutomationSupport().sendStatus(12, bundle);
	}
	/*
	 * 1.通过-e传输数据到用例中，如拨打一个电话
	 * 2.通过-e传输整体控制参数控制脚本，如清理数据
	 */
	public void testCall() throws UiObjectNotFoundException {
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		
		UiObject call=new UiObject(new UiSelector().text("拨号"));
		UiObject diapload=new UiObject(new UiSelector().description("拨号键盘"));
		
		call.clickAndWaitForNewWindow();
		diapload.clickAndWaitForNewWindow();
//		Bundle bundle=new Bundle();
	    Bundle bundle=getParams();//从键盘获取参数
		//
		//-e参数是要从命令行传输的
		String phone =(String)bundle.get("phone");//要和命令行使用的key一样 -e key value ------  -e phone 10086
		
		for(int i=0;i<phone.length();i++)
		{
			String c=phone.charAt(i)+"";
			UiObject phoneNum=new UiObject(new UiSelector().text(c));
			phoneNum.click();
			sleep(1000);
		}
	}
	/*
	 * 2.通过-e传输整体控制参数控制脚本，如清理数据
	 */
	public void testClear() throws UiObjectNotFoundException {
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		
		Bundle b=getParams();
		String ctrl=(String) b.get("ctrl");
		boolean isClear=Boolean.valueOf(ctrl);
		if (isClear) {
			//执行清理步骤 例如浏览器的数据或者是智能卡的数据等
			UiDevice.getInstance().pressMenu();
			UiObject manapp=new UiObject(new UiSelector().text("管理应用"));
			manapp.clickAndWaitForNewWindow();
			
			UiScrollable list=new UiScrollable(new UiSelector().resourceId("android.view.list"));
			UiObject browser=new UiObject(new UiSelector().text("浏览器"));
			list.scrollIntoView(browser);
			
			browser.clickAndWaitForNewWindow();
			
			UiObject clear=new UiObject(new UiSelector().text("清除数据"));
			clear.click();
			UiObject ok=new UiObject(new UiSelector().text("确定"));	
			ok.clickAndWaitForNewWindow();
		}else {
			//不执行清理
			System.out.println("不执行清理");;
		}
	}

}
