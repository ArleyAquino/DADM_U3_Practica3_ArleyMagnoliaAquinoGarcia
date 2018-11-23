package mx.edu.ittepic.dadm_u3_ejercicio4_arleyaquino;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Bitmap portada1;
    MainActivity p1;
    Imagen puntero, desliza, entrar, c1, mensaje1, mensaje2, mensaje3, mensaje4, c2, c3, c4;

    public Lienzo(Context context) {
        super(context);
        p1 = (MainActivity) context;
        puntero=null;
        entrar = new Imagen(R.drawable.botonentrar, 650,1000, this);
        c1 = new Imagen(R.drawable.bebe, 0,600, this);
        mensaje1 = new Imagen(R.drawable.mensaje1, 50,910, this);
        c2 = new Imagen(R.drawable.zapatos, 300,600, this);
        mensaje2 = new Imagen(R.drawable.mensaje2, 50,910, this);
        c3 = new Imagen(R.drawable.mujer, 660,600, this);
        mensaje3 = new Imagen(R.drawable.mensaje3, 50,910, this);
        c4 = new Imagen(R.drawable.basicos, 950,600, this);
        mensaje4 = new Imagen(R.drawable.mensaje4, 50,910, this);
        desliza = new Imagen(R.drawable.desliza, 5,605, this);
    }
    protected void onDraw (Canvas c) {
        Paint p = new Paint();
        portada1 = BitmapFactory.decodeResource(getResources(), R.drawable.portada1);

        c.drawBitmap(portada1, 1, 20, p);
        c1.pintar(c,p);
        c2.pintar(c,p);
        c3.pintar(c,p);
        c4.pintar(c,p);
        entrar.pintar(c,p);
        //desliza.pintar(c,p);
        if(puntero==c1)mensaje1.pintar(c,p);
        if(puntero==c2)mensaje2.pintar(c,p);
        if(puntero==c3)mensaje3.pintar(c,p);
        if(puntero==c4)mensaje4.pintar(c,p);
    }

    public boolean onTouchEvent (MotionEvent e){
        float xp=e.getX();
        float yp=e.getY();

        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(entrar.estaEnArea(xp,yp)){
                    if(puntero==c1){
                        Intent otraVentana = new Intent(p1, Main2Activity.class);
                        p1.startActivity(otraVentana);
                    }
                    if(puntero==c2){
                        Intent otraVentana = new Intent(p1, Main3Activity.class);
                        p1.startActivity(otraVentana);
                    }
                    if(puntero==c3){
                        Intent otraVentana = new Intent(p1, Main4Activity.class);
                        p1.startActivity(otraVentana);
                    }
                    if(puntero==c4){
                        Intent otraVentana = new Intent(p1, Main5Activity.class);
                        p1.startActivity(otraVentana);
                    }

                }
                if(c1.estaEnArea(xp,yp)){
                    puntero=c1;
                }
                if(c2.estaEnArea(xp,yp)){
                    puntero=c2;
                }
                if(c3.estaEnArea(xp,yp)){
                    puntero=c3;
                }
                if(c4.estaEnArea(xp,yp)){
                    puntero=c4;
                }
                break;
            case MotionEvent.ACTION_MOVE:

                if(puntero!=null){
                if(puntero==c1){
                    puntero.mover(xp, yp);
                    c2.mover(xp+300, yp);
                    c3.mover(xp+650, yp);
                    c4.mover(xp+950, yp);
                }
                if(puntero==c2){
                    puntero.mover(xp, yp);
                    c1.mover(xp-300, yp);
                    c3.mover(xp+350, yp);
                    c4.mover(xp+650, yp);
                }
                if(puntero==c3){
                    puntero.mover(xp, yp);
                    c2.mover(xp-350, yp);
                    c1.mover(xp-600, yp);
                    c4.mover(xp+300, yp);
                }
                if(puntero==c4){
                    puntero.mover(xp, yp);
                    c2.mover(xp-650, yp);
                    c1.mover(xp-950, yp);
                    c3.mover(xp-300, yp);
                }
            }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }
}
