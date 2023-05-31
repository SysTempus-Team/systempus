import 'package:app_flutter_horario_mobile/domain/curso.dart';
import 'package:app_flutter_horario_mobile/domain/disciplina.dart';

class Modulo {
  int? _id;
  int? _numero;
  DateTime? _dataInicio;
  DateTime? _dataFim;
  Curso? _curso;
  List<Disciplina>? _disciplinas;

  Modulo(
      {int? id,
      int? numero,
      DateTime? dataInicio,
      DateTime? dataFim,
      Curso? curso,
      List<Disciplina>? disciplinas});

  int? get id => this._id;

  set id(int? value) => this._id = value;

  get numero => this._numero;

  set numero(value) => this._numero = value;

  get dataInicio => this._dataInicio;

  set dataInicio(value) => this._dataInicio = value;

  get dataFim => this._dataFim;

  set dataFim(value) => this._dataFim = value;

  get curso => this._curso;

  set curso(value) => this._curso = value;

  get disciplinas => this._disciplinas;

  set disciplinas(value) => this._disciplinas = value;
}
