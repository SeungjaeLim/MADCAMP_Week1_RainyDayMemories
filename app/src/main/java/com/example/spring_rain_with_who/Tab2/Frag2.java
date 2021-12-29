package com.example.spring_rain_with_who.Tab2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spring_rain_with_who.R;

import java.io.File;

public class Frag2 extends Fragment {

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public int inSampleSize = 1;

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;
    private static String basePath;

    public float imageViewRotation = 90;
    public String TAG = "Camera Example ::";

    private Button takePicBtn;
    private ImageView resultView;
    private TextView imgPath;
    private Gallery customGallery;
    private CustomGalleryAdapter customGalAdapter;

    private String[] imgs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyCameraApp");

        if(!mediaStorageDir.exists())
        {
            if(!mediaStorageDir.mkdirs())
            {
                Log.d("MyCameraApp", "failed to create directory");
            }
        }
        basePath = mediaStorageDir.getPath();

        imgPath = (TextView) getView().findViewById(R.id.imgpath);
        resultView = (ImageView) getView().findViewById(R.id.resultview);
        takePicBtn = (Button) getView().findViewById(R.id.takepicbtn);

        takePicBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent imageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MyImages");
                imagesFolder.mkdirs(); // <----
                File image = new File(imagesFolder, "image_001.jpg");
                Uri uriSavedImage = Uri.fromFile(image);
                imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                startActivityForResult(imageIntent,0);
            }
        });

        File file = new File(basePath);
        imgs = file.list();
        for(int i = 0 ; i < imgs.length; i++)
        {
            imgPath.setText(imgs[i]);
        }

        customGallery = (Gallery)getView().findViewById(R.id.customgallery);
        customGalAdapter = new CustomGalleryAdapter(getActivity().getApplicationContext(), basePath);
        customGallery.setAdapter(customGalAdapter);
        customGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bitmap bm = BitmapFactory.decodeFile(basePath + File.separator + imgs[position]);
                Bitmap bm2 = ThumbnailUtils.extractThumbnail(bm, bm.getWidth()/inSampleSize, bm.getHeight() / inSampleSize);

                resultView.setImageBitmap(bm2);
                imgPath.setText(basePath + File.separator + imgs[position]);
            }
        });
        customGallery.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                File temp = new File(basePath + File.separator + imgs[position]);
                temp.delete();
                return false;
            }
        });
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab2_main, container, false);
    }
}