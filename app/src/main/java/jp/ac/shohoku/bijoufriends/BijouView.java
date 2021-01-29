package jp.ac.shohoku.bijoufriends;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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

    int displayWidth;//画面の幅
    int displayHeight;//画面の高さ

    Resources res; //リソース
    Bitmap start; //スタート用のタップする画像
    Bitmap gacha; //ガチャ用のタップする画像

    int w; //画像の幅
    int h; //画像の高さ

    public BijouView(Context context) {
        super(context);
        init();
    }
    public BijouView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public BijouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
        public BijouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int state) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初期化用メソッド
     */
    private void init() {
        state = FIRST; // 初めは状態1

        res = this.getContext().getResources(); //リソースを取得
        start = BitmapFactory.decodeResource(res, R.drawable.start); //スタート画像を取得
        gacha = BitmapFactory.decodeResource(res, R.drawable.gtyasozai); //ガチャの画像を取得
    }

    /**
     * 描画のメソッド
     * @param canvas
     */
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint p = new Paint();
        displayWidth = this.getWidth();
        displayHeight = this.getHeight();

        if(state == FIRST) {  // 状態1の場合の描画
            canvas.drawARGB(255,255,255,255); //キャンバスを白で塗りつぶす
            drawLv1(canvas, p);
        }
        else if (state == SECOND) {  // 状態2の場合の描画
            canvas.drawARGB(255,255,255,255); //キャンバスを白で塗りつぶす
            drawLv2(canvas, p);
        }
        else if (state == THIRD) {  // 状態3の場合の描画
            canvas.drawARGB(255,255,255,255); //キャンバスを白で塗りつぶす
            drawLv3(canvas,p);
        }
        else {
            Log.d("error", "never come here");
        }
    }

    /**
     * Level1の描画
     * @param canvas
     * @param p
     */
    private void drawLv1(Canvas canvas, Paint p) {
        Bitmap title = BitmapFactory.decodeResource(res, R.drawable.bijyou); //画像を取得
        int titleWidth = title.getWidth();
        int titleHeight = title.getHeight();
        canvas.drawBitmap(title, displayWidth /2-titleWidth/2, displayHeight /3-titleHeight/3, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        canvas.drawBitmap(start, displayWidth /2-start.getWidth()/2, displayHeight /2-start.getHeight()/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する

        Bitmap rabbit = BitmapFactory.decodeResource(res, R.drawable.rabbit); //画像を取得
        canvas.drawBitmap(rabbit, 50, 800, p); //画像の左上を Canvasの(0,0)に合わせて表示する
    }

    /**
     * Level2の描画
     * @param canvas
     * @param p
     */
    private void drawLv2(Canvas canvas, Paint p) {
        canvas.drawBitmap(gacha, (displayWidth-gacha.getWidth())/2, (displayHeight-gacha.getWidth())/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する
    }

    /**
     * Level3の描画
     * @param canvas
     * @param p
     */
    private void drawLv3(Canvas canvas, Paint p) {
        Random rnd = new Random(); //乱数
        int teavalue = rnd.nextInt(100);
        if(teavalue>=0&&teavalue<5) {
            Bitmap ur_mikako = BitmapFactory.decodeResource(res, R.drawable.ur_mikako); //画像を取得
            canvas.drawBitmap(ur_mikako, (displayWidth-ur_mikako.getWidth())/2, (displayHeight-ur_mikako.getWidth())/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        }
        if(teavalue>=5&&teavalue<15) {
            Bitmap ssr_utsumitan = BitmapFactory.decodeResource(res, R.drawable.ssr_utsumitan); //画像を取得
            canvas.drawBitmap(ssr_utsumitan, (displayWidth-ssr_utsumitan.getWidth())/2, (displayHeight-ssr_utsumitan.getWidth())/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        }
        if(teavalue>=15&&teavalue<29){
            Bitmap sr_akio = BitmapFactory.decodeResource(res, R.drawable.sr_akio); //画像を取得
            canvas.drawBitmap(sr_akio, (displayWidth-sr_akio.getWidth())/2, (displayHeight-sr_akio.getWidth())/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        }
        if(teavalue>=30&&teavalue<44){
            Bitmap sr_ayuko = BitmapFactory.decodeResource(res, R.drawable.sr_ayuko); //画像を取得
            canvas.drawBitmap(sr_ayuko, (displayWidth-sr_ayuko.getWidth())/2, (displayHeight-sr_ayuko.getWidth())/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        }
        if(teavalue>=45&&teavalue<49){
            Bitmap ur_kiyotan = BitmapFactory.decodeResource(res, R.drawable.ur_kiyotan); //画像を取得
            canvas.drawBitmap(ur_kiyotan, (displayWidth-ur_kiyotan.getWidth())/2, (displayHeight-ur_kiyotan.getWidth())/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        }
        if(teavalue>=50&&teavalue<74){
            Bitmap r_ishizaki = BitmapFactory.decodeResource(res, R.drawable.r_ishizaki); //画像を取得
            canvas.drawBitmap(r_ishizaki, (displayWidth-r_ishizaki.getWidth())/2, (displayHeight-r_ishizaki.getWidth())/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        }
        if(teavalue>=75&teavalue<99){
            Bitmap r_onome = BitmapFactory.decodeResource(res, R.drawable.r_onome); //画像を取得
            canvas.drawBitmap(r_onome, (displayWidth-r_onome.getWidth())/2, (displayHeight-r_onome.getWidth())/2, p); //画像の左上を Canvasの(0,0)に合わせて表示する
        }
    }

    public boolean onTouchEvent(MotionEvent event){
        int x = (int) event.getX();  // タップされた位置を取得
        int y = (int) event.getY();
        Log.d("tap", "dipsplay is tapped!!");
        Log.d("location", "x="+x+",y="+y);
        Log.d("disp size", "dw="+displayWidth+",dh="+displayHeight);

        if(state == FIRST) {  // 状態1だったら状態2へ
            //スタート画像を押したら状態をSECONDに変える
            int x1 = (displayWidth-start.getWidth())/2;
            int y1 = (displayHeight-start.getHeight())/2;
            if (x1<=x && x<=x1+start.getWidth() && y1<=y && y<=y1+start.getHeight()){
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


}
