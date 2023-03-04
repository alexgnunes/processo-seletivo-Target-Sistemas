package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        Map<Integer, Double> faturamento = new HashMap<>();

        double menorFaturamento = 1000000.0;
        double maiorFaturamento = 0.0;
        double mediaFaturamento = 0.0;
        double totalFaturamento = 0.0;
        int diaMaiorFaturamento = 0;
        int diaMenorFaturamento = 100;
        int totalDiaMes = 0;
        int countDiasAcimaMedia = 0;


        try {
            jsonArray = (JSONArray) parser.parse(new FileReader("dados.json"));

            for (Object objeto : jsonArray) {
                JSONObject jsonObject = (JSONObject) objeto;
                int dia = Integer.parseInt(jsonObject.get("dia").toString());
                double valor = Double.parseDouble(jsonObject.get("valor").toString());
                faturamento.put(dia, valor);
            }
            for (Map.Entry<Integer, Double> entry : faturamento.entrySet()) {
                int dia = entry.getKey();
                double valor = entry.getValue();

                if ((valor < menorFaturamento) && (valor != 0.0)) {
                    diaMenorFaturamento = dia;
                    menorFaturamento = valor;
                }

                if (valor > maiorFaturamento) {
                    diaMaiorFaturamento = dia;
                    maiorFaturamento = valor;
                }

                if ((dia > totalDiaMes) && (valor != 0.0)) {
                    totalDiaMes++;
                    totalFaturamento += valor;
                }
            }

            mediaFaturamento = totalFaturamento/ totalDiaMes;

            for (Map.Entry<Integer, Double> entry : faturamento.entrySet()) {
                double valor = entry.getValue();

                if (valor > mediaFaturamento) {
                    countDiasAcimaMedia++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("O menor valor de faturamento ocorrido foi no dia: " + diaMenorFaturamento + " no valor de: " + menorFaturamento);
        System.out.println("O maior valor de faturamento ocorrido foi no dia: " + diaMaiorFaturamento + " no valor de: " + maiorFaturamento);
        System.out.println("O total de dias em que o valor de faturamento diário foi superior à média mensal é " + countDiasAcimaMedia + " dias");
    }
}