package com.example.listviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
/**
 * 
 * @author xuelang www.gaotenglife.com
 *
 */
public class FirstActivity extends Activity {

	ListView listview = null;

	 private final String data[] = { "one", "two", "three", "four", "five", "six", "seven" }; 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		initHeadView();
	}
	private void initHeadView()
	{
		listview = (ListView)this.findViewById(R.id.list_view_first);	
		View view = LayoutInflater.from(this).inflate(R.layout.head_viewpager, null);
		ViewPager viewpager = (ViewPager)view.findViewById(R.id.headviewpager);		
		List<ImageView> listtemp = new ArrayList<ImageView>();
		for(int i = 0;i<4;i++)
		{
			ImageView img = new ImageView(this);
			img.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,100));
			img.setScaleType(ScaleType.FIT_XY);
			img.setBackgroundResource(R.drawable.ic_launcher);
			listtemp.add(img);
		}		
		ViewPageAdapter viewadapter = new ViewPageAdapter(listtemp);		
		listview.addHeaderView(view);
		listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data));
		viewpager.setAdapter(viewadapter);
	}
	
}
