package com.example.dazongtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by xiaoqinchen on 2017/3/9.
 */

public class SlideBar extends View {
    private String[] mLetter = new String[]{"A","B","C","D","E","F","G","H","I","J","K",
                                      "L","M","N","O","P","Q","R","S","T","U","V","W","X",
                                       "Y","Z"};
    private OnSlideBarMoveListener mListener = null;

    public SlideBar(Context context) {
        super(context);
    }

    public SlideBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int _witdh = getWidth();
        int _height = getHeight();
        int _letterHeight = _height/mLetter.length;

        Paint _paint = new Paint();
        _paint.setColor(Color.BLACK);
        _paint.setTextSize(20);
        _paint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        for (int i=0; i<mLetter.length; i++) {
            float _x = _witdh/2-_paint.getStrokeWidth()/2;
            float _y = _letterHeight*(i+1);
            canvas.drawText(mLetter[i],_x,_y,_paint);
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_UP){
            setBackgroundColor(Color.GRAY);
        }else{
            String _letter = "A";
//            int x = event.
//            int y = event
            if (mListener!=null){
                mListener.onSlideBarMoving(_letter);
            }
        }
        return true;
    }

    public void setOnSlideBarMoveListener(OnSlideBarMoveListener pListener){
        mListener = pListener;
    }

    public interface OnSlideBarMoveListener{
        public void onSlideBarMoving(String pLetter);
    }
}
