import 'package:flutter/material.dart';

class ButtomEdicao extends StatefulWidget {
  const ButtomEdicao(
      {super.key,
      required this.label,
      required this.color,
      this.textColor = 0xFF005594,
      required this.onPressed,
      required this.base,
      required this.altura});

  final String label;
  final int color;
  final int textColor;
  final VoidCallback onPressed;
  final double base;
  final double altura;

  @override
  State<ButtomEdicao> createState() => _ButtomEdicaoState();
}

class _ButtomEdicaoState extends State<ButtomEdicao> {
  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: widget.altura,
      width: widget.base,
      child: ElevatedButton(
        onPressed: widget.onPressed,
        style: ElevatedButton.styleFrom(
          foregroundColor: Color(widget.textColor),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(2.0),
          ),
          backgroundColor: Color(widget.color),
        ),
        child: Center(
          child: Text(widget.label,
          style: TextStyle(
            fontSize: 10
          ),),
        ),
      ),
    );
  }
}
