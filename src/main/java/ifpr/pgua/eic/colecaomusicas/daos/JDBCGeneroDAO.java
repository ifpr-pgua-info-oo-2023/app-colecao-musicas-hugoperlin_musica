package ifpr.pgua.eic.colecaomusicas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;
import ifpr.pgua.eic.colecaomusicas.models.Genero;

public class JDBCGeneroDAO implements GeneroDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCGeneroDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Resultado criar(Genero genero) {
        try {
            Connection con = fabricaConexoes.getConnection();

            String sql = "INSERT INTO generos(nome) VALUES (?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, genero.getNome());

            pstm.executeUpdate();

            return Resultado.sucesso("Gênero cadastrado com sucesso!", genero);

        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Resultado atualizar(int id, Genero novo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Resultado deletar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

}
