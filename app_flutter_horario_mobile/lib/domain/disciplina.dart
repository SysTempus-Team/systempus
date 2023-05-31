import 'package:app_flutter_horario_mobile/domain/modulo.dart';
import 'package:app_flutter_horario_mobile/domain/professor.dart';



class Disciplina   {
  int? _id;
  String? _nome;
  Modulo? _modulo;
  List<Professor>? _professores;

    Disciplina(
      { int? id,
  String? nome,
  Modulo? modulo,
  List<Professor>? professores});
 
  get id => this._id;

 set id( value) => this._id = value;

  get nome => this._nome;

 set nome( value) => this._nome = value;

  get modulo => this._modulo;

 set modulo( value) => this._modulo = value;

  get professores => this._professores;

 set professores( value) => this._professores = value;


   
  

  
  }

