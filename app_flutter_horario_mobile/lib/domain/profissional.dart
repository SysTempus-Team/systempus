class Profissional {
  int? _id;
  String? _cpf;
  String? _nome;
  String? _telefone;

  Profissional({int? id, String? cpf, String? nome, String? telefone});

  get id => this._id;

  set id(value) => this._id = value;

  get cpf => this._cpf;

  set cpf(value) => this._cpf = value;

  get nome => this._nome;

  set nome(value) => this._nome = value;

  get telefone => this._telefone;

  set telefone(value) => this._telefone = value;
}
