package com.example.gamespaceelena;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {
    // Dibujar en pantala
    private Bitmap spaceship;
    private Bitmap invader;
    private Paint paint;
    public int spaceshipX = 100;
    public int spaceshipY = 800;

    public GameView(Context context) {
        super(context);
        init();
    }

    private void init() {
        // Escalamos la spaceship
        Bitmap originalSpaceship = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
        spaceship = Bitmap.createScaledBitmap(originalSpaceship, 150, 100, true);
        Bitmap originalInvader = BitmapFactory.decodeResource(getResources(), R.drawable.aliensinfondo);
        invader = Bitmap.createScaledBitmap(originalInvader, 80, 80, true);

        paint = new Paint();
    }

    // Porque protected
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(spaceship,spaceshipX,spaceshipY,paint);
        // Draw space ship
        int spaceshipX = (getWidth() - spaceship.getWidth()) / 2;
        int spaceshipY = (getHeight() - spaceship.getHeight()) / 2;

        int invaderWidth = invader.getWidth();
        int invaderHeight = invader.getHeight();
        int startX = 50;
        int startY = 50;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                int x = startX + col * (invaderWidth + 20);
                int y = startY + col * (invaderHeight + 20);
                canvas.drawBitmap(invader, x, y, paint);
            }
        }
    }
    // case sensitve
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                spaceshipX = (int) event.getX();
                spaceshipY = (int) event.getY();
                invalidate();
                break;
        }
        return true;
    }

}
