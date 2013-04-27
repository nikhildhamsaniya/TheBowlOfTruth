package com.monyetmabuk.rajawali.tutorials;

import java.util.Random;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RajawaliLoadModelActivity extends RajawaliExampleActivity implements OnTouchListener, OnClickListener{
	private RajawaliLoadModelRenderer mRenderer;
	private Point mScreenSize;
	private Random generator = new Random();
	MediaPlayer mp;
	private LinearLayout mLinearLayout;
	Button btnChange;
	
	private String[] fortuneCookie = {	"Confucius says: Go to bed with itchy bum,\nwake up with stinky finger!",
										"A new pair of shoes will do you a world of good!",
										"The end is near...\nAnd it's your fault...",
										"Ignore all previous proverbs.",
										"You are not illiterate.",
										"Don't panic.",
										"Don't poke the bowl again or disaster will befall you!",
										"He who laughs last is slowest to get the joke.",
										"Man who lives in glass house should change clothes in basement.",
										"Man who run in front of car get tired.\nMan who run behind car get exhausted.",
										"Man who put head on railroad track get splitting headache.",
										"The answer is 42!",
										"You are wasting your time poking me...",
										"The last guy got all the good proverbs... Sorry.",
										"Never stop wondering.\nNever stop wandering.",
										"Don't look behind you...",
										"Man who poke bowl waste time...",
										"In order to have magical bodies\nWe must have magical minds.",
										"After Tuesday,\neven the calender goes W T F",
										"Sometimes you sits and thinks, mostly you just sits.",
										"Did you know the word bed is actually shaped like a bed...",
										"You will live a long life, as long as you keep poking this bowl...",
										"Would'nt it be ironic to die in the living room?",
										"Borrow money from pessimists, they don't expect it back.",
										"Boats and water are in your future.",
										"Your problems just got bigger, think what did you just do.",
										"Are your legs tired? You've been running through someones mind all day.",
										"Change is inevitable except for vending machines.",
										"I cannot help you for I am just a bowl.",
										"All grades are negotiable. Right?",
										"When you sqeeze an orange, orange juice comes out because that's what's inside."};
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRenderer = new RajawaliLoadModelRenderer(this);
        mRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mRenderer);
        
        mp= MediaPlayer.create(this, R.raw.gong);
        mSurfaceView.setOnTouchListener(this);
        
		Display display = getWindowManager().getDefaultDisplay();
		mScreenSize = new Point();
		mScreenSize.x = display.getWidth();
		mScreenSize.y = display.getHeight();
		
		mLinearLayout = new LinearLayout(this);
        mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        mLinearLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        mLinearLayout.setVisibility(LinearLayout.VISIBLE);
        
        btnChange = new Button(this);
        btnChange.setId(0);
        btnChange.setOnClickListener(this);
        btnChange.setText("Manualy");
        btnChange.setTextSize(10);
        mLinearLayout.addView(btnChange);
        
        mLayout.addView(mLinearLayout);
		
        initLoader();
    }
    
    public boolean onTouch(View v, MotionEvent event) {
    	
    	int randomIndex = generator.nextInt( fortuneCookie.length );
    	
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			mp.start();
			Toast.makeText(getApplicationContext(), fortuneCookie[randomIndex], Toast.LENGTH_LONG).show();
			
			mRenderer.setTouch(event.getX() / mScreenSize.x, 1.0f - (event.getY() / mScreenSize.y));
		}
		return super.onTouchEvent(event);
	}
    
    /************
	 * TOUCH FUNCTION - Should allow user to rotate the environment
	 **********/
	/*@Override public boolean onTouchEvent(MotionEvent e) {
		float x = e.getX();
		float y = e.getY();
		switch (e.getAction()) {
		case MotionEvent.ACTION_DOWN:			// one touch: drag
			Log.d("ShaderActivity", "mode=DRAG" );
			mode = DRAG;
			break;
		case MotionEvent.ACTION_UP:		// no mode
			mode = NONE;
			Log.d("ShaderActivity", "mode=NONE" );
			oldDist = 100.0f;
			break;
		case MotionEvent.ACTION_POINTER_UP:		// no mode
			mode = NONE;
			Log.d("ShaderActivity", "mode=NONE" );
			oldDist = 100.0f;
			break;
		case MotionEvent.ACTION_MOVE:						// rotation
			if (mode == DRAG){
				float dx = x - mPreviousX;
				float dy = y - mPreviousY;
				//mRenderer.mAngleX += dx * TOUCH_SCALE_FACTOR;
				//mRenderer.mAngleY += dy * TOUCH_SCALE_FACTOR;
				mGLSurfaceView.requestRender();
			}
			break;
		}
		mPreviousX = x;
		mPreviousY = y;
		return true;
	}*/
    
    public void onClick(View v) {
    	Toast.makeText(getApplicationContext(), "button", Toast.LENGTH_LONG).show();
    	if(this.btnChange.getText().toString().equalsIgnoreCase("Manualy")){
    		this.btnChange.setText("Automatic");	
    	}else{
    		this.btnChange.setText("Manualy");
    		
    	}
	}
    
    /********************************
	 * PROPERTIES
	 *********************************/

	private GLSurfaceView mGLSurfaceView;

	// rotation
	private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
	private float mPreviousX;
	private float mPreviousY;

	// shader constants
	private final int GOURAUD_SHADER = 0;
	private final int PHONG_SHADER = 1;
	private final int NORMALMAP_SHADER = 2;


	// object constants
	private final int OCTAHEDRON = 0;
	private final int TETRAHEDRON = 1;
	private final int CUBE = 2;

	// touch events
	private final int NONE = 0;
	private final int DRAG = 0;
	private final int ZOOM = 0;

	// pinch to zoom
	float oldDist = 100.0f;
	float newDist;

	int mode = 0;
    
    
    
}
