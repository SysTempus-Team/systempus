import 'package:flutter/material.dart';

class LogoSenac extends StatelessWidget {
  const LogoSenac({super.key, this.imageRadius = 20, required this.logoSenac});

  final double imageRadius;
  final ImageProvider logoSenac;

  @override
  Widget build(BuildContext context) {
    return CircleAvatar(
      backgroundColor: Colors.white,
      radius: imageRadius,
      child: CircleAvatar(
        radius: imageRadius - 5,
        backgroundImage: logoSenac,
        
      ),
    );
  }
}
