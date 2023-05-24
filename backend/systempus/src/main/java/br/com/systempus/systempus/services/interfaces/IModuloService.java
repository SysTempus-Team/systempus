package br.com.systempus.systempus.services.interfaces;

import java.util.List;
import java.util.Map;

import br.com.systempus.systempus.domain.Modulo;

public interface IModuloService {
    public List<Modulo> getAll();

    public Modulo getOne(Integer id);

    public void save(Modulo modulo);

    public void delete(Integer id);

    public void update(Modulo modulo);

    public Modulo updatePartial(Map<String, Object> mapValores, Integer id);
}
