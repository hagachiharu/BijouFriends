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

import java.util.Random;

/**
 * 一つのActivityで画面遷移する。(テキストP.53の1のやり方)
 * MainView→BijouViewに変更
 */
public class BijouView extends View {
    public final int FIRST = 1;  // 状態を表す定数1
    public final int SECOND = 2;  // 状態を表す定数2
    public final int THIRD = 3;  // 状態を表す定数3

    int state;  // 状態を表す変数

    int w1;//画面の幅
    int h1;//画面の高さ
    int w; //画像の幅
    int h; //画像の高さ

    int w2;
    int h2;
    int w3;
    int h3;

    int w4;
    int h4;
    int w5;
    int h5;



    public BijouView(Context context) {

        super(context);
        state = FIRST; // 初めは状態1
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint p = new Paint();

        if(state == FIRST) {  // 状態1の場合の描画
            drawLv1(canvas, p);
        }
        else if (state == SECOND) {  // 状態2の場合の描画
            drawLv2();
        }
        else if (state == THIRD) {  // 状態3の場合の描画
            drawLv3();
        }
        else {
            Log.d("error", "never come here");
        }
    }

    private void drawLv1(Canvas canvas, Paint p) {
        Resources rs = this.getContext().getResources(); //リソースを取得
        Bitmap bijyou = BitmapFactory.decodeResource(rs, R.drawable.bijyou); //画像を取得
        w1 = this.getWidth();  //this=bijyouview
        h1 = this.getHeight();
        w = bijyou.getWidth();
        h = bijyou.getHeight();
        canvas.drawBitmap(bijyou, w1/2-w/2, h1/3-h/3, p); //画像の左上を Canvasの(0,0)に合わせて表示する

        Resources rt = this.getContext().getResources(); //リソースを取得
        Bitmap start = BitmapFactory.decodeResource(rt, R.drawable.start); //画像を取得
        w2 = this.getWidth();
        h2 = this.getHeight();
        w3 = start.getWidth();
        h3 = start.getHeight();
        canvas.drawBitmap(start, w1/2-w/2, h1/2-h/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する


        Resources ru = this.getContext().getResources(); //リソースを取得
        Bitmap rabbit = BitmapFactory.decodeResource(ru, R.drawable.rabbit); //画像を取得
        w4 = this.getWidth();
        h4 = this.getHeight();
        w5 = rabbit.getWidth();
        h5 = rabbit.getHeight();
        canvas.drawBitmap(rabbit, 1000, 1700, p); //画像の左上を Canvasの(0,0)に合わせて表示する
    }

    private void drawLv3() {
        Random rnd = new Random(); //乱数
        int teachervalue = rnd.nextInt(100);
    }

    private void drawLv2() {
    }


    public boolean onTouchEvent(MotionEvent event){
        int x = (int) event.getX();  // タップされた位置を取得
        int y = (int) event.getY();

        if(state == FIRST) {  // 状態1だったら状態2へ
            //四角の中だったら状態をSECONDに変える
            if (w2<=x&&x<=w2+w3&&h2<=h3&&y<=h3+h2){
                state = SECOND;
            }
        }
        else if(state == SECOND){  // 状態2だったら状態3へ
            touchLv2();
            //state = THIRD;
        }
        else if(state == THIRD){  // 状態3だったら状態1へ
            //state = FIRST;
            touchLv3();
        }
        else{  // それ以外だったらエラーを吐き出す
            Log.d("error", "never come here");
        }

        invalidate();  // 再描画
        return super.onTouchEvent(event);
    }

    //Lv3でタッチされた時の処理
    private void touchLv3() {
    }


    private void touchLv2() {
    }


    public BijouView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BijouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
