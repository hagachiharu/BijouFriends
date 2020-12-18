package jp.ac.shohoku.bijoufriends;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 一つのActivityで画面遷移する。(テキストP.53の1のやり方)
 * MainView→BijouViewに変更
 */
public class BijouView extends View {
    public final int FIRST = 1;  // 状態を表す定数1
    public final int SECOND = 2;  // 状態を表す定数2
    public final int THIRD = 3;  // 状態を表す定数3

    int state;  // 状態を表す変数


    public BijouView(Context context) {

        super(context);
        state = FIRST; // 初めは状態1
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint p = new Paint();

        if(state == FIRST) {  // 状態1の場合の描画
            Resources rs = this.getContext().getResources(); //リソースを取得
            Bitmap bmp = BitmapFactory.decodeResource(rs, R.drawable.bijyou); //画像を取得
            canvas.drawBitmap(bmp, 0, 0, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        }
        else if (state == SECOND) {  // 状態2の場合の描画

        }
        else if (state == THIRD) {  // 状態3の場合の描画

        }
        else {
            Log.d("error", "never come here");
        }
    }


    public boolean onTouchEvent(MotionEvent event){
        int x = (int) event.getX();  // タップされた位置を取得
        int y = (int) event.getY();

        if(state == FIRST){  // 状態1だったら状態2へ
            state = SECOND;
        }
        else if(state == SECOND){  // 状態2だったら状態3へ
            state = THIRD;
        }
        else if(state == THIRD){  // 状態3だったら状態1へ
            state = FIRST;
        }
        else{  // それ以外だったらエラーを吐き出す
            Log.d("error", "never come here");
        }

        invalidate();  // 再描画
        return super.onTouchEvent(event);
    }

    
    public BijouView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BijouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
