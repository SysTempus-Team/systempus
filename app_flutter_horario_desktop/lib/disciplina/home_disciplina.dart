

import 'package:flutter/material.dart';
import 'card_disciplina.dart';
import 'input_disciplina.dart';
import 'adicionar_disciplina.dart';
import 'buttons_disciplina.dart';
import '../input_disciplina_mobile.dart';

class HomeDisciplina extends StatelessWidget {
  const HomeDisciplina({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        padding:const EdgeInsets.only(top: 100, bottom: 50, left: 100, right: 100),
        child: Column(
          children: <Widget>[
         
         CardTopoDisciplina( 
           exibirLista: 'Exibir lista de Disciplina cadastradas',
                modulo: 'Disciplina',
                modulos: "Disciplinas",
                placeHolderModulo: 'Pesquisar Disciplinas',
         ),
            const Divider(color: Colors.black),
            const Divider(color: Colors.black),
            const SizedBox(
              height: 8,
            ),
            const AdicionarDisciplina(
                modulo: 'Nova Disciplina',
                cadastroModulo: 'Cadastrar Nova Disciplina'),
         
            InputDisciplina(),
            ButtonsDisciplina(
                label1: 'Editar',
                label2: 'Remover',
                label3: 'Salvar',
                onPressed1: () {},
                onPressed2: () {},
                onPressed3: () {}),
            const Divider(color: Colors.black),
            const Divider(color: Colors.black)
          ],
        ),
      ),
    );
  }
}
