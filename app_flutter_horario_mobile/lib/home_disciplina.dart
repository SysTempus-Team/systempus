import 'package:app_flutter_horario_mobile/components/bottom_adicionar_pesquisar.dart';
import 'package:app_flutter_horario_mobile/components/painel_bem_vindo.dart';
import 'package:app_flutter_horario_mobile/components/painel_centro.dart';
import 'package:app_flutter_horario_mobile/home_adicionar_disciplina.dart';
import 'package:flutter/material.dart';

class HomeDisciplina extends StatefulWidget {
  const HomeDisciplina({super.key});

  @override
  State<HomeDisciplina> createState() => _HomeDisciplinaState();
}

class _HomeDisciplinaState extends State<HomeDisciplina> {
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
                children:  [
                  const PainelBemVindo(
                      logoSenac: AssetImage(
                        "assets/senac-logo.png",
                      ),
                      linha1: 'Olá,Coordenador!',
                      linha2: 'Seja Bem-Vindo(a)!'),
                  const SizedBox(
                    height: 100,
                  ),
                  const PainelCentro(label: 'DISCPLINA'),
                    const SizedBox(
                    height: 20,
                  ),
                  Container(
                      constraints: const BoxConstraints.expand(
                        width: 250,
                        height: 400
                      ),

                      child: Column(
                        children:  [
                   const Divider(
                    color: Colors.white,
                 
                   ),
                   const Divider(
                    color: Colors.white,
                   ),

                   const SizedBox(
                    height: 40,
                   ),

                   ButtomAdicionarPesquisar(
                    icone: const Icon(Icons.add,
                    color: Color(0xFF005594),),
                    label: 'Nova Disciplina', 
                   onPressed: () {
                     Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => HomeAdicionarDisciplina()));
                   }),
                     const SizedBox(
                    height: 15,
                   ),

                   ButtomAdicionarPesquisar(
                    icone: const Icon(Icons.search,
                    color: Color(0xFF005594),),
                    label: 'Pesquisar', 
                   onPressed: () {}),
                    const SizedBox(
                    height: 40,
                   ),
                    const Divider(
                    color: Colors.white,
                 
                   ),
                   const Divider(
                    color: Colors.white,
                   ),



                  
                        ],
                      ),

                    ),
                
                
                  
                ],
              ),
            ),
          
        ],
      ),
    );
  }
}
