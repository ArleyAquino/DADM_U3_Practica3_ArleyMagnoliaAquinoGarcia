package mx.edu.ittepic.dadm_u3_ejercicio4_arleyaquino;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Main2Activity p2;
    Imagen2 margen1, regresar, cbebes, cbebes2, cbebes3, puntero, bebe1, bebe2, bebe3, bebe4, cbebes4;

    public Lienzo2(Context context)
    {
        super(context);
        p2= (Main2Activity) context;
        margen1 = new Imagen2(R.drawable.margenbebe, 0,0, this);
        cbebes = new Imagen2(R.drawable.cbebes, 200,0, this);
        cbebes2 = new Imagen2(R.drawable.cbebes2, 200,0, this);
        cbebes3 = new Imagen2(R.drawable.cbebes3, 200,0, this);
        cbebes4 = new Imagen2(R.drawable.cbebes4, 200,0, this);
        bebe1 = new Imagen2(R.drawable.bebe1, 0,400, this);
        bebe2 = new Imagen2(R.drawable.bebe2, 5,700, this);
        bebe3 = new Imagen2(R.drawable.bebe3, 0,1000, this);
        bebe4 = new Imagen2(R.drawable.bebe4, 0,1300, this);
        puntero=null;
        regresar= new Imagen2(R.drawable.regresar, 270,1170, this);

    }
    protected void onDraw (Canvas c){
        super.onDraw(c);
        Paint p= new Paint();
        margen1.pintar(c,p);
        cbebes.pintar(c,p);
        if(puntero==bebe2)cbebes2.pintar(c,p);
        if(puntero==bebe3)cbebes3.pintar(c,p);
        if(puntero==bebe4)cbebes4.pintar(c,p);
        bebe1.pintar(c,p);
        bebe2.pintar(c,p);
        bebe3.pintar(c,p);
        bebe4.pintar(c,p);
        regresar.pintar(c,p);
    }
    public boolean onTouchEvent (MotionEvent e){
        float xp=e.getX();
        float yp=e.getY();

        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(bebe1.estaEnArea(xp,yp)){
                    cbebes.hacerVisible(true);
                    puntero =bebe1;
                }
                if(bebe2.estaEnArea(xp,yp)){
                    cbebes.hacerVisible(false);
                    puntero =bebe2;
                }
                if(bebe3.estaEnArea(xp,yp)){
                    cbebes.hacerVisible(false);
                    puntero =bebe3;
                }
                if(bebe4.estaEnArea(xp,yp)){
                    cbebes.hacerVisible(false);
                    puntero =bebe4;
                }
                if(regresar.estaEnArea(xp,yp)){
                    Intent otraVentana = new Intent(p2, MainActivity.class);
                    p2.startActivity(otraVentana);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(puntero==bebe1){
                    puntero.mover(xp, yp);
                    bebe2.mover(xp, yp+300);
                    bebe3.mover(xp, yp+600);
                    bebe4.mover(xp, yp+1000);
                }
                if(puntero==bebe2){
                    puntero.mover(xp, yp);
                    bebe1.mover(xp, yp-300);
                    bebe3.mover(xp, yp+300);
                    bebe4.mover(xp, yp+600);
                }
                if(puntero==bebe3){
                    puntero.mover(xp, yp);
                    bebe2.mover(xp, yp-300);
                    bebe1.mover(xp, yp-600);
                    bebe4.mover(xp, yp+300);
                }
                if(puntero==bebe4){
                    puntero.mover(xp, yp);
                    bebe2.mover(xp, yp-600);
                    bebe1.mover(xp, yp-900);
                    bebe3.mover(xp, yp-300);
                }
               
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }
}
