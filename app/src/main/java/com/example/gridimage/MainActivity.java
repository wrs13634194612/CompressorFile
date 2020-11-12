package com.example.gridimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //参考网址：https://github.com/abr13/MediaCompressor
    //本地的一张10M的大图片  不压缩直接加载会oom
    private String imagePath = "/storage/emulated/0/image/IMG_20200128_163036.jpg";
    private GridView gridView;
    private ImageAdapter adapter;
    private List<ItemBean> languageList;
    private String[] titles = {"测试0", "测试1", "测试2", "测试3",
            "测试4", "测试5", "测试6", "测试7",
            "测试8", "测试9", "测试10", "测试11", "测试12", "测试13", "测试14", "测试15",
            "测试16", "测试17", "测试18", "测试19",
            "测试20", "测试21", "测试22"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pernmissionHandle();  //申请权限
        FileUtil fileZipUtil = new FileUtil(MainActivity.this,
                imagePath, 720, 720, 30);
        String imageString = fileZipUtil.convert();

        languageList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            languageList.add(new ItemBean(titles[i], "描述" + i, imageString, "距离" + i));
        }

        gridView = findViewById(R.id.gridView);
        adapter = new ImageAdapter(languageList, MainActivity.this);
        gridView.setAdapter(adapter);

    }

    //permission
    private void pernmissionHandle() {
        //check
        checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, 100);
        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, 101);
        checkPermission(Manifest.permission.INTERNET, 103);
    }

    //permission
    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
        }
    }

}