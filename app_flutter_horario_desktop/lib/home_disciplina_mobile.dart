import 'package:flutter/material.dart';

import 'disciplina/card_disciplina.dart';
import 'disciplina/input_disciplina.dart';
import 'disciplina/adicionar_disciplina.dart';
import 'disciplina/buttons_disciplina.dart';
import 'input_disciplina_mobile.dart';

class HomeDisciplinaMobile extends StatelessWidget {
  const HomeDisciplinaMobile({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        padding:const EdgeInsets.all(8),
        child: Column(
          children: <Widget>[
            const CardTopoDisciplina(
                exibirLista: 'Exibir lista de Disciplina cadastradas',
                modulo: 'Disciplina',
                modulos: "Disciplinas",
                placeHolderModulo: 'Pesquisar Disciplinas'),
            const Divider(color: Colors.black),
            const Divider(color: Colors.black),
            const SizedBox(
              height: 8,
            ),
            const AdicionarDisciplina(
                modulo: 'Nova Disciplina',
                cadastroModulo: 'Cadastrar Nova Disciplina'),
         
        const  InputDisciplinaMobile(),
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