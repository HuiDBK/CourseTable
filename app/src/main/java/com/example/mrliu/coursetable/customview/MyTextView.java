package com.example.mrliu.coursetable.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;


public class MyTextView extends android.support.v7.widget.AppCompatTextView {


    private int mViewWidth = 0;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private int mTranslate;
    private static int [] colors = {Color.BLUE, Color.GREEN, Color.RED};

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0,colors, null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            if (mGradientMatrix != null) {
                mTranslate += mViewWidth / 5;
                if (mTranslate > 2 * mViewWidth) {
                    mTranslate = -mViewWidth;
                }
                mGradientMatrix.setTranslate(mTranslate, 0);
                mLinearGradient.setLocalMatrix(mGradientMatrix);
                postInvalidateDelayed(100);
            }

    }
}
