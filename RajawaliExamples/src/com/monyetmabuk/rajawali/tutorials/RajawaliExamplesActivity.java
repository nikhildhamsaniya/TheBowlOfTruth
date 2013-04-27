package com.monyetmabuk.rajawali.tutorials;

import ie.cathalcoffey.android.rajawali.tutorials.FragmentsExampleActivity;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.monyetmabuk.rajawali.tutorials.ui.ExamplesAdapter;

public class RajawaliExamplesActivity extends Activity {
	Button btnFindBowl;
	
	/*private ExampleItem[] mItems = { 
			new ExampleItem("01. Basic Example", RajawaliBasicExampleActivity.class),
			new ExampleItem("02. Load .obj model", RajawaliLoadModelActivity.class), 
			new ExampleItem("03. Materials", RajawaliMaterialsActivity.class),
			new ExampleItem("04. UI Elements", RajawaliUIElementsActivity.class),
			new ExampleItem("05. Skybox", RajawaliSkyboxActivity.class),
			new ExampleItem("06. Custom Material/Shader", RajawaliCustomShaderActivity.class), 
			new ExampleItem("07. 2D Renderer", Rajawali2DActivity.class),
			new ExampleItem("08. Using The Accelerometer", RajawaliAccelerometerActivity.class),
			new ExampleItem("09. Particles", RajawaliMoreParticlesActivity.class), 
			new ExampleItem("10. Object Picking", RajawaliObjectPickingActivity.class),
			new ExampleItem("11. Animation", RajawaliAnimationActivity.class), 
			new ExampleItem("12. Bump Mapping", RajawaliBumpmapActivity.class),
			new ExampleItem("13. Bezier Path Animation", RajawaliBezierActivity.class), 
			new ExampleItem("14. Toon Shading", RajawaliToonShadingActivity.class),
			new ExampleItem("15. MD2 Animation", RajawaliMD2Activity.class), 
			new ExampleItem("16. Post Processing", RajawaliPostProcessingActivity.class),
			new ExampleItem("17. Collision Detection", RajawaliCollisionDetectionActivity.class),
			new ExampleItem("18. Multiple Lights", RajawaliMultipleLightsActivity.class), 
			new ExampleItem("19. Lines", RajawaliLinesActivity.class),
			new ExampleItem("20. Catmull-Rom Splines", RajawaliCatmullRomActivity.class),
			new ExampleItem("21. 2000 Textured Planes", Rajawali2000PlanesActivity.class),
			new ExampleItem("22. Transparent GLSurfaceView", RajawaliTransparentSurfaceActivity.class),
			new ExampleItem("23. Animated Sprites", RajawaliAnimatedSpritesActivity.class), 
			new ExampleItem("24. Fog", RajawaliFogActivity.class),
			new ExampleItem("25. FBX Scene Importer", RajawaliFBXActivity.class),
			new ExampleItem("26. Custom Vertex Shader", RajawaliVertexShaderActivity.class),
			new ExampleItem("27. Touch Ripples Effect", RajawaliRipplesActivity.class), 
			new ExampleItem("28. Sphere Mapping", RajawaliSphereMapActivity.class),
			new ExampleItem("29. Chase Camera", RajawaliChaseCamActivity.class),
			new ExampleItem("30. Using Geometry Data", RajawaliUsingGeometryDataActivity.class),
			new ExampleItem("31. 360" + (char) 0x00B0 + " Images", Rajawali360ImagesActivity.class),
	        new ExampleItem("32. UI Fragments", FragmentsExampleActivity.class)};*/

	public void onCreate(Bundle savedInstanceState) {
	
		/*String[] strings = new String[mItems.length];
		for (int i = 0; i < mItems.length; i++) {
			strings[i] = mItems[i].title;
		}*/
		//List<String> list = Arrays.as.asList(strings);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//setListAdapter(new ExamplesAdapter(this, list));

		btnFindBowl = (Button) findViewById(R.id.button1);
		
		btnFindBowl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), RajawaliLoadModelActivity.class);
				startActivity(intent);
			}
		});
		
	}


	/*class ExampleItem {
		public String title;
		public Class<?> exampleClass;

		public ExampleItem(String title, Class<?> exampleClass) {
			this.title = title;
			this.exampleClass = exampleClass;
		}
	}*/
}