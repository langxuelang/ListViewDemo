package com.example.listviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
/**
 * 
 * @author gaoteng www.gaotenglife.com
 *
 */
public class SecondActivity extends Activity {

	ListView listview = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initViewPager();
	}

	private void initViewPager() {
		listview = (ListView)this.findViewById(R.id.list_view_second);
		ArrayList<String> mData = new ArrayList<String>();
		for(int i = 0;i<20;i++)
		{
			mData.add(""+i);
		}
		listview.setAdapter(new MyListViewAdatper(mData));
	}

	private class MyListViewAdatper extends BaseAdapter {

		LayoutInflater m_inflater = null;
		private ArrayList<String> mData = new ArrayList<String>(); 
		public MyListViewAdatper(ArrayList<String> Data)
		{
			m_inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mData = Data;
		}
		 
		@Override
		public int getItemViewType(int position) {
			// TODO Auto-generated method stub
			return position>0?0:1;
		}

		@Override
		public int getViewTypeCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mData.get(position);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			 View view = null;
			 if(getItemViewType(position) == 0)//
			 {
				ViewHolder holder = null;  
				
				 if(convertView==null)
				 {
					
						 view = m_inflater.inflate(R.layout.list_item, null);
						 holder = new ViewHolder();
						 holder.textView = (TextView)view.findViewById(R.id.list_item);
						 view.setTag(holder);
				 }				
				 else
				 {
					 view  = convertView;
					 holder = (ViewHolder)view.getTag();
				 }
				 holder.textView.setText(position+"");
			}
			else if(getItemViewType(position) == 1)//如果是顶部viewpager
			 {
				ViewPagerHolder holder = null;  
				 if(convertView==null)
				 {
					 view = m_inflater.inflate(R.layout.head_viewpager, null);
					 holder = new ViewPagerHolder();
					 holder.viewPager = (ViewPager)view.findViewById(R.id.headviewpager);
					 
					 
					 List<ImageView> listtemp = new ArrayList<ImageView>();
					 for(int i = 0;i<4;i++)
					 {
						ImageView img = new ImageView(SecondActivity.this);
						img.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,100));
						img.setScaleType(ScaleType.FIT_XY);
						img.setBackgroundResource(R.drawable.ic_launcher);
						listtemp.add(img);
					 }
						
					ViewPageAdapter viewadapter = new ViewPageAdapter(listtemp);
					holder.viewPager.setAdapter(viewadapter);

					 view.setTag(holder);
				 }
				 else
				 {
					 view  = convertView;
					 holder = (ViewPagerHolder)view.getTag();
				 }				 
			 }
			
			return view;
		}

	}
	public static class ViewHolder {  
        public TextView textView;  
	} 
	public static class ViewPagerHolder{
		public ViewPager viewPager;
	}

}
