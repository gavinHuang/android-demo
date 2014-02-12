package com.example.hello;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MediaActivity extends Activity {

	 private VideoView videoView;  
	 //private Button btnHide, btnShow;  
	 MediaController mediaController;  
	 
	 MediaPlayer mediaPlayer;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.media);
		videoView = (VideoView)this.findViewById(R.id.videoView1);
		mediaController = new MediaController(this);  
		
		
		/*mediaPlayer = MediaPlayer.create(this,R.raw.where);
		try {
			mediaPlayer.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mediaPlayer.start();*/
	     
		File videoFile = new File("/mnt/sdcard/sample.mp4");
		if (videoFile.exists()){
			long lenth = videoFile.length();
			
			videoView.setVideoPath(videoFile.getAbsolutePath());
			videoView.setMediaController(mediaController);
			mediaController.setMediaPlayer(videoView);
			
			videoView.requestFocus();
			
			//videoView.
			videoView.start();
		}else{
			Toast.makeText(this, "file does not exists", Toast.LENGTH_LONG).show();
		}
		
		
	}

}
