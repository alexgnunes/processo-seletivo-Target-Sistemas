package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            jsonArray = (JSONArray) parser.parse(new FileReader("dados.json"));

            for (Object objeto : jsonArray) {
                JSONObject jsonObject = (JSONObject) objeto;
                int dia = Integer.parseInt(jsonObject.get("dia").toString());
                double valor = Double.parseDouble(jsonObject.get("valor").toString());
                System.out.println("Dia: " + dia + ", Valor: " + valor);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }
}