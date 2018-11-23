package mx.edu.ittepic.dadm_u3_ejercicio4_arleyaquino;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo4 extends View {

    Main4Activity p4;
    Imagen4 puntero, desliza, entrar, mujer4, cmujer4,  regresar, mujer1, mujer2, mujer3, cmujer, cmujer2, cmujer3, margen4;

    public Lienzo4(Context context) {
        super(context);
        p4= (Main4Activity) context;
        margen4 = new Imagen4(R.drawable.margen3, 0,0, this);
        cmujer = new Imagen4(R.drawable.cvestido, 200,0, this);
        cmujer2 = new Imagen4(R.drawable.cvestido2, 200,0, this);
        cmujer3 = new Imagen4(R.drawable.cvestido3, 200,0, this);
        cmujer4 = new Imagen4(R.drawable.cvestido4, 200,0, this);
        mujer1 = new Imagen4(R.drawable.m11, 0,400, this);
        mujer2 = new Imagen4(R.drawable.m44, 5,700, this);
        mujer3= new Imagen4(R.drawable.m33, 0,1000, this);
        mujer4= new Imagen4(R.drawable.vestido4, 0,1300, this);
        puntero=null;
        regresar= new Imagen4(R.drawable.regresar, 270,1170, this);

    }
    protected void onDraw (Canvas c){
        super.onDraw(c);
        Paint p= new Paint();
        margen4.pintar(c,p);
        cmujer.pintar(c,p);
        if(puntero==mujer2)cmujer2.pintar(c,p);
        if(puntero==mujer3)cmujer3.pintar(c,p);
        if(puntero==mujer4)cmujer4.pintar(c,p);
        mujer1.pintar(c,p);
        mujer2.pintar(c,p);
        mujer3.pintar(c,p);
        mujer4.pintar(c,p);
        regresar.pintar(c,p);
    }
    public boolean onTouchEvent (MotionEvent e){
        float xp=e.getX();
        float yp=e.getY();

        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(mujer1.estaEnArea(xp,yp)){
                    cmujer.hacerVisible(true);
                    puntero =mujer1;
                }
                if(mujer2.estaEnArea(xp,yp)){
                    cmujer.hacerVisible(false);
                    puntero =mujer2;
                }
                if(mujer3.estaEnArea(xp,yp)){
                    cmujer.hacerVisible(false);
                    puntero =mujer3;
                }
                if(mujer4.estaEnArea(xp,yp)){
                    cmujer.hacerVisible(false);
                    puntero =mujer4;
                }
                if(regresar.estaEnArea(xp,yp)){
                    Intent otraVentana = new Intent(p4, MainActivity.class);
                    p4.startActivity(otraVentana);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(puntero==mujer1){
                    puntero.mover(xp, yp);
                    mujer2.mover(xp, yp+300);
                    mujer3.mover(xp, yp+600);
                    mujer4.mover(xp, yp+1000);
                }
                if(puntero==mujer2){
                    puntero.mover(xp, yp);
                    mujer1.mover(xp, yp-300);
                    mujer3.mover(xp, yp+300);
                    mujer4.mover(xp, yp+600);
                }
                if(puntero==mujer3){
                    puntero.mover(xp, yp);
                    mujer2.mover(xp, yp-300);
                    mujer1.mover(xp, yp-600);
                    mujer4.mover(xp, yp+300);
                }
                if(puntero==mujer4){
                    puntero.mover(xp, yp);
                    mujer2.mover(xp, yp-600);
                    mujer1.mover(xp, yp-900);
                    mujer3.mover(xp, yp-300);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }
}