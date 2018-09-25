package com.uiwatcher;

import javax.xml.soap.Text;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class demo extends UiAutomatorTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void testWatcher() throws UiObjectNotFoundException {
		//先要注册监听器
		UiDevice.getInstance().registerWatcher("phone", new UiWatcher() {
			
			@Override
			public boolean checkForCondition() {
				// TODO Auto-generated method stub
				UiObject call=new UiObject(new UiSelector().text("来电"));
				UiObject view=new UiObject(new UiSelector().className("android.view.View"));
				if (call.exists()) {
					System.out.println("电话监听器被触发了！！");
					try {
						view.swipeLeft(20)	;
						return true;
					} catch (UiObjectNotFoundException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}
				return false;
			}
		});
		
		//如果用例执行中间来了电话 会使用监听器来处理一下挂断电话 然后继续执行
		
		//然后执行测试用例
		UiObject vol=new UiObject(new UiSelector().className("android.widget.LinearLayout").index(4))
				.getChild(new UiSelector().text("声音"));
		UiObject back=new UiObject(new UiSelector().description("向上导航"));
		
		for(int i=0;i<20;i++) {
		   System.out.println("当前循环"+i);
		   vol.clickAndWaitForNewWindow();
		   sleep(2000);
		   back.clickAndWaitForNewWindow();
		   sleep(2000);
		}
	}

}
