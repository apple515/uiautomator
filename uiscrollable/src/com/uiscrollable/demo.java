package com.uiscrollable;

import javax.net.ssl.SSLException;
import javax.swing.tree.ExpandVetoException;
import javax.xml.soap.Text;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.text.style.ClickableSpan;

public class demo extends UiAutomatorTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void testFling() throws UiObjectNotFoundException {
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));
		scroll.flingBackward();//往后滚
		scroll.flingForward();
		scroll.flingToBeginning(10);
		scroll.flingToEnd(20);
	}
	public void testScroll() throws Exception {
		//联系人列表的滚动查询
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));//联系人列表的滚动查询	
		
		UiObject baqiang=scroll.getChildByText(new UiSelector().className("android.widget.TextView"), "白墙", true);
		baqiang.click();
		
		//只找当前界面的 不进行滚动
		UiObject fifith=scroll.getChildByInstance(new UiSelector().className("android.widget.TextView"), 5);//找到当前界面的第5个
	     fifith.click();
	}
	public void testSwipCount() throws UiObjectNotFoundException {
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.listvew"));
		UiObject textview=new UiObject(new UiSelector().text("张三"));
		scroll.scrollIntoView(textview);//滚动到这个对象
		textview.click();
	}
	public void testDeadZone() throws Exception {
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.listview"));
		double deadzone=scroll.getSwipeDeadZonePercentage();
		System.out.println("不滑动区域"+deadzone);
		scroll.setSwipeDeadZonePercentage(0.10);
		scroll.scrollForward();
		scroll.scrollBackward();
	}
	public void testScrollForward() throws Exception {
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.listview"));
		scroll.scrollForward(5);
		scroll.scrollBackward();
	}
	public void testScrollIntoView () throws UiObjectNotFoundException {
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.listview"));
		UiSelector selector=new UiSelector().text("白蕾");
		UiObject object=new UiObject(selector);
		//scroll.scrollIntoView(selector);//一直往下滚，直到找到对象
		//scroll.scrollIntoView(object);//与上述效果一样
		scroll.scrollDescriptionIntoView("白蕾的快速联系人照片");//与上述效果一致
		
		scroll.scrollToBeginning(50,5);
		scroll.scrollToEnd(50,5);//后面的5是步长
	}
	public void testVertical() throws UiObjectNotFoundException {
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.support.v4.view.ViewPage"));
        scroll.setAsHorizontalList();
        scroll.scrollBackward();
        sleep(2000);
        scroll.scrollForward();
        sleep(2000);
        scroll.setAsVerticalList();
        scroll.scrollForward();
	}

}
