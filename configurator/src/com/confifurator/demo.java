package com.confifurator;

import java.security.URIParameter;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class demo extends UiAutomatorTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void testAction() {
		long actionTime=Configurator.getInstance().getActionAcknowledgmentTimeout();
	    System.out.println("默认动作延时"+actionTime);
	    int y=UiDevice.getInstance().getDisplayHeight();
	    int x=UiDevice.getInstance().getDisplayWidth();
	    UiDevice.getInstance().swipe(x-10, y/2, 50, y/2, 10);//步长改变的是两个点的滑动速度
	    UiDevice.getInstance().swipe(x-10, y/2, 50, y/2, 10);//configurator改变的是两次滑动的时间间隔
	    Configurator.getInstance().setActionAcknowledgmentTimeout(1);//
	    sleep(2000);
	    
	    UiDevice.getInstance().swipe(x-10, y/2, 50, y/2, 10);
	    UiDevice.getInstance().swipe(x-10, y/2, 50, y/2, 10);
	    
	    //改完之后运行结束记得要改回去 有特殊需求的时候才需要改
	    Configurator.getInstance().setActionAcknowledgmentTimeout(actionTime);//
	    
	}
	
	//改变键盘的输入速度
    public void testKey() throws UiObjectNotFoundException {
    	UiObject edit1=new UiObject(new UiSelector().focused(true));
    	edit1.setText("erererere");
    	sleep(2000);
    	Configurator.getInstance().setKeyInjectionDelay(1000);//键盘改速度1s
    	edit1.setText("yuyuyuyu");

	}
    
    public void testScroll() throws UiObjectNotFoundException {
    	UiScrollable view=new UiScrollable(new UiSelector().className("android.widget.View"));	
    	view.flingToBeginning(10);
    	sleep(2000);
    	Configurator.getInstance().setScrollAcknowledgmentTimeout(2000);
    	
    	view.flingToEnd(10);
	}
    
    public void testSelector() throws UiObjectNotFoundException {
    	UiObject edit=new UiObject(new UiSelector().text("afad"));//随意写一个对象
    	Configurator.getInstance().setActionAcknowledgmentTimeout(20000);
    	edit.click();//20s之后没找到就跑出异常
    	
	}
    
    public void testQuicklyClick() {
    	int x=UiDevice.getInstance().getDisplayHeight();
    	int y=UiDevice.getInstance().getDisplayWidth();
    	quicklyClick(4, x/2, y/2);
    	sleep(3000);
    	quicklyClick(24, x/2, y/2);
	}
  
    public void testSetText() {
    	setTextForKeycode("58ert");	
    	sleep(2000);
	}
    
    /**
      * 需求，实现一个快速多次点击功能的API
     * @param num
     * @param x
     * @param y
     */
  public void quicklyClick(int num, int x, int y) {
	  long actionTimeout=Configurator.getInstance().getActionAcknowledgmentTimeout();
	  Configurator.getInstance().setActionAcknowledgmentTimeout(0);
	  for(int i=0;i<num;i++)
	  {
		  UiDevice.getInstance().click(x, y);
	  }
	  Configurator.getInstance().setActionAcknowledgmentTimeout(actionTimeout);
	
}
 /*
  * 使用keycode输入自定义
  */
  
  public void setTextForKeycode(String input) {
	  
	  long actionTimeout=Configurator.getInstance().getActionAcknowledgmentTimeout();
	  Configurator.getInstance().setActionAcknowledgmentTimeout(0);
	  
	  for(int i=0;i<input.length();i++)
	  {
		  char c=input.charAt(i);
		  if (c>=48&&i<=57) {//ascii码这个段是数字
			  //转换成对应的keycode 查看keycode和asciii码的对应关系即可算出差值
			  UiDevice.getInstance().pressKeyCode(c-41);//keycode里和ascii码的对应关系是7-48(针对数字0)	
		}
		  else if (c>97 && c<=122) {
			  UiDevice.getInstance().pressKeyCode(c-68);
		}else if (c>=65 && c<=90) {
			UiDevice.getInstance().pressKeyCode(c-36,1);
			
		}
	  }  
	  
	  Configurator.getInstance().setActionAcknowledgmentTimeout(actionTimeout);
}    

}
