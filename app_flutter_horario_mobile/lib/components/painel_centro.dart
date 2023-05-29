import 'package:flutter/material.dart';

class PainelCentro extends StatelessWidget {
  const PainelCentro(
      {super.key,
      required this.label,
      this.color = 0xFFF2B374,
      this.textColor = 0xFF005594});

  final int color;
  final int textColor;
  final String label;

  @override
  Widget build(BuildContext context) {
   return SizedBox(
      height: 60,
      width: 200,
      child: Center(
        child: Container(
            constraints: BoxConstraints.expand(height: 60, width: 160),
            decoration: BoxDecoration(
                color: Color(color),
                borderRadius: BorderRadius.circular(6)),
            child: Center(
              child: Text(
                label,
                style: TextStyle(color: Color(textColor),
                fontSize: 16),
              ),
            )),
      ),
    );
  }
}
