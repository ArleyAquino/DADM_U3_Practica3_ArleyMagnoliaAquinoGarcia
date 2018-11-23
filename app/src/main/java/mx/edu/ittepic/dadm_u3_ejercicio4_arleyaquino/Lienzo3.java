package mx.edu.ittepic.dadm_u3_ejercicio4_arleyaquino;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Main3Activity p3;
    Imagen3 margen2, regresar, czapatos, czapatos2, czapatos3, puntero, zapato1, zapato2, zapato3, zapato4, czapatos4;

    public Lienzo3(Context context)
    {
        super(context);
        p3= (Main3Activity) context;
        margen2 = new Imagen3(R.drawable.margen2, 0,0, this);
        czapatos = new Imagen3(R.drawable.czapatos, 200,0, this);
        czapatos2 = new Imagen3(R.drawable.czapatos2, 200,0, this);
        czapatos3 = new Imagen3(R.drawable.czapatos3, 200,0, this);
        czapatos4 = new Imagen3(R.drawable.czapatos4, 200,0, this);
        zapato1 = new Imagen3(R.drawable.zapatos1, 0,400, this);
        zapato2 = new Imagen3(R.drawable.zapatos2, 5,700, this);
        zapato3 = new Imagen3(R.drawable.zapatos3, 0,1000, this);
        zapato4 = new Imagen3(R.drawable.zapato4, 0,1300, this);
        puntero=null;
        regresar= new Imagen3(R.drawable.regresar, 270,1170, this);

    }
    protected void onDraw (Canvas c){
        super.onDraw(c);
        Paint p= new Paint();
        margen2.pintar(c,p);
        czapatos.pintar(c,p);
        if(puntero==zapato2)czapatos2.pintar(c,p);
        if(puntero==zapato3)czapatos3.pintar(c,p);
        if(puntero==zapato4)czapatos4.pintar(c,p);
        zapato1.pintar(c,p);
        zapato2.pintar(c,p);
        zapato3.pintar(c,p);
        zapato4.pintar(c,p);
        regresar.pintar(c,p);
    }
    public boolean onTouchEvent (MotionEvent e){
        float xp=e.getX();
        float yp=e.getY();

        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(zapato1.estaEnArea(xp,yp)){
                    czapatos.hacerVisible(true);
                    puntero =zapato1;
                }
                if(zapato2.estaEnArea(xp,yp)){
                    czapatos.hacerVisible(false);
                    puntero =zapato2;
                }
                if(zapato3.estaEnArea(xp,yp)){
                    czapatos.hacerVisible(false);
                    puntero =zapato3;
                }
                if(zapato4.estaEnArea(xp,yp)){
                    czapatos.hacerVisible(false);
                    puntero =zapato4;
                }
                if(regresar.estaEnArea(xp,yp)){
                    Intent otraVentana = new Intent(p3, MainActivity.class);
                    p3.startActivity(otraVentana);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(puntero==zapato1){
                    puntero.mover(xp, yp);
                    zapato2.mover(xp, yp+300);
                    zapato3.mover(xp, yp+600);
                    zapato4.mover(xp, yp+1000);
                }
                if(puntero==zapato2){
                    puntero.mover(xp, yp);
                    zapato1.mover(xp, yp-300);
                    zapato3.mover(xp, yp+300);
                    zapato4.mover(xp, yp+600);
                }
                if(puntero==zapato3){
                    puntero.mover(xp, yp);
                    zapato2.mover(xp, yp-300);
                    zapato1.mover(xp, yp-600);
                    zapato4.mover(xp, yp+300);
                }
                if(puntero==zapato4){
                    puntero.mover(xp, yp);
                    zapato2.mover(xp, yp-600);
                    zapato1.mover(xp, yp-900);
                    zapato3.mover(xp, yp-300);
                }

                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }
}
