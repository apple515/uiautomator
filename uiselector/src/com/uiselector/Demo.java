package com.uiselector;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.view.View;

public class Demo extends UiAutomatorTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jarName, testClass, testName, androidId;
		jarName="Demo";
		testClass="com.uiselector.Demo";
		testName="testDemo";
		androidId="1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testDemo() throws UiObjectNotFoundException {
		//找到对象-操作对象
		UiSelector l=new UiSelector().text("联系人");
		UiObject object=new UiObject(l);
		object.click();
	}
	
	public  void testMatches()  throws Exception{
		//几种匹配方式
		UiSelector lSelector= new UiSelector().text("联系人");//完全匹配
		UiSelector l=new UiSelector().textContains("联系");//包含匹配
		UiSelector l1=new UiSelector().textStartsWith("联");//起始匹配
		UiSelector l2=new UiSelector().textMatches(".*系.*");//正则匹配
		UiObject object=new UiObject(l);	
	}
	public void tesDesc () throws Exception {
		UiSelector selector=new UiSelector().description("应用");//完全匹配
		UiSelector selector2=new UiSelector().descriptionContains("应");//部分匹配
		UiSelector selector3=new UiSelector().descriptionMatches("应.*");//正则匹配
		UiSelector selector4=new UiSelector().descriptionStartsWith("应");//起始匹配
		UiObject object=new UiObject(selector);
		object.click();
	}
	//类名和包名获取
	public void testclassAndPackage() throws Exception{
		//instance是同一个类名下的第几个
//		UiSelector selector=new UiSelector().className("android.view.view").instance(5);
//		UiSelector selector=new UiSelector().classNameMatches(".*view").instance(5);//会找到很多view，所以需要重新定位instance
	//class.getname
		UiSelector selector=new UiSelector().className(View.class.getName()).instance(5);
		UiObject object=new UiObject(selector);
		object.click();
		
		UiSelector selector2=new UiSelector().packageName("com.android.deskclock");
		UiObject object2=new UiObject(selector2);
	}
	public void testIndex() throws Exception{
		UiSelector selector=new UiSelector().className("android.widget.ImageButyton")
		.index(0);
		UiObject object=new UiObject(selector);
		object.click();
		sleep(2000);
		UiDevice.getInstance().pressBack();
		
		//另外一种实现方式
		UiSelector selector1=new UiSelector().className("android.widget.ImageButyton")
				.instance(1);
		UiObject objectmore=new UiObject(selector1);
		objectmore.click();
		sleep(2000);
		UiDevice.getInstance().pressBack();
	}
	public void testPropertied() throws Exception {
		UiObject switchObj=new UiObject(new UiSelector().checkable(true));
		switchObj.click();
		
		UiObject switchObj1=new UiObject(new UiSelector().checked(true));
		switchObj1.click();
	}

}
 