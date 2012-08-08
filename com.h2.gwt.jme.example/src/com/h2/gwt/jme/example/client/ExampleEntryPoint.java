package com.h2.gwt.jme.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.gwt.GwtAssetManager;
import com.jme3.asset.plugins.UrlLocator;
import com.jme3.font.plugins.BitmapFontLoader;
import com.jme3.material.Material;
import com.jme3.material.plugins.J3MLoader;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.shader.plugins.GLSLLoader;
import com.jme3.system.JmeSystem;
import com.jme3.system.gwt.JmeGwtSystem;

public class ExampleEntryPoint implements EntryPoint {

   ////
   ////

   public void onModuleLoad() {
//      RootPanel root = RootPanel.get("demo");
//      
//      Canvas webGLCanvas = Canvas.createIfSupported();
//      webGLCanvas.setCoordinateSpaceHeight(500);
//      webGLCanvas.setCoordinateSpaceWidth(500);
//      
//      root.add(webGLCanvas);
//      webGLCanvas.setFocus(true);
      
      SimpleApplication app = new SimpleApplication() {
         
         @SuppressWarnings("deprecation")
         public void initialize() {
            setAssetManager(new GwtAssetManager());
            
            //loaders
            assetManager.registerLoader(J3MLoader.class, "j3md");
            assetManager.registerLoader(BitmapFontLoader.class, "fnt");
            assetManager.registerLoader(GLSLLoader.class, "vert");
            assetManager.registerLoader(GLSLLoader.class, "frag");
            
            //locators
            assetManager.registerLocator(null, UrlLocator.class);
            
            super.initialize();
         }

         @Override
         public void simpleInitApp() {
            
//            /** A simple textured cube -- in good MIP map quality. */
            Box boxshape1 = new Box(new Vector3f(-3f,1.1f,0f), 1f,1f,1f);
            Geometry cube = new Geometry("My Textured Box", boxshape1);
            Material mat_stl = new Material(assetManager, "res/Common/MatDefs/Misc/Unshaded.j3md");
//            Texture tex_ml = assetManager.loadTexture("Interface/Logo/Monkey.jpg");
//            mat_stl.setTexture("ColorMap", tex_ml);
            cube.setMaterial(mat_stl);
            rootNode.attachChild(cube);
            
            /** A translucent/transparent texture, similar to a window frame. */
//            Box boxshape3 = new Box(new Vector3f(0f,0f,0f), 1f,1f,0.01f);
//            Geometry window_frame = new Geometry("window frame", boxshape3);
//            Material mat_tt = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//            mat_tt.setTexture("ColorMap", assetManager.loadTexture("Textures/ColoredTex/Monkey.png"));
//            mat_tt.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);  // activate transparency
//            window_frame.setQueueBucket(Bucket.Transparent);
//            window_frame.setMaterial(mat_tt);
//            rootNode.attachChild(window_frame);
         }
      };
      app.setShowSettings(false);
      
      
      JmeSystem.setSystemDelegate(new JmeGwtSystem());
      
      app.start();
   }
}
