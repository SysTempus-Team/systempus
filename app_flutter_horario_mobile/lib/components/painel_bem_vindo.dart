import 'package:app_flutter_horario_mobile/components/image_coordenador.dart';
import 'package:flutter/material.dart';

class PainelBemVindo extends StatefulWidget {
  const PainelBemVindo({
    super.key,
    required this.logoSenac,
    required this.linha1,
    required this.linha2,
  });

  final AssetImage logoSenac;
  // TODO: ALTERAR ESSE ICONE POSTERIORMENTE PARA FOTO DO PROFESSOR

  // TODO: ESSA linha1 DEVE RECEBER UM PARAMETRO COM O NOME DO COORDENADOR
  final String linha1;
  final String linha2;

  @override
  State<PainelBemVindo> createState() => _PainelBemVindoState();
}

class _PainelBemVindoState extends State<PainelBemVindo> {
  @override
  Widget build(BuildContext context) {
    return Container(
      constraints: const BoxConstraints.expand(
        height: 120,
      ),
      alignment: Alignment.bottomCenter,
      padding: EdgeInsets.only(left: 15, right: 20),
      decoration: BoxDecoration(color: Colors.white),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Column(
            children: [
              Image(
                image: widget.logoSenac,
                height: 80,
                width: 120,
              ),
              Text(
                'FACULDADE',
                style: TextStyle(
                  color: Color(0xFF005594),
                  fontSize: 12
                ),
              ),
            ],
          ),
          Container(
            height: 60,
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                ImageCoordenador(
                    imageProvider: AssetImage('assets/author_katz.jpeg')),
                SizedBox(
                  width: 10,
                ),
                Column(
                  children: [
                    SizedBox(
                      height: 20,
                    ),
                    Text(widget.linha1),
                    Text(widget.linha2),
                  ],
                )
              ],
            ),
          )
        ],
      ),
    );
  }
}
