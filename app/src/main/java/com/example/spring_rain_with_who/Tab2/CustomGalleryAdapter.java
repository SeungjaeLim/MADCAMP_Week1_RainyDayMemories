package com.example.spring_rain_with_who.Tab2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.spring_rain_with_who.R;

import java.io.File;

public class CustomGalleryAdapter extends BaseAdapter {
    int CustomGalleryItemBg;
    String mBasePath;
    Context mContext;
    String[] mImgs;
    Bitmap bm;

    public String TAG = "Gallery Adapter Example :: ";

    public CustomGalleryAdapter(Context context, String basepath)
    {
        this.mContext = context;
        this.mBasePath = basepath;

        File file = new File(mBasePath);
        if(!file.exists())
        {
            if(!file.mkdirs())
            {
                Log.d(TAG, "failed to create directory");
            }
        }
        mImgs = file.list();

        TypedArray array = mContext.obtainStyledAttributes(R.styleable.GalleryTheme);
        CustomGalleryItemBg = array.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
        array.recycle();
    }
    @Override
    public int getCount() {
        return mImgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        ImageView i = new ImageView(mContext);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;
        int reqWidth = 256;
        int reqHeight = 192;
        if((width > reqWidth) || (height > reqHeight))
        {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth)
            {
                inSampleSize *= 2;
            }
        }
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;

        bm = BitmapFactory.decodeFile(mBasePath + File.separator + mImgs[index], options);
        Bitmap bm2 = ThumbnailUtils.extractThumbnail(bm, 300, 300);

        i.setLayoutParams(new Gallery.LayoutParams(300, 300));
        i.setImageBitmap(bm2);
        i.setVisibility(ImageView.VISIBLE);

        i.setBackgroundResource(CustomGalleryItemBg);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);

        if(bm != null && !bm.isRecycled())
        {
            bm.recycle();
        }
        return i;
    }
}
