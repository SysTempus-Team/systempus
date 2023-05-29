import 'package:app_flutter_horario_mobile/components/bottons_custom.dart';
import 'package:flutter/material.dart';

import '../home_disciplina.dart';

class ButtomGridView extends StatefulWidget {
  const ButtomGridView({super.key});

  @override
  State<ButtomGridView> createState() => _ButtomGridViewState();
}

class _ButtomGridViewState extends State<ButtomGridView> {
  int _selectedIndex = 0;

  static List<Widget> pages = <Widget>[
    const HomeDisciplina(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Padding(
        padding: const EdgeInsets.only(
          right: 30,
          left: 30,
        ),
        child: Container(
          child: Wrap(
            spacing: 25,
            runSpacing: 25,
            children: [
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => HomeDisciplina()));
                  }),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
              ButtomCustom(
                  icone: Icon(Icons.padding),
                  label: 'professor',
                  onPressed: () {}),
            ],
          ),
        ),
      ),
    );
  }
}
