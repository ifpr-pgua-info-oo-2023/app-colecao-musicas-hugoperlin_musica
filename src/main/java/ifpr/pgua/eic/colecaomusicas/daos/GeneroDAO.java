package ifpr.pgua.eic.colecaomusicas.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.models.Genero;

public interface GeneroDAO {
    Resultado criar(Genero genero);
    Resultado listar();
    Resultado atualizar(int id, Genero novo);
    Resultado deletar(int id);
}
