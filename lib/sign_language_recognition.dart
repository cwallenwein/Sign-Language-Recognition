import 'dart:async';
import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

class SignLanguageRecognition extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final String VIEW_TYPE = "type";
    final Map<String, dynamic> creationParams = <String, dynamic>{};

    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return AndroidView(
          viewType: VIEW_TYPE,
          // creationParamsCodec: const StandardMessageCodec(),
        );
      default:
        throw UnsupportedError("Unsupported Platform");
    }
  }
}
