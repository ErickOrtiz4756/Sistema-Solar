package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;


public class Main extends SimpleApplication {
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
   
    public double angulo, angulo2, angulo3, angulo4, angulo5, angulo6, anguloLuna= 0;
        Sphere sol = new Sphere(32, 32, 5f);
        Geometry geom = new Geometry("Sphere", sol);
        
        Sphere mercurio = new Sphere(32, 32, 0.5f);
        Geometry geom2 = new Geometry("Sphere", mercurio);
        
        Sphere venus = new Sphere(32, 32, 1f);
        Geometry geom3 = new Geometry("Sphere", venus);
        
        Sphere tierra = new Sphere(32, 32, 2.2f);
        Geometry geom4 = new Geometry("Sphere", tierra);
        
        Sphere marte = new Sphere(32, 32, 1.5f);
        Geometry geom5 = new Geometry("Sphere", marte);
        
        Sphere jupiter = new Sphere(32, 32, 4f);
        Geometry geom6 = new Geometry("Sphere", jupiter);
        
        Sphere luna = new Sphere(32, 32, 0.2f);
        Geometry geom7 = new Geometry("Moon", luna);
       
        Vector3f camera = new Vector3f(0f, 0f, 50f);
        
    @Override
    public void simpleInitApp() {
        
        flyCam.setEnabled(true);
        flyCam.setMoveSpeed(8f);
        cam.setLocation(camera);
        
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat3 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat4 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat5 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat6 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat7 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        mat.setColor("Color", ColorRGBA.Yellow);
        mat2.setColor("Color", ColorRGBA.Blue);
        mat3.setColor("Color", ColorRGBA.Red);
        mat4.setColor("Color", ColorRGBA.Green);
        mat5.setColor("Color", ColorRGBA.White);
        mat6.setColor("Color", ColorRGBA.Brown);
        mat7.setColor("Color", ColorRGBA.Gray);    
        
        geom.setMaterial(mat);
        geom2.setMaterial(mat2);
        geom3.setMaterial(mat3);
        geom4.setMaterial(mat4);
        geom5.setMaterial(mat5);
        geom6.setMaterial(mat6);
        geom7.setMaterial(mat7);

        rootNode.attachChild(geom);
        rootNode.attachChild(geom2);
        rootNode.attachChild(geom3);
        rootNode.attachChild(geom4);
        rootNode.attachChild(geom5);
        rootNode.attachChild(geom6);
        rootNode.attachChild(geom7);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        
        angulo = angulo + 0.05;
        angulo2 = angulo2 + 0.03;
        angulo3 = angulo3 + 0.01;
        angulo4 = angulo4 + 0.005;
        angulo5 = angulo5 + 0.003;
        anguloLuna += 0.05;
        
        float r = FastMath.DEG_TO_RAD;
        double Merc = FastMath.DEG_TO_RAD*angulo;
        double Ven = FastMath.DEG_TO_RAD*angulo2;
        double Tier = FastMath.DEG_TO_RAD*angulo3;
        double Marte = FastMath.DEG_TO_RAD*angulo4;
        double Jupi = FastMath.DEG_TO_RAD*angulo5;
        double Luna = FastMath.DEG_TO_RAD * anguloLuna;
        
        int rMer = 7;
        int rVenus = 12;
        int rTierra = 17;
        int rMarte = 22;
        int rJupiter = 32;
        int rLuna = 3;
        
        float xMer = (float) Math.sin(Merc)*rMer;
        float yMer = (float) Math.cos(Merc)*rMer;
        
        float xVenus = (float) Math.sin(Ven)*rVenus;
        float yVenus = (float) Math.cos(Ven)*rVenus;
        
        float xTierra = (float) Math.sin(Tier)*rTierra;
        float yTierra = (float) Math.cos(Tier)*rTierra;
        
        float xMarte = (float) Math.sin(Marte)*rMarte;
        float yMarte = (float) Math.cos(Marte)*rMarte;
        
        float xJupiter = (float) Math.sin(Jupi)*rJupiter;
        float yJupiter = (float) Math.cos(Jupi)*rJupiter;
        
        float xLuna = (float) Math.sin(Luna) * rLuna;
        float yLuna = (float) Math.cos(Luna) * rLuna;
  
        
        geom.rotate(r,0f,0f);
        geom2.rotate(r,0f,0f);
        geom3.rotate(r,0f,0f);
        geom4.rotate(r,0f,0f);
        geom5.rotate(r,0f,0f);
        geom6.rotate(r,0f,0f);
        
        
        Vector3f orbMercurio = new Vector3f (xMer , yMer, 0);
        Vector3f orbVenus = new Vector3f (xVenus , yVenus, 0);
        Vector3f orbTierra = new Vector3f (xTierra , yTierra, 0);
        Vector3f orbMarte = new Vector3f (xMarte , yMarte, 0);
        Vector3f orbJupiter = new Vector3f (xJupiter , yJupiter, 0);
        Vector3f orbLuna = new Vector3f(xLuna, yLuna, 0);
        
        geom2.setLocalTranslation(orbMercurio);
        geom3.setLocalTranslation(orbVenus);
        geom4.setLocalTranslation(orbTierra);
        geom5.setLocalTranslation(orbMarte);
        geom6.setLocalTranslation(orbJupiter);
        geom7.setLocalTranslation(orbLuna.add(geom4.getWorldTranslation()));
        
        }
    
    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
}