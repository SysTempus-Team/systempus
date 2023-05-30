


import 'package:flutter/material.dart';

typedef FunctionStringCallback = void Function(String);

class Input extends StatefulWidget {
  const Input(
      {super.key,
      required this.label,
      this.inputColor = 0xFFADC2D1,
      this.textColor = Colors.white,
      this.onChanged});

  final String label;
  final Color textColor;
  final int inputColor;
  final FunctionStringCallback? onChanged;

  @override
  State<Input> createState() => _InputState();
}

class _InputState extends State<Input> {
  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            widget.label,
            style: TextStyle(color: widget.textColor),
          ),
          TextField(
            cursorHeight: 20,
            onChanged:  (value) {
        if (widget.onChanged != null) {
          widget.onChanged!(value);
        }
      },
            decoration: InputDecoration(
                contentPadding: EdgeInsets.symmetric(vertical: 20),
                filled: true,
                fillColor: Color(widget.inputColor),
                border:
                    OutlineInputBorder(borderRadius: BorderRadius.circular(6))),
          )
        ],
      ),
    );
  }
}
