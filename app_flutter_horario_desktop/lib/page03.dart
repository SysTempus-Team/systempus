import 'package:flutter/material.dart';
import 'package:tela01/logoSenac.dart';
import 'buttom_custom.dart';
import 'card_inicial.dart';

class Page03 extends StatefulWidget {
  const Page03({super.key});

  @override
  State<Page03> createState() => _Page03State();
}

class _Page03State extends State<Page03> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            CardInicial(
                linha1: "Coordenador,",
                linha2: "Bem vindo ao sistema",
                iconeFotoProfessor: Icon(
                  Icons.person,
                  size: 60,
                )),
            Container(
              height: 50,
            ),
            Container(
              width: 500,
              height: 60,
              alignment: Alignment.center,
              child: Wrap(
                children: [
                  ConstrainedBox(
                    constraints:
                        const BoxConstraints(maxWidth: 250, maxHeight: 30),
                    child: TextField(
                      decoration: InputDecoration(
                        border: OutlineInputBorder(
                          borderSide: BorderSide(color: Colors.grey),
                        ),
                      ),
                    ),
                  ),
                  Container(
                    height: 30,
                    decoration: BoxDecoration(
                      border: Border.all(
                        color: Colors.grey,
                      ),
                    ),
                    child: DropdownButton(
                        value: null, items: [], onChanged: (value) {}),
                  ),
                  Container(
                    width: 200,
                  ),
                ],
              ),
            ),
            Column(
              children: [
                Container(
                  width: 600,
                  height: 200,
                  alignment: Alignment.center,
                  child: Wrap(
                    spacing: 10,
                    runSpacing: 20,
                    children: <Widget>[
                      ButtomCustom(
                        label: "Professor",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Turno",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Curso",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Módulo",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Turma",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Disciplina",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Carga Horária Total",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Relatório",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Carga Horária",
                        onPressed: () {},
                      ),
                      ButtomCustom(
                        label: "Turno",
                        onPressed: () {},
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
