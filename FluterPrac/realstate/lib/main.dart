import 'package:flutter/material.dart';
import 'package:realstate/splash/splash.dart';


//call splash page in main.dart
void main() {
  runApp(const MaterialApp(
    debugShowCheckedModeBanner: false,
    home: Splash(title: 'Splash Screen'),
  ));
}



