import 'package:flutter/material.dart';

class ButtonsDisciplina extends StatelessWidget {
  const ButtonsDisciplina({
    super.key,
    required this.label1,
    required this.label2,
    required this.label3,
    this.textColor = Colors.black,
    required this.onPressed1,
    required this.onPressed2,
    required this.onPressed3,
  });

  final String label1;
  final String label2;
  final String label3;
  final Color textColor;
  final VoidCallback onPressed1;
  final VoidCallback onPressed2;
  final VoidCallback onPressed3;

  @override
  Widget build(BuildContext context) {
    return Container(
      constraints: const BoxConstraints.expand(
        width: 400,
        height: 60
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget> [
          SizedBox(
            width: 100,
            height: 30,
            child: ElevatedButton(
              onPressed: onPressed1,
              style: ElevatedButton.styleFrom(
                foregroundColor: textColor,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10.0),
                ),
                backgroundColor: Colors.deepOrange[50],
              ),
              child: Text(label1),
            ),
          ),
          SizedBox(
            width: 100,
            height: 30,
            child: ElevatedButton(
              onPressed: onPressed2,
              style: ElevatedButton.styleFrom(
                foregroundColor: textColor,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10.0),
                ),
                backgroundColor: Colors.red,
              ),
              child: Text(label2),
            ),
          ),
          SizedBox(
              width: 100,
            height: 30,
            child: ElevatedButton(
              onPressed:onPressed3,
              style: ElevatedButton.styleFrom(
                foregroundColor: textColor,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10.0),
                ),
                backgroundColor: Colors.lightGreen,
              ),
              child: Text(label3),
            ),
          ),
        ],
      ),
    );
  }
}
