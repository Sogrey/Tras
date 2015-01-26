/**
 * 
 */
package org.sogrey.tras;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Administrator
 *
 */
public class TopActivity extends Activity {
	public static TopActivity top;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top);
		top = this;
	}

}
