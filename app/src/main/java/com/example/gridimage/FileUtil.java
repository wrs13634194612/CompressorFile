package com.example.gridimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import id.zelory.compressor.Compressor;

//图片压缩工具类
public class FileUtil {
    private Context context;
    private String path;
    private int width;
    private int height;
    private int quality;

    /**
     * @param context
     * @param path    本地文件路径
     * @param width   宽度
     * @param height  高度
     * @param quality 压缩率 0-100
     */
    public FileUtil(Context context, String path, int width, int height, int quality) {
        this.context = context;
        this.path = path;
        this.width = width;
        this.height = height;
        this.quality = quality;
    }

    public String convert() {
        // File imagePath = new File(Objects.requireNonNull(imagePath));
        File imagePath = new File(path);
        Bitmap imageBitmap = null;
        try {
            imageBitmap = new Compressor(context)
                    .setMaxWidth(width)
                    .setMaxHeight(height)
                    .setQuality(quality)
                    .compressToBitmap(imagePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //   storeImage(imageBitmap);
        File pictureFile = getOutputMediaFile();
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, quality, fos);
            //  iv.setImageBitmap(imageBitmap);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d("TAG", "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d("TAG", "Error accessing file: " + e.getMessage());
        }
        return pictureFile.getPath();
    }

    private File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment
                .getExternalStorageDirectory()
                + "/Media Compressor/Compressed");
        // Create the directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        // Create a file name format with timestamp
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        File mediaFile;
        String format = ".png";
        String mImageName = "compressed_" + timeStamp + format;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        Log.e("TAG", "path：" + mediaFile.getPath());
        return mediaFile;
    }

}
