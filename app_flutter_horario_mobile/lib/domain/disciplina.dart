import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class Disciplina extends ChangeNotifier {
  String? _nome;
  String? _sigla;
  int? _quantidadePeriodo;
  int? _cargaHoraria;

  Disciplina({cargaHoraria, nome, quantidadePeriodo, sigla});

  String? get nome => _nome;
  set nome(String? value) {
    _nome = value;
    notifyListeners();
  }

  String? get sigla => _sigla;

  set sigla(String? value) {
    _sigla = value;
    notifyListeners();
  }

  int? get quantidadePeriodo => _quantidadePeriodo;

  set quantidadePeriodo(int? value) {
    _quantidadePeriodo = value;
    notifyListeners();
  }

  int? get cargaHoraria => _cargaHoraria;

  set cargaHoraria(int? value) {
    _cargaHoraria = value;
    notifyListeners();
  }
}
