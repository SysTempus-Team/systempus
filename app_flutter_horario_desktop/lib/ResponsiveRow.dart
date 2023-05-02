import 'package:flutter/material.dart';

class ResponsiveRow extends StatelessWidget {
  final List<Widget> children;
  final double minWidth;
  final double spacing;

  const ResponsiveRow(
      {Key? key,
      required this.children,
      this.minWidth = 100,
      this.spacing = 40})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints) {
      final width = constraints.maxWidth;

      final numColumns = (width / minWidth).floor();
      final columnsWidth =
          (width / numColumns) - ((numColumns - 1) * spacing) / numColumns;

      return Row(
          children: List.generate(
              children.length,
              (index) => Flexible(
                      child: SizedBox(
                    width: columnsWidth,
                    child: children[index],
                  ))));
    });
  }
}
