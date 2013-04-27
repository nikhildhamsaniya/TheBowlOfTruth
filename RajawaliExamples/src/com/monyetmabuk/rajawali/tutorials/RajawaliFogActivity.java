package com.monyetmabuk.rajawali.tutorials;

import android.os.Bundle;

public class RajawaliFogActivity extends RajawaliExampleActivity {
	private RajawaliFogRenderer mRenderer;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mRenderer = new RajawaliFogRenderer(this);
		mRenderer.setSurfaceView(mSurfaceView);
		super.setRenderer(mRenderer);
		initLoader();
	}

}
