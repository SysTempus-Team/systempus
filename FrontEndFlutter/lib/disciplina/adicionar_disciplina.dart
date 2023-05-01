import 'package:flutter/material.dart';

class AdicionarDisciplina extends StatelessWidget {
  const AdicionarDisciplina(
      {super.key, required this.modulo, required this.cadastroModulo});

  final String modulo;
  final String cadastroModulo;

  @override
  Widget build(BuildContext context) {
    return Container(

    
  
      
      constraints:const BoxConstraints.expand( height: 150),
      child: Row(

        mainAxisAlignment: MainAxisAlignment.start,
         crossAxisAlignment: CrossAxisAlignment.stretch,
         
        children: [
          Column(
            children: [
              Stack(
                children: [
                  Container(
                   
                    // TODO: ALINHAMENTO DO TEXTO DO CONTAINER
                    constraints: const BoxConstraints.expand(
                      height: 40,
                      width: 200,
                    ),
                    decoration: BoxDecoration(
                      border: Border.all(
                          color: Colors.black, style: BorderStyle.solid),
                      color: Colors.lightGreen,
                    ),
                  ),
                  Positioned(
                    child: Text(
                      modulo,
                      style: TextStyle(
                        fontSize: 16,
                      ),

                      // TODO: FAZER ESTILO DO TEXTO
                    ),
                    top:10,
                    left: 50,
                    right: 0,
                  
                  ),
                  Positioned(
                    child: IconButton(
                      icon: const Icon(Icons.add_circle_outlined),
                      onPressed: () {},
                    ),
                    left: 5,
                    top: 3,
                  ),
                ],
              ),
             Center(
              child:  Text(
                cadastroModulo,
                // TODO: DEFINIR O ESTILO DO TEXTO
              ),
             )
            ],
          ),
        
        
        ],
      ),
      
    );
  }
}
