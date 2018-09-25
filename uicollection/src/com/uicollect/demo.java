package com.uicollect;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class demo extends UiAutomatorTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void testDemo1() throws UiObjectNotFoundException {
		UiCollection collection=new UiCollection(new UiSelector().className("android.widget.listview"));//先找到大的集合
	    UiSelector childPattern=new UiSelector().className("android.widget.Textview");//收到所有的textview
		String text="Music";
	    UiObject music=collection.getChildByText(childPattern, text);//在collection类下寻找某一类（chilspattern）名字为text的组件
	}
	
	public void testDesc() throws Exception {
		UiCollection collection=new UiCollection(new UiSelector().resourceId(""));//通过资源id找到父类
		UiSelector childPattern=new UiSelector().className("android.widget.textview");
		int text=4;
	    UiObject forth=collection.getChildByDescription(childPattern, text);
	    forth.click();
	}
	public void testInstance() throws Exception {
		UiCollection collection=new UiCollection(new UiSelector().resourceId(""));//通过资源id找到父类
		UiSelector childPattern=new UiSelector().className("android.widget.FrameLayout");
		UiObject child1=collection.getChildByInstance(childPattern, 0);
		UiObject child0=collection.getChildByInstance(childPattern, 10);
		UiObject child00=collection.getChildByInstance(childPattern, 10);
		UiObject child8=collection.getChildByInstance(childPattern,7);
		UiObject child6=collection.getChildByInstance(childPattern, 5);
		
		child1.click();
		sleep(1000);
		child0.click();
		sleep(1000);
		child00.click();
		sleep(1000);
		child8.click();
		sleep(1000);
		child6.click();
		sleep(1000);
	}
	
	public void testCount() throws UiObjectNotFoundException {
		UiCollection collection=new UiCollection(new UiSelector().index(0));//出现第一个index为0的元素	
		int textViewCount=collection.getChildCount(new UiSelector().className("android.widget.Textview"));//递归查找子子孙孙所有的textview
		System.out.println("TextView count"+textViewCount);
		
		UiCollection tabecollection=new UiCollection(new UiSelector().className("android.widget.TableLayout"));
		int tablelayoutCount=tabecollection.getChildCount();//与上述getchild的区别,不加参数，是其直接子类，不包括子类以下的子类
		System.out.println(tablelayoutCount);
	}

}
