package com.choucair.app.models;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LoginModel {
    String usuario;
    String contrasena;

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }


    public static List<LoginModel> setData(DataTable dataTable) {
        List<LoginModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, LoginModel.class));
        }
        return dates;
    }
}

