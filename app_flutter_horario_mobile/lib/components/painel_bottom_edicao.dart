import 'package:app_flutter_horario_mobile/components/bottom_edicao.dart';
import 'package:flutter/material.dart';


class PainelButtomEdocao extends StatefulWidget {
  const PainelButtomEdocao({super.key});

  @override
  State<PainelButtomEdocao> createState() => _PainelButtomEdocaoState();
}

class _PainelButtomEdocaoState extends State<PainelButtomEdocao> {
  @override
  Widget build(BuildContext context) {
    return Expanded(
 

    
      child: 
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              ButtomEdicao(
            label: 'EDITAR', 
          color:  (0xFFF2B374),
           onPressed: (){}, 
           base: 75, 
           altura: 40),
              ButtomEdicao(
            label: 'REMOVER', 
          color:  (0xFFF2B374),
           onPressed: (){}, 
           base: 80, 
           altura: 40),
              ButtomEdicao(
            label: 'SALVAR', 
          color:  (0xFFF2B374),
           onPressed: (){}, 
           base: 75, 
           altura: 40),


            ],
          )
        
    );
  }
}