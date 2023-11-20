import 'package:flutter/material.dart';
import 'package:realstate/home/homepage.dart';

//After 1 sec splash to home page
class Splash extends StatefulWidget {
  const Splash({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  State<Splash> createState() => _SplashState();
}

class _SplashState extends State<Splash> {
  @override
  void initState() {
    super.initState();
    Future.delayed(const Duration(seconds: 2), () {
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(
          builder: (context) => const Homepage(title: 'Home Page'),
        ),
      );
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text(widget.title,
            textAlign: TextAlign.center,
            style: const TextStyle(
              color: Colors.black,
              fontSize: 20,
              fontWeight: FontWeight.bold,
              decorationStyle: TextDecorationStyle.wavy,
            )),
      ),
    );
  }
}