import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        double faturamentoTotal = 0.0;

        Map<String, Double> faturamentoEstado = new LinkedHashMap<>() {{
            put("SP", 67836.43);
            put("RJ", 36678.66);
            put("MG", 29229.88);
            put("ES", 27165.48);
            put("Outros", 19849.53);
        }};

        for (Map.Entry<String, Double> entry : faturamentoEstado.entrySet()){
            faturamentoTotal += entry.getValue();
        }

        for (Map.Entry<String, Double> entry : faturamentoEstado.entrySet()){
            double porcentagem = (faturamentoEstado.get(entry.getKey()) / faturamentoTotal) * 100;
            System.out.printf("%s representa %.2f%% do total de faturamento\n", entry.getKey(), porcentagem);
        }
    }
}