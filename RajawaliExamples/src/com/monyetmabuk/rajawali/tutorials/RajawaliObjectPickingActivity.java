package com.monyetmabuk.rajawali.tutorials;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RajawaliObjectPickingActivity extends RajawaliExampleActivity implements OnTouchListener {
	private RajawaliObjectPickingRenderer mRenderer;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mRenderer = new RajawaliObjectPickingRenderer(this);
		mRenderer.setSurfaceView(mSurfaceView);
		super.setRenderer(mRenderer);
		mSurfaceView.setOnTouchListener(this);
		
		LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);

        TextView label = new TextView(this);
        label.setText("Press the Bowl of truth");
        label.setTextSize(20);
        label.setGravity(Gravity.CENTER);
        label.setHeight(100);
        ll.addView(label);
        
        mLayout.addView(ll);
		
		initLoader();
	}
	
	public boolean onTouch(View v, MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			mRenderer.getObjectAt(event.getX(), event.getY());
		}
		return super.onTouchEvent(event);
	}
}
