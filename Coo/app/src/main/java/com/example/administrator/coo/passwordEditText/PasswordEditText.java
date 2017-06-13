package com.example.administrator.coo.passwordEditText;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.example.administrator.coo.R;

/**
 * Created by zhanglei on 2017/6/9.
 * 仿支付保密码输入框
 */

public class PasswordEditText extends AppCompatEditText {


    /**
     * 输入格子的数量
     */
    private int defultCount = 6;

    /**
     * 用来画背景的画笔
     */
    private Paint bgPaint = new Paint();

    /**
     * 用来画内容块的画笔
     */
    private Paint rectPaint = new Paint();

    /**
     * 密码的长度
     */
    private int textLength = 0;

    /**
     * 分割线的宽度
     */
    private float linesWidth = 0;

    /**
     * 边框的宽度
     */
    private float borderWidth = 0;

    /**
     * 边框的颜色
     */
    private int borderColor = 0xFFCCCCCC;

    /**
     * 分割线的颜色
     */
    private int linesColor = 0xFFCCCCCC;

    /**
     * 密码圆点的半径
     */
    private int circleRadius;

    /**
     * 内容块底色
     */
    private int chunkColor = Color.WHITE;

    public PasswordEditText(Context context) {
        super(context);
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PasswordEditText, 0, 0);
        defultCount = a.getInteger(R.styleable.PasswordEditText_pe_count, defultCount);
        borderWidth = a.getDimension(R.styleable.PasswordEditText_pe_lineWidth, linesWidth);
        linesWidth = a.getDimension(R.styleable.PasswordEditText_pe_cuttingLineWidth, borderWidth);
        borderColor = a.getColor(R.styleable.PasswordEditText_pe_lineColor, this.borderColor);
        linesColor = a.getColor(R.styleable.PasswordEditText_pe_cuttingLineColor, linesColor);
        chunkColor = a.getColor(R.styleable.PasswordEditText_pe_chunkColor, chunkColor);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获取控件的宽
        int width = getWidth();
        //获取控件的高
        int height = getHeight();
        linesWidth = getLinesWidth() - 3;
        borderWidth = getLinesWidth() - 1;

        //画背景
        RectF bgRect = new RectF(0, 0, width, height);
        //设置背景的颜色
        bgPaint.setColor(borderColor);
        canvas.drawRect(bgRect, bgPaint);

        //画内容区
        RectF contentRect = new RectF(bgRect.left + borderWidth, bgRect.top + borderWidth, bgRect.right - borderWidth, bgRect.bottom - borderWidth);
        rectPaint.setColor(chunkColor);
        canvas.drawRect(contentRect, rectPaint);

        //画分割线
        bgPaint.setStrokeWidth(linesWidth);
        bgPaint.setColor(linesColor);
        for (int i = 0; i < defultCount; i++) {
            float x = width / defultCount * i;
            canvas.drawLine(x, borderWidth, x, height - borderWidth, bgPaint);
        }

        if (textLength > 0) {
            //画密码
            int j = getWidth() / defultCount / 2;
            for (int i = 0; i < textLength; i++) {
                int cx = width / defultCount * i + j;
                circleRadius = height / 6;
                canvas.drawCircle(cx, getHeight() / 2, circleRadius, bgPaint);
            }
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        textLength = text.toString().length();
        invalidate();
        if (textLength == defultCount) {
            if (onInputFinishListener != null) {
                onInputFinishListener.inputFinish(text.toString());
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private float getLinesWidth() {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
        //获取控件左边的margin值
        int leftMargin = lp.leftMargin;
        //获取控件右边的margin值
        int rightMargin = lp.rightMargin;
        //边框及分割线的宽度
        return (leftMargin + rightMargin + getWidth()) / 200;
    }

    private OnInputFinishListener onInputFinishListener;

    public void setOnInputFinishListener(OnInputFinishListener onInputFinishListener) {
        this.onInputFinishListener = onInputFinishListener;
    }

    public interface OnInputFinishListener {
        void inputFinish(String text);
    }
}
