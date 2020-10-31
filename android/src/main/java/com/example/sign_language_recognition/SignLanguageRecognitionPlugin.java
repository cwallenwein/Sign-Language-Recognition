package com.example.sign_language_recognition;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.google.mediapipe.components.PermissionHelper;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformView;

public class SignLanguageRecognitionPlugin implements FlutterPlugin, ActivityAware {

  private Activity currentActivity;

  // For the plugin
  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
    binding
            .getPlatformViewRegistry()
            .registerViewFactory("type", new SignLanguageRecognitionViewFactory(binding));
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {}

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    currentActivity = binding.getActivity();
    binding.addRequestPermissionsResultListener(resultListener);
    PermissionHelper.checkAndRequestCameraPermissions(binding.getActivity());
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {
    currentActivity = null;
  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
    currentActivity = binding.getActivity();
    binding.addRequestPermissionsResultListener(resultListener);
  }

  @Override
  public void onDetachedFromActivity() {
    currentActivity = null;
  }


  PluginRegistry.RequestPermissionsResultListener resultListener = new PluginRegistry.RequestPermissionsResultListener() {
    @Override
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
      for(int i=0; i<permissions.length; i++){
        String permission = permissions[i];
        int result = grantResults[i];
        if(permission.equals("android.permission.CAMERA")){
          if(result == 0){
            System.out.println("Access to camera granted");
          }else if(result == -1){
            System.out.println("Access to camera not granted");
            Toast.makeText(currentActivity.getBaseContext(), "Please grant camera access", Toast.LENGTH_LONG).show();
          }
        }
      }
      return false;
    }
  };
}
