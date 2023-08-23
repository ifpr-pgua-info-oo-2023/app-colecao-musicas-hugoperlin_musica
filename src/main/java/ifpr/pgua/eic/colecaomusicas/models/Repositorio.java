package ifpr.pgua.eic.colecaomusicas.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Repositorio {
    
    private ArrayList<Genero> generos;
    private ArrayList<Artista> artistas;

    public Repositorio(){
        generos = new ArrayList<>();
        artistas = new ArrayList<>();
    }

    public String cadastrarGenero(String nome){
        try{
            Connection con;
            String url = "jdbc:mysql://wagnerweinert.com.br:3306/hugo";
            String username = "hugo";
            String password = "1234";
            con = DriverManager.getConnection(url,username,password);
            
            String sql = 
            "INSERT INTO generos(nome) VALUES (?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1,nome);

            pstm.executeUpdate();

            return "Gênero cadastrado com sucesso!";

        }catch(SQLException e){
            return e.getMessage();
        }
            
        
    }

    public String cadastrarArtista(String nome, String contato){

        try{
            String url = "jdbc:mysql://wagnerweinert.com.br:3306/hugo";
            String username = "hugo";
            String password = "1234";

            Connection con = DriverManager.getConnection(url, username, password);
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

    public ArrayList<Genero> listarGeneros() {
        try{
            String url = "jdbc:mysql://wagnerweinert.com.br:3306/hugo";
            String username = "hugo";
            String password = "1234";

            Connection con = DriverManager.getConnection(url, username, password);

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
        }
    }

}
