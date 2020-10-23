#import "SignLanguageRecognitionPlugin.h"
#if __has_include(<sign_language_recognition/sign_language_recognition-Swift.h>)
#import <sign_language_recognition/sign_language_recognition-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "sign_language_recognition-Swift.h"
#endif

@implementation SignLanguageRecognitionPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftSignLanguageRecognitionPlugin registerWithRegistrar:registrar];
}
@end
