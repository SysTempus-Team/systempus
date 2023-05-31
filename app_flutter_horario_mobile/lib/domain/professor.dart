import 'package:app_flutter_horario_mobile/domain/curso.dart';
import 'package:app_flutter_horario_mobile/domain/disciplina.dart';
import 'package:app_flutter_horario_mobile/domain/profissional.dart';

class Professor extends Profissional {
  List<Disciplina>? _disciplinas;
  List<Curso>? _cursos;

  Professor({List<Disciplina>? disciplinas, List<Curso>? cursos});

  List<Disciplina>? get disciplinas => this._disciplinas;

  set disciplinas(List<Disciplina>? value) => this._disciplinas = value;

  get cursos => this._cursos;

  set cursos(value) => this._cursos = value;
}
