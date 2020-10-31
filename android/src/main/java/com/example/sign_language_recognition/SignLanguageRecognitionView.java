package com.example.sign_language_recognition;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.mediapipe.components.CameraHelper;
import com.google.mediapipe.components.CameraXPreviewHelper;
import com.google.mediapipe.components.ExternalTextureConverter;
import com.google.mediapipe.components.FrameProcessor;
import com.google.mediapipe.components.PermissionHelper;
import com.google.mediapipe.glutil.EglManager;

import java.util.List;
import java.util.Map;

import io.flutter.plugin.platform.PlatformView;

public class SignLanguageRecognitionView implements PlatformView{
    private SurfaceView view;

    @NonNull private final TextView textView;

    SignLanguageRecognitionView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {
        view = new SurfaceView(context);
        view.setVisibility(View.GONE);
        //view.getHolder().addCallback(callback);

        textView = new TextView(context);
        textView.setTextSize(72);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView.setText("Rendered on a native Android view (id: " + id + ")");
    }

    @NonNull
    @Override
    public View getView() {
        return textView;
    }

    @Override
    public void dispose() {}
}
