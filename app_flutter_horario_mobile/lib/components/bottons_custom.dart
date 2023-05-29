import 'package:flutter/material.dart';

class ButtomCustom extends StatefulWidget {
  final String label;
  final int color;
  final int textColor;
  final Icon icone;
  final VoidCallback onPressed;

  const ButtomCustom(
      {super.key,
      required this.label,
      this.color = 0xFFADC2D1,
      this.textColor = 0xFF005594,
      required this.onPressed,
      required this.icone});

  @override
  State<ButtomCustom> createState() => _ButtomCustomState();
}

class _ButtomCustomState extends State<ButtomCustom> {


  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 140.0,
      height: 140.00,
      child: ElevatedButton(
        onPressed: widget.onPressed,
        style: ElevatedButton.styleFrom(
          foregroundColor: Color(widget.textColor),
          
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(6.0),
          ),
          backgroundColor: Color(widget.color),
        ),
        child:Center(
          child: Column(
            children: [
              SizedBox(
                height: 30,
              ),
              widget.icone,

              Text(widget.label)

            ],

          ),
       
        )
      ),
    );
  }
}
