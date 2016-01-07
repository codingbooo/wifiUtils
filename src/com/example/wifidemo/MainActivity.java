package com.example.wifidemo;

import com.smart.common.wifiComm.WifiListener;
import com.smart.common.wifiComm.WifiUtils;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button bt_close;
	private Button bt_open;
	private WifiUtils wifiUtils;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt_close = (Button) findViewById(R.id.bt_close);
		bt_open = (Button) findViewById(R.id.bt_open);
		wifiUtils = new WifiUtils(this);
		
		Log.d("haha", "GetMacAddress:" + wifiUtils.GetMacAddress());
		Log.d("haha", "GetBSSID:" + wifiUtils.GetBSSID());
		Log.d("haha", "GetIPAddress:" + wifiUtils.GetIPAddress());
		Log.d("haha", "GetNetworkId:" + wifiUtils.GetNetworkId());
		Log.d("haha", "GetWifiInfo:" + wifiUtils.GetWifiInfo());
		
		
		bt_close.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				wifiUtils.CloseWifi();
			}
		});
		bt_open.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wifiUtils.OpenWifi();
			}
		});
		
		regist();
	}

	private void regist() {
		
		wifiUtils.register(new WifiListener() {
			
			@Override
			public void wifiOpen() {
				Log.i("haha", "wifiOpen");
			}
			
			@Override
			public void wifiNotConnect(NetworkInfo networkInfo) {
				Log.i("haha", "wifiNotConnect");
			}
			
			@Override
			public void wifiConnected(NetworkInfo networkInfo) {
				Log.i("haha", "wifiConnected");
			}
			
			@Override
			public void wifiClose() {
				Log.i("haha", "wifiClose");
			}
			
			@Override
			public void notConnected() {
				Log.i("haha", "notConnected");
			}
			
			@Override
			public void connected(ConnectivityManager manager, NetworkInfo networkInfo) {
				Log.i("haha", "connected");
				
			}
		});
	}

}
