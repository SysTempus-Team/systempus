import 'package:flutter/material.dart';
import 'package:tela01/logoSenac.dart';

class CardInicial extends StatelessWidget {
  final Icon iconeFotoProfessor;
  final String linha1;
  final String linha2;

  const CardInicial(
      {super.key,
      required this.linha1,
      required this.linha2,
      required this.iconeFotoProfessor});

  @override
  Widget build(BuildContext context) {
    const CardInicial(
        iconeFotoProfessor: Icon(Icons.person),
        linha1: "Coordenador,",
        linha2: "Bem vindo ao sistema");
    return Container(
      padding: const EdgeInsets.all(16),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          const LogoSenac(
            logoSenac: AssetImage("images/senac-logo.png"),
            imageRadius: 40,
          ),
          Row(
            children: [
              iconeFotoProfessor,
              const SizedBox(
                width: 8,
              ),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(linha1),
                  Text(
                    linha2,
                  ),
                ],
              ),
            ],
          ),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 250, maxHeight: 30),
            child: TextField(
              decoration: InputDecoration(
                prefixIcon: Icon(Icons.search),
                hintText: ("Buscar"),
                contentPadding: EdgeInsets.fromLTRB(12, 12, 16, 12),
                border: OutlineInputBorder(
                  borderSide: const BorderSide(color: Colors.grey),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }

  // ignore: non_constant_identifier_names
}
