package ifpr.pgua.eic.colecaomusicas.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;

public class RepositorioArtistas {
    
    private ArrayList<Artista> artistas;

    private FabricaConexoes fabricaConexoes;

    public RepositorioArtistas(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
        artistas = new ArrayList<>();
    }

    public String cadastrarArtista(String nome, String contato){

        try{
            Connection con = fabricaConexoes.getConnection();
            
            String sql = "INSERT INTO artistas(nome,contato) VALUES (?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2, contato);

            pstm.executeUpdate();

            return "Artista cadastrado com sucesso!!";

        }catch(SQLException e){
            return e.getMessage();
        }
    }


    public ArrayList<Artista> listarArtistas(){
        try{
            Connection con = fabricaConexoes.getConnection();
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM artistas");

            ResultSet rs = pstm.executeQuery();

            ArrayList<Artista> lista = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String contato = rs.getString("contato");

                Artista artista = new Artista(id,nome, contato);
                lista.add(artista);
            }

            rs.close();
            pstm.close();
            con.close();

            return lista;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
