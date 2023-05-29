import 'package:flutter/material.dart';

class ButtomAdicionarPesquisar extends StatefulWidget {
  const ButtomAdicionarPesquisar(
      {super.key,
      required this.label,
      this.color = 0xFFADC2D1,
      this.textColor = 0xFF005594,
      required this.onPressed,
      required this.icone});

  final String label;
  final int color;
  final int textColor;
  final VoidCallback onPressed;
  final Icon icone;

  @override
  State<ButtomAdicionarPesquisar> createState() =>
      _ButtomAdicionarPesquisarState();
}

class _ButtomAdicionarPesquisarState extends State<ButtomAdicionarPesquisar> {
  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 80.00,
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
          child: 
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              widget.icone,
              SizedBox(width: 5,),
              Text(widget.label,
              style: TextStyle(
                fontSize: 20
              ),)
            ],
          ),
       
        ),
      ),
    );
  }
}
