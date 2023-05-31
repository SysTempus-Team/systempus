import 'package:app_flutter_horario_mobile/domain/coordenador.dart';
import 'package:app_flutter_horario_mobile/domain/modulo.dart';

class Curso {
  int? _id;
  String? _nome;
  String? _nivelEnsino;
  String? _qdtPeriodos;
  String? _modalidade;
  int? _cargaTotal;
  Coordenador? _coordenador;
  List<Modulo>? _modulos;

  Curso(
      {int? id,
      String? nome,
      String? nivelEnsino,
      String? qdtPeriodos,
      String? modalidade,
      int? cargaTotal,
      Coordenador? coordenador,
      List<Modulo>? modulos});

  int? get id => this._id;

  set id(int? value) => this._id = value;

  get nome => this._nome;

  set nome(value) => this._nome = value;

  get nivelEnsino => this._nivelEnsino;

  set nivelEnsino(value) => this._nivelEnsino = value;

  get qdtPeriodos => this._qdtPeriodos;

  set qdtPeriodos(value) => this._qdtPeriodos = value;

  get modalidade => this._modalidade;

  set modalidade(value) => this._modalidade = value;

  get cargaTotal => this._cargaTotal;

  set cargaTotal(value) => this._cargaTotal = value;

  get coordenador => this._coordenador;

  set coordenador(value) => this._coordenador = value;

  get modulos => this._modulos;

  set modulos(value) => this._modulos = value;
}
