import 'package:app_flutter_horario_mobile/components/bottom_grid_view.dart';

import 'package:app_flutter_horario_mobile/components/painel_bem_vindo.dart';
import 'package:app_flutter_horario_mobile/components/painel_centro.dart';
import 'package:app_flutter_horario_mobile/home_disciplina.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
 

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue.shade200,
        elevation: 0,
      ),
      body: Stack(
        children: [
          Container(
            padding: const EdgeInsetsDirectional.only(bottom: 20),
            color: const Color(0xFF005594),
          ),
          Container(
            decoration: const BoxDecoration(
              image: DecorationImage(
                  image: AssetImage("assets/wallpaper_transp.png"),
                  fit: BoxFit.cover),
            ),
          ),
          SingleChildScrollView(
            child: Column(
              children: const [
                PainelBemVindo(
                    logoSenac: AssetImage(
                      "assets/senac-logo.png",
                    ),
                    linha1: 'Olá,Coordenador!',
                    linha2: 'Seja Bem-Vindo(a)!'),
                SizedBox(
                  height: 100,
                ),
                PainelCentro(label: 'PAINEL PRINCIPAL'),
                SizedBox(
                  height: 40,
                ),
                ButtomGridView()
              ],
            ),
          )
        ],
      ),
    );
  }
}
