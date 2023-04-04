import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:tela01/ResponsiveRow.dart';

class Page01 extends StatefulWidget {
  const Page01({super.key});

  @override
  State<Page01> createState() => _Page01State();
}

class _Page01State extends State<Page01> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            Row(
              children: <Widget>[
                Expanded(
                  child: Image.asset(
                    'images/senac-logo.png',
                    width: 100.0,
                    height: 100.0,
                  ),
                ),
                const Expanded(
                  child: Icon(
                    Icons.account_circle,
                    size: 60.00,
                  ),
                ),
                SizedBox(
                  width: 50,
                ),
                const Expanded(
                  child: Text(
                    'Coordenador, bem vindo ao Sistema',
                  ),
                ),
                SizedBox(
                  width: 100,
                ),
                Expanded(
                  child: ConstrainedBox(
                    constraints: const BoxConstraints(maxWidth: 200),
                    child: TextField(
                      decoration: InputDecoration(
                        border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(10),
                            borderSide: const BorderSide(color: Colors.grey)),
                      ),
                    ),
                  ),
                ),
                const SizedBox(
                  width: 20,
                ),
              ],
            ),
            const SizedBox(
              height: 100,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: <Widget>[
                SizedBox(
                  width: 150,
                ),
                //Container(color: Colors.blue, width: 50, height: 50),
                Flexible(
                  flex: 3,
                  child: ConstrainedBox(
                    constraints: const BoxConstraints(maxWidth: 200),
                    child: TextField(
                      decoration: InputDecoration(
                        border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(10),
                            borderSide: const BorderSide(color: Colors.grey)),
                      ),
                    ),
                  ),
                ),
                // Container(color: Colors.blue, width: 50, height: 50),
                // Spacer(),
              ],
            ),
            const SizedBox(
              height: 50,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: <Widget>[
                const SizedBox(width: 150),
                Flexible(
                  child: SizedBox(
                    width: 100.0,
                    height: 70.00,
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.blue[200],
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0),
                        ),
                      ),
                      child: const Text(
                        'Professor',
                        style: TextStyle(color: Colors.black),
                      ),
                    ),
                  ),
                ),
                const SizedBox(
                  width: 40,
                ),
                Flexible(
                  child: SizedBox(
                    width: 100.0,
                    height: 70.00, // Define a altura do botão como 50 pontos
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0),
                        ),
                      ),
                      child: const Text('Turno'),
                    ),
                  ),
                ),
                const SizedBox(
                  width: 40,
                ),
                Flexible(
                  child: SizedBox(
                    width: 100.0, // Define a largura do botão como 150 pontos
                    height: 70.00, // Define a altura do botão como 50 pontos
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0),
                        ),
                      ),
                      child: const Text('Curso'),
                    ),
                  ),
                ),
                const SizedBox(
                  width: 40,
                ),
                Flexible(
                  child: SizedBox(
                    width: 100.0, // Define a largura do botão como 150 pontos
                    height: 70.00, // Define a altura do botão como 50 pontos
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0),
                        ),
                      ),
                      child: const Text('Modulo'),
                    ),
                  ),
                ),
                Spacer(),
              ],
            ),
            const SizedBox(
              height: 50,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: <Widget>[
                SizedBox(
                  width: 150,
                ),
                Flexible(
                  child: SizedBox(
                    width: 100.0, // Define a largura do botão como 150 pontos
                    height: 70.0, // Define a altura do botão como 50 pontos
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0),
                        ),
                      ),
                      child: const Text('Turma'),
                    ),
                  ),
                ),
                const SizedBox(
                  width: 40,
                ),
                Flexible(
                  child: SizedBox(
                    width: 100.0, // Define a largura do botão como 150 pontos
                    height: 70.0, // Define a altura do botão como 50 pontos
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0),
                        ),
                      ),
                      child: const Text('Disciplina'),
                    ),
                  ),
                ),
                const SizedBox(
                  width: 40,
                ),
                Flexible(
                  child: SizedBox(
                    width: 100.0, // Define a largura do botão como 150 pontos
                    height: 70.0, // Define a altura do botão como 50 pontos
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0),
                        ),
                      ),
                      child: const Text('Carga Horária Total'),
                    ),
                  ),
                ),
                const SizedBox(
                  width: 40,
                ),
                Flexible(
                  child: SizedBox(
                    width: 100.0, // Define a largura do botão como 150 pontos
                    height: 70.0, // Define a altura do botão como 50 pontos
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0),
                        ),
                      ),
                      child: const Text('Relatório'),
                    ),
                  ),
                ),
                Spacer(),
              ],
            ),
            const SizedBox(
              height: 50,
            ),
           ResponsiveRow(
  children: [
    Container(color: Colors.red, height: 100),
    Container(color: Colors.blue, height: 100),
    Container(color: Colors.green, height: 100),
  ],
),
            const SizedBox(
              height: 70,
            ),
          ],
        ),
      ),
    );
  }
}
