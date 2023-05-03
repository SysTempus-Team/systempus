import 'package:flutter/material.dart';

class InputDisciplina extends StatelessWidget {
  const InputDisciplina({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      constraints: BoxConstraints.expand(width: 800, height: 100),
      child: Column(
        children: [
          Container(
            constraints: const BoxConstraints.expand(height: 30, width: 800),
            child: const TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(
                  borderSide: BorderSide(
                    color: Colors.black,
                    style: BorderStyle.solid,
                  ),
                ),
              ),
            ),
          ),
          const SizedBox(height: 10,),
          Container(
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                  constraints:
                      const BoxConstraints.expand(height: 30, width: 395),
                  child: const TextField(
                    decoration: InputDecoration(
                      border: OutlineInputBorder(
                        borderSide: BorderSide(
                          color: Colors.black,
                          style: BorderStyle.solid,
                        ),
                      ),
                    ),
                  ),
                ),
                Container(
                  constraints:
                      const BoxConstraints.expand(height: 30, width: 395),
                  child: const TextField(
                    decoration: InputDecoration(
                      border: OutlineInputBorder(
                        borderSide: BorderSide(
                          color: Colors.black,
                          style: BorderStyle.solid,
                        ),
                      ),
                    ),
                  ),
                ),
              ],
            ),
          )
        ],
      ),
    );
  }
}
