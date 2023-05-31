import 'package:app_flutter_horario_mobile/domain/curso.dart';
import 'package:app_flutter_horario_mobile/domain/profissional.dart';

class Coordenador extends Profissional {
  List<Curso>? _cursos;

  Coordenador({List<Curso>? cursos});

  get cursos => this._cursos;

  set cursos(value) => this._cursos = value;
}
