package com.monyetmabuk.rajawali.tutorials;

import java.io.ObjectInputStream;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import rajawali.BaseObject3D;
import rajawali.SerializedObject3D;
import rajawali.lights.PointLight;
import rajawali.materials.DiffuseMaterial;
import rajawali.renderer.RajawaliRenderer;
import rajawali.util.ObjectColorPicker;
import rajawali.util.OnObjectPickedListener;
import android.content.Context;

public class RajawaliObjectPickingRenderer extends RajawaliRenderer implements OnObjectPickedListener {
	private PointLight mLight;
	private BaseObject3D bowlIcon;
	private ObjectColorPicker mPicker;

	public RajawaliObjectPickingRenderer(Context context) {
		super(context);
		setFrameRate(60);
	}

	protected void initScene() {
		mPicker = new ObjectColorPicker(this);
		mPicker.setOnObjectPickedListener(this);
		mLight = new PointLight();
		mLight.setPosition(-2, 1, -4);
		mLight.setPower(1.5f);
		mCamera.setPosition(0, 0, -7);

		try {
			ObjectInputStream ois = new ObjectInputStream(mContext.getResources().openRawResource(R.raw.fire_truck_obj));//(R.raw.monkey_ser));
			SerializedObject3D serializedIcon = (SerializedObject3D) ois.readObject();
			ois.close();

			bowlIcon = new BaseObject3D(serializedIcon);
			bowlIcon.addLight(mLight);
			bowlIcon.setScale(.7f);
			bowlIcon.setPosition(-1, 1, 0);
			bowlIcon.setRotY(0);
			addChild(bowlIcon);
			
			/*
			mMonkey2 = bowlIcon.clone();
			mMonkey2.addLight(mLight);
			mMonkey2.setScale(.7f);
			mMonkey2.setPosition(1, 1, 0);
			mMonkey2.setRotY(45);
			addChild(mMonkey2);

			mMonkey3 = bowlIcon.clone();
			mMonkey3.addLight(mLight);
			mMonkey3.setScale(.7f);
			mMonkey3.setPosition(-1, -1, 0);
			mMonkey3.setRotY(90);
			addChild(mMonkey3);

			mMonkey4 = bowlIcon.clone();
			mMonkey4.addLight(mLight);
			mMonkey4.setScale(.7f);
			mMonkey4.setPosition(1, -1, 0);
			mMonkey4.setRotY(135);
			addChild(mMonkey4);
			*/

			mPicker.registerObject(bowlIcon);
			//mPicker.registerObject(mMonkey2);
			//mPicker.registerObject(mMonkey3);
			//mPicker.registerObject(mMonkey4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		DiffuseMaterial material = new DiffuseMaterial();
		material.setUseColor(true);
		
		bowlIcon.setMaterial(material);
		bowlIcon.setColor(0xff0000);
		/*
		mMonkey2.setMaterial(material);
		mMonkey2.setColor(0x00ff00);

		mMonkey3.setMaterial(material);
		mMonkey3.setColor(0xcc1100);

		mMonkey4.setMaterial(material);
		mMonkey4.setColor(0xff9955);
		*/
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		((RajawaliExampleActivity) mContext).showLoader();
		super.onSurfaceCreated(gl, config);
		((RajawaliExampleActivity) mContext).hideLoader();
	}

	public void onDrawFrame(GL10 glUnused) {
		super.onDrawFrame(glUnused);
		bowlIcon.setRotY(bowlIcon.getRotY() - 1f);
		//mMonkey2.setRotY(mMonkey2.getRotY() + 1f);
		//mMonkey3.setRotY(mMonkey3.getRotY() - 1f);
		//mMonkey4.setRotY(mMonkey4.getRotY() + 1f);
	}

	public void getObjectAt(float x, float y) {
		mPicker.getObjectAt(x, y);
	}

	public void onObjectPicked(BaseObject3D object) {
		object.setZ(object.getZ() == 0 ? 2 : 0);
	}
}
