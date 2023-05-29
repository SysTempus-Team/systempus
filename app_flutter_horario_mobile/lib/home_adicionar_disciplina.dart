import 'package:app_flutter_horario_mobile/components/input.dart';
import 'package:app_flutter_horario_mobile/components/painel_bem_vindo.dart';
import 'package:app_flutter_horario_mobile/components/painel_bottom_edicao.dart';
import 'package:app_flutter_horario_mobile/components/painel_centro.dart';
import 'package:flutter/material.dart';

class HomeAdicionarDisciplina extends StatefulWidget {
  const HomeAdicionarDisciplina({super.key});

  @override
  State<HomeAdicionarDisciplina> createState() =>
      _HomeAdicionarDisciplinaState();
}

class _HomeAdicionarDisciplinaState extends State<HomeAdicionarDisciplina> {
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
              children: [
                const PainelBemVindo(
                    logoSenac: AssetImage(
                      "assets/senac-logo.png",
                    ),
                    linha1: 'Olá,Coordenador!',
                    linha2: 'Seja Bem-Vindo(a)!'),
                const SizedBox(
                  height: 20,
                ),
                PainelCentro(label: "+ DISCIPLINA"),
                const SizedBox(
                  height: 20,
                ),

                Container(
                  constraints: const BoxConstraints.expand(
                    width: 300,
                    height: 900,

                    
                  ),
                  child: 
                  Column(
                    children: const [
                         Divider(
                    color: Colors.white,
                 
                   ),
                   Divider(
                    color: Colors.white,
                   ),
                  SizedBox(
                  height: 10,
                ),
                Input(label: 'NOME'),
                 SizedBox(
                  height: 10,
                ),
                
                
                Input(label: 'COORDENADORA'),
                 SizedBox(
                  height: 10,
                ),
                
                Input(label: 'MODALIDADE'),
                 SizedBox(
                  height: 10,
                ),
                Input(label: 'MÓDULO'),
                 SizedBox(
                  height: 10,
                ),
                Input(label: 'SIGLA'),
                 SizedBox(
                  height: 10,
                ),
                Input(label: 'QUANTIDADE DE PERÍODO'),
                 SizedBox(
                  height: 10,
                ),
                Input(label: 'CARGA HORÁRIA'),
                 SizedBox(
                  height: 10,
                ),
                Input(label: 'NÍVEL/ENSINO'),
                 SizedBox(
                  height: 10,
                ),
                  Divider(
                    color: Colors.white,
                 
                   ),
                   Divider(
                    color: Colors.white,
                   ),

                   PainelButtomEdocao(),
               

              



                    ],
                  ),
                )
              ],
            ),
          )
        ],
      ),
    );
  }
}
