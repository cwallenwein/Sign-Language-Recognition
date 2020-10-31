package com.example.sign_language_recognition;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class SignLanguageRecognitionViewFactory extends PlatformViewFactory {
    @NonNull
    private final BinaryMessenger messenger;

    SignLanguageRecognitionViewFactory(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = binding.getBinaryMessenger();
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        return new SignLanguageRecognitionView(context, id, creationParams);
    }
}
