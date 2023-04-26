import 'package:flutter/material.dart';

class ButtomCustom extends StatefulWidget {
  final String label;
  final Color color;
  final Color textColor;
  final VoidCallback onPressed;

  const ButtomCustom(
      {super.key,
      required this.label,
      this.color = Colors.lightBlueAccent,
      this.textColor = Colors.black,
      required this.onPressed});

  @override
  State<ButtomCustom> createState() => _ButtomCustomState();
}

class _ButtomCustomState extends State<ButtomCustom> {
  @override
  Widget build(BuildContext context) {
    return SizedBox(
        width: 110.0,
        height: 70.00,
        child: ElevatedButton(
            onPressed: widget.onPressed,
            style: ElevatedButton.styleFrom(
              foregroundColor: widget.textColor,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(10.0),
              ),
              backgroundColor: widget.color,
            ),
            child: Text(widget.label)));
  }
}
