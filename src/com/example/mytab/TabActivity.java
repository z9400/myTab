package com.example.mytab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabActivity extends FragmentActivity {
	private FragmentTabHost mTabHost;
	
	private LayoutInflater layoutInflater ;
	
	private Class[] fragmentArray = {
			FragmentPage1.class,
			FragmentPage2.class,
			FragmentPage3.class,
			FragmentPage4.class,
			FragmentPage5.class
	} ;
	
	private int[] mImageArray = {
			R.drawable.btn_idle_home,
			R.drawable.btn_idle_classification,
			R.drawable.btn_idle_nearby,
			R.drawable.btn_idle_recommend,
			R.drawable.btn_idle_more
	} ;
	
	private String[] mTextArray  ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		
		mTextArray = getResources().getStringArray(R.array.nav_str) ;
		
		initView() ;
	}
	
	private void initView(){
		layoutInflater = LayoutInflater.from(this) ;
		
		mTabHost = (FragmentTabHost)findViewById(R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		
		for(int i=0,len = fragmentArray.length;i<len;i++){
			TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i]).setIndicator(getTabItemView(i)) ;
			mTabHost.addTab(tabSpec, fragmentArray[i], null);
			mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.sel_tab_bg);
		}
		
		
	}
	
	
	private View getTabItemView(int i){
		View view = layoutInflater.inflate(R.layout.tab_item_view, null) ;
		
		ImageView imageView = (ImageView)view.findViewById(R.id.imageview) ;
		imageView.setImageResource(mImageArray[i]);
		
		TextView textView = (TextView)view.findViewById(R.id.textview) ;
		textView.setText(mTextArray[i]);
		
		return view ;
	}
	
	
	

}
