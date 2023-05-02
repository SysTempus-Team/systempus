import 'package:flutter/material.dart';

class ResponsiveRow2 extends StatelessWidget {
  final List<Widget> children;
  final double minWidth;
  final double spacing;

  const ResponsiveRow2(
      {Key? key,
      required this.children,
      this.minWidth = 100,
      this.spacing = 40})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (BuildContext context, BoxConstraints constraints) {
        double maxWidth = constraints.maxWidth;
        int count = maxWidth ~/ 100;
        count = count < 1 ? 1 : count;
        return Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: children.take(count).toList(),
        );
      },
    );
  }
}
