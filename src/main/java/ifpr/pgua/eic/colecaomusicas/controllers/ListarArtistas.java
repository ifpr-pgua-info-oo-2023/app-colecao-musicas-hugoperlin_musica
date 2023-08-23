package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.Genero;
import ifpr.pgua.eic.colecaomusicas.repositories.RepositorioArtistas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ListarArtistas implements Initializable {

    @FXML
    private ListView<Artista> lstArtistas;

    private RepositorioArtistas repositorio;

    public ListarArtistas(RepositorioArtistas repositorio){
        this.repositorio = repositorio;
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        lstArtistas.getItems().clear();
        lstArtistas.getItems().addAll(repositorio.listarArtistas());
    
    }

}
