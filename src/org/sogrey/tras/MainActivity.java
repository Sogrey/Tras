/**
 * 
 */
package org.sogrey.tras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Administrator
 * 
 */
public class MainActivity extends Activity {

	Thread thread = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("main", "onCreate");
		setContentView(R.layout.activity_main);
		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, TopActivity.class);
				MainActivity.this.startActivity(intent);
				new Thread(new Runnable() {

					@Override
					public void run() {
						Message logMsg = handler.obtainMessage();
						try {
							Thread.sleep(3000);
							logMsg.what = 1000;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						logMsg.sendToTarget();
					}
				}).start();
			}
		});
	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			TopActivity.top.finish();
			Toast t = Toast.makeText(MainActivity.this, "Ê±¼äµ½¡£¡£¡£¡£", 1000);
			t.setGravity(Gravity.BOTTOM, 0, 0);
			t.show();
		}
	};

	@Override
	protected void onStart() {
		super.onStart();
		Log.i("main", "onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("main", "onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("main", "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i("main", "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("main", "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("main", "onDestroy");
	}

}
