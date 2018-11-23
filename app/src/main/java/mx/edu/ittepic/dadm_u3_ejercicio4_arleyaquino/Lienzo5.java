package mx.edu.ittepic.dadm_u3_ejercicio4_arleyaquino;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo5 extends View {
    Main5Activity p5;
    Imagen5  regresar, cbasicos, cbasicos2, cbasicos3, cbasicos4, basicos4, basicos1, basicos2, basicos3, puntero, margen5;

    public Lienzo5(Context context) {
        super(context);
        p5 = (Main5Activity) context;
        margen5 = new Imagen5(R.drawable.margen4, 0, 0, this);
        cbasicos = new Imagen5(R.drawable.cbasicos, 200, 0, this);
        cbasicos2= new Imagen5(R.drawable.cbasicos2,200, 0, this);
        cbasicos3= new Imagen5(R.drawable.cbasicos3, 200, 0, this);
        cbasicos4= new Imagen5(R.drawable.cbasicos4, 200, 0, this);
        basicos1= new Imagen5(R.drawable.basicos1, 0, 400, this);
        basicos2 = new Imagen5(R.drawable.basicos2, 5, 700, this);
        basicos3 = new Imagen5(R.drawable.basicos3, 0, 1000, this);
        basicos4 = new Imagen5(R.drawable.basicos4, 0, 1300, this);
        puntero = null;
        regresar = new Imagen5(R.drawable.regresar, 270, 1170, this);

    }

    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();
        margen5.pintar(c, p);
        cbasicos.pintar(c, p);
        if (puntero == basicos2) cbasicos2.pintar(c, p);
        if (puntero == basicos3) cbasicos3.pintar(c, p);
        if (puntero == basicos4) cbasicos4.pintar(c, p);
        basicos1.pintar(c, p);
        basicos2.pintar(c, p);
        basicos3.pintar(c, p);
        basicos4.pintar(c, p);
        regresar.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (basicos1.estaEnArea(xp, yp)) {
                    cbasicos.hacerVisible(true);
                    puntero = basicos1;
                }
                if (basicos2.estaEnArea(xp, yp)) {
                    cbasicos.hacerVisible(false);
                    puntero = basicos2;
                }
                if (basicos3.estaEnArea(xp, yp)) {
                    cbasicos.hacerVisible(false);
                    puntero = basicos3;
                }
                if (basicos4.estaEnArea(xp, yp)) {
                    cbasicos.hacerVisible(false);
                    puntero = basicos4;
                }
                if (regresar.estaEnArea(xp, yp)) {
                    Intent otraVentana = new Intent(p5, MainActivity.class);
                    p5.startActivity(otraVentana);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(puntero==basicos1){
                    puntero.mover(xp, yp);
                    basicos2.mover(xp, yp+300);
                    basicos3.mover(xp, yp+600);
                    basicos4.mover(xp, yp+1000);
                }
                if(puntero==basicos2){
                    puntero.mover(xp, yp);
                    basicos1.mover(xp, yp-300);
                    basicos3.mover(xp, yp+300);
                    basicos4.mover(xp, yp+600);
                }
                if(puntero==basicos3){
                    puntero.mover(xp, yp);
                    basicos2.mover(xp, yp-300);
                    basicos1.mover(xp, yp-600);
                    basicos4.mover(xp, yp+300);
                }
                if(puntero==basicos4){
                    puntero.mover(xp, yp);
                    basicos2.mover(xp, yp-600);
                    basicos1.mover(xp, yp-900);
                    basicos3.mover(xp, yp-300);
                }

                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }
}