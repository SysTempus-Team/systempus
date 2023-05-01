import 'package:flutter/material.dart';

import 'package:flutter/widgets.dart';

import 'package:tela01/page03.dart';
import 'disciplina/home_disciplina.dart';
import 'home_disciplina_mobile.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: RootPage(),
    );
  }
}

class RootPage extends StatefulWidget {
  const RootPage({super.key});

  @override
  State<RootPage> createState() => _RootPageState();
}

class _RootPageState extends State<RootPage> {
  List<Widget> pages = const [Page03()];
  @override
  Widget build(BuildContext context) {
    if (MediaQuery.of(context).size.width < 400) {
      return MaterialApp(
        theme: ThemeData.light(),
        title: 'Disciplina',
        home: const HomeDisciplinaMobile(),
      );
    }

    return MaterialApp(
      theme: ThemeData.light(),
      title: 'Disciplina',
      home: const HomeDisciplina(),
    );
  }
}
