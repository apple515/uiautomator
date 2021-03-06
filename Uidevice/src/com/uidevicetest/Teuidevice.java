package com.uidevicetest;

import java.io.File;
import java.rmi.server.UID;

import org.junit.jupiter.params.shadow.com.univocity.parsers.tsv.TsvFormat;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.Surface;

public class Teuidevice extends UiAutomatorTestCase {
	public void testDevice() {
//		UiDevice.getInstance().pressHome();
//		getUiDevice().pressHome();//这种方法在后续的使用过程中可能会出现空指针
		Demo2 d2=new Demo2();
		d2.press();
	}
	
	public static void main(String args) {
		String jarName, testClass, testName, androidId;
		jarName="Teuidevice";
		testClass="com.uidevicetest.Teuidevice";
		testName="testdevice";
		androidId="1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
		
	}
	public void testPress() {
//		UiDevice.getInstance().pressMenu();//getinstanc是获取instance实例
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_A);//输入小写字母a
		
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_A,1);//输入大写字母a
	}
	
	public void testClick() throws UiObjectNotFoundException {
		UiDevice.getInstance().click(399, 355);
		int h=UiDevice.getInstance().getDisplayHeight();
		int w=UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().click(w/2, h/2);
		//矩形区域的对象,获取一个对象的区域
		UiObject clock=new UiObject(new UiSelector().resourceId(""));
		Rect r=clock.getBounds();
		int x0=r.left;
		int y0=r.top;
		int x1=r.right;
		int y1=r.bottom;
		
		int centerx=r.centerX();
		int centery=r.centerY();//获取中点
		
		System.out.println("["+x0+","+y0+"]");
		System.out.println("["+x1+","+y1+"]");
	}
	public void testDragandSWip() {
		int startX, startY, endX, endY, steps;
		startX=(444-252)/2+252;
		startY=(1896-1704)/2+1704;
		endX=startX;
		endY=startY-500;
		steps=10;
		UiDevice.getInstance().drag(startX, startY, endX, endY, steps);
		
		int h=UiDevice.getInstance().getDisplayHeight();
		int w=UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().swipe(w-50, h/2, 50, h/2, 10);
		
		Point p1=new Point();
		Point p2=new Point();
		Point p3=new Point();
		Point p4=new Point();
		
		p1.x=277;
		p1.y=318;
		p2.x=746;
		p2.y=335;
		p3.x=784;
		p3.y=814;
		p4.x=221;
		p4.y=840;
		Point[] pp= {p1,p2,p3,p4};
		UiDevice.getInstance().swipe(pp,50);
	}
	public void testOrientation() throws RemoteException {
		UiDevice.getInstance().setOrientationLeft();
		UiDevice.getInstance().setOrientationRight();
		
		if (UiDevice.getInstance().isNaturalOrientation()) {//判断屏幕是否在自然放心
			UiDevice.getInstance().setOrientationLeft();//自然放向的话然后左转
		}
		int a=UiDevice.getInstance().getDisplayRotation();//返回当前的旋转角度
		if(a==Surface.ROTATION_0)//如果是0度需要做什么
		{}
		if(a==Surface.ROTATION_90)//如果是90度需要做什么
		{}
		
	}
	
	public void testWakeupAndsleep()  throws Exception{
		if (UiDevice.getInstance().isScreenOn()) {
			UiDevice.getInstance().sleep();			
		}
		if (!UiDevice.getInstance().isScreenOn()) {
			UiDevice.getInstance().wakeUp();
			
		}
		
	}
	
	public void testScreen() {
		UiDevice.getInstance().takeScreenshot(new File("/sdcard/test1.png"));
	}
	public  void testIdle() throws Exception {
		UiDevice.getInstance().click(950, 1800);
		UiDevice.getInstance().waitForIdle(20000);//如果是5s内完成窗口更新，则跳过，如果是20s后海还没打开，则报错
	}
	public void testGetPackage() throws Exception {
		String packageName=UiDevice.getInstance().getCurrentPackageName();
		System.out.println(packageName);
		
		UiDevice.getInstance().openNotification();//打开通知栏
		UiDevice.getInstance().openQuickSettings();//打开快速设置
		
		UiDevice.getInstance().dumpWindowHierarchy("notification.xml");//获取当前界面的布局
	}

}
