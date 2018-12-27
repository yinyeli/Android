package com.example.yyl.app0;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;


public class activity_videoplayer extends Activity {

    String url="";
    String video_url = "http://192.168.10.105:8080/ad/movie.mp4";
    VideoView videoView;
    ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);


        Intent intent = getIntent();
        url = intent.getStringExtra("video_url");//获取链接

//        imageView = findViewById(R.id.video_image);
//        imageView.setImageBitmap(getVideoThumb(url));
        videoView=findViewById(R.id.mVideoView);

        //设置视频控制器
        videoView.setMediaController(new MediaController(this));

        videoView.setVideoPath(url);
        videoView.requestFocus();

        findViewById(R.id.btn_play).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageView.setVisibility(View.INVISIBLE);//设置不可见
                videoView.start();
                videoView.setVisibility(View.VISIBLE);//设置可见
            }
        });

        findViewById(R.id.btn_pause).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.seekTo(0);
                videoView.pause();
            }
        });
    }

    /**
     * 获取视频文件截图
     * @param path 视频文件的路径
     * @return Bitmap 返回获取的Bitmap
     */

    public  static Bitmap getVideoThumb(String path) {
        MediaMetadataRetriever media = new MediaMetadataRetriever();
        media.setDataSource(path);
        return  media.getFrameAtTime();
    }
}
