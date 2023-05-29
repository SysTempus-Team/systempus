import 'package:flutter/material.dart';

class ImageCoordenador extends StatefulWidget {
  const ImageCoordenador({
    super.key,
   required this.imageProvider,
    this.imageRadius = 25,
  });

  final double imageRadius;
  final ImageProvider imageProvider;

  @override
  State<ImageCoordenador> createState() => _ImageCoordenadorState();
}

class _ImageCoordenadorState extends State<ImageCoordenador> {
  @override
  Widget build(BuildContext context) {
    return CircleAvatar(
      backgroundColor:Color(0XFFF78B1F),
      radius:widget.imageRadius,
      child: CircleAvatar(
        radius: widget.imageRadius - 2,
        child: CircleAvatar(
          backgroundColor: Color(0xFF005594),
           radius: widget.imageRadius - 4,

        backgroundImage: widget.imageProvider,),
      ),
    );
  }
}
