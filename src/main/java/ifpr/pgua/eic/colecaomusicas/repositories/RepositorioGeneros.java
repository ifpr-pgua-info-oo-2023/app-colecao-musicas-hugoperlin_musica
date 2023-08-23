package ifpr.pgua.eic.colecaomusicas.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.daos.GeneroDAO;
import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;
import ifpr.pgua.eic.colecaomusicas.models.Genero;

public class RepositorioGeneros {
    
    private ArrayList<Genero> generos;
    
    private GeneroDAO dao;

    public RepositorioGeneros(GeneroDAO dao){
        this.dao = dao;
        generos = new ArrayList<>();
    }

    public String cadastrarGenero(String nome){
        if(nome.isBlank() || nome.isEmpty()){
            return "Nome inválido!";
        }

        Genero genero = new Genero(nome);
        Resultado resultado = dao.criar(genero);
        return resultado.getMsg();
    }

    public ArrayList<Genero> listarGeneros() {
        return null;
        /*try{
            Connection con = fabricaConexoes.getConnection();

            String sql = "SELECT * FROM generos";

            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            ArrayList<Genero> lista = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                Genero genero = new Genero(id,nome);

                lista.add(genero);
            }

            return lista;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }*/
    }

}
