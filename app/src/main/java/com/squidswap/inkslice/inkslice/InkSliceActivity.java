package com.squidswap.inkslice.inkslice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.transform.Source;

public class InkSliceActivity extends AppCompatActivity {

    private Uri FocusedImage;
    private FileService FilServ;
    private SliceCanvas SliceCan;
    private RelativeLayout CanvasLayout;
    private ImageButton SuccessBtn,CancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ink_slice);

        this.FilServ = new FileService();
        this.SliceCan = new SliceCanvas(getApplicationContext());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    //Class that will initialize creating an inkslice activity.
    private class SliceBuilder extends Intent {
        public SliceBuilder(Uri FirstImage,Uri ExportImage){

        }

        //Starts the slicing activity.
        public void start(){

        }
    }

    //Class that will handle drawing to the actual canvas that will display stuff
    //over the chosen image.
    private class SliceCanvas extends View {
        public SliceCanvas(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }
    }

    //Class that will be used to load the selected image from the
    //filesystem, this will usually be a tmp file.
    private class FileService{
        public Bitmap LoadFile(Uri source){
            FileInputStream SourceStream;
            Bitmap OutputFile;

            try {
                SourceStream = new FileInputStream(new File(source.getPath()));
                OutputFile = BitmapFactory.decodeStream(SourceStream);
                return OutputFile;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Error loading file...",Toast.LENGTH_SHORT).show();
                return null;
            }
        }
    }
}
