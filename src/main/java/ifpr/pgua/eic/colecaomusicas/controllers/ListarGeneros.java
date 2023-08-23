package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.colecaomusicas.models.Genero;
import ifpr.pgua.eic.colecaomusicas.models.Repositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ListarGeneros implements Initializable {

    @FXML
    private ListView<Genero> lstGeneros;

    private Repositorio repositorio;

    public ListarGeneros(Repositorio repositorio){
        this.repositorio = repositorio;
    }

    @FXML
    void voltar(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        lstGeneros.getItems().clear();
        lstGeneros.getItems().addAll(repositorio.listarGeneros());
    
    }

}
