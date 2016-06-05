package com.ncepu.mobilesafe.activity;

import com.ncepu.mobilesafe.R;

import android.R.bool;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
/**
 * 第四个引导页面
 * @author BRUCE
 *
 */
public class Setup4Activity extends BaseSetupActivity {
	
	private CheckBox cbBox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setup4_activity);
		cbBox = (CheckBox) findViewById(R.id.cb_checkbox);
		boolean pro =  mPref.getBoolean("protect", true);
		//重新进入如页面时候显示之前设置的
		if(pro){
			cbBox.setText("防盗保护已经开启！");
			cbBox.setChecked(true);//设置显示为打勾上了
			mPref.edit().putBoolean("protect", true).commit();//将信息保存到sharePerfence中否则虽然显示默认打勾，但是在服务中获取不到信息
		}else {
			cbBox.setText("防盗保护已经关闭！");
			cbBox.setChecked(false);
		}
		//点击checkbox触发这个方法。
		cbBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked) {
					cbBox.setText("防盗保护已经开启！");
					mPref.edit().putBoolean("protect", true).commit();
				}else {
					cbBox.setText("防盗保护已经关闭！");
					mPref.edit().putBoolean("protect", false).commit();
				}
			}
		});
	}
//	public void next(View v) {
//		startActivity( new Intent(this,LostFindActivity.class));
//		finish();
//		mPreferences.edit().putBoolean("configed", true).commit();
//	}
//	public void previous(View v) {
//		startActivity( new Intent(this,Setup3Activity.class));
//		finish();
//		
//		overridePendingTransition(R.anim.tran_previous_in, R.anim.tran_previous_out);
//	}
	@Override
	public void showPreviousPage() {
		startActivity( new Intent(this,Setup3Activity.class));
		finish();
		
		overridePendingTransition(R.anim.tran_previous_in, R.anim.tran_previous_out);
		
	}
	@Override
	public void showNextPage() {
		startActivity( new Intent(this,LostFindActivity.class));
		finish();
		mPref.edit().putBoolean("configed", true).commit();	
	}
}
