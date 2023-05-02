

import 'package:flutter/material.dart';

class CardTopoDisciplina extends StatelessWidget {
  const CardTopoDisciplina(
      {super.key,
      required this.exibirLista,
      required this.modulo,
      required this.modulos,
      required this.placeHolderModulo,
     });

  final String modulo;
  final String exibirLista;
  final String placeHolderModulo;
  final String modulos;
  

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 80,

    
    
      // TODO : O container precisa de padding?
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Stack(
            children: [
              Container(
                // TODO: ALINHAMENTO DO TEXTO DO CONTAINER
                constraints: const BoxConstraints.expand(
                  height: 40,
                  width: 150,
                ),
                decoration: BoxDecoration(
                  border:
                      Border.all(color: Colors.black, style: BorderStyle.solid),
                  color: Colors.lightBlue,
                ),
              ),
              Positioned(
                child: Text(
                  modulo,
                  style: TextStyle(
                    fontSize: 20,
                  ),

                  // TODO: FAZER ESTILO DO TEXTO
                ),
                left: 5,
                top: 5,
              ),
            ],
          ),
          Row(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              Text(
                modulos,
                // TODO: COLOCAR ESTILO DO TEXTO
              ),
              const SizedBox(
                width: 8,
              ),
              Column(
                children: [
                  Row(
                    children: [
                      Container(
                        constraints:
                            const BoxConstraints.expand(height: 30, width: 300),
                        child:  TextField(
                          decoration: InputDecoration(
                            border: OutlineInputBorder(
                              borderSide: BorderSide(
                                color: Colors.black,
                                style: BorderStyle.solid,
                              ),
                            ),
                            hintText: placeHolderModulo
                          ),
                        
                        ),
                      ),
                      Container(
                        height: 30,
                        decoration: BoxDecoration(
                            border: Border.all(
                                color: Colors.black, style: BorderStyle.solid)),
                        child: DropdownButton(
                            value: null, items: [], onChanged: (value) {}),
                      )
                    ],
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Center(
                    child: Text(
                      exibirLista,
                      // TODO: COLOCAR ESTILO DO TEXTO
                    ),
                  )
                ],
              )
            ],
          )
        ],
      ),
    );
  }
}
