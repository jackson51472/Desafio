package Desafio3;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

class Challenge {
    public static String escolheTaxi(String tf1, String vqr1, String tf2, String vqr2) {
        double tarifaUm = Double.parseDouble(tf1);
        double valorKM1 = Double.parseDouble(vqr1);
        double tarifaDois = Double.parseDouble(tf2);
        double valorKM2 = Double.parseDouble(vqr2);

        DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
        df.setMinimumFractionDigits(1);
        df.setMaximumFractionDigits(2);

        if (tarifaUm == tarifaDois && valorKM1 == valorKM2) {
            return "Tanto faz";
        }

        if (valorKM1 == valorKM2) {
            return tarifaUm < tarifaDois ? "Empresa 1" : "Empresa 2";
        }

        double equilibrio = (tarifaDois - tarifaUm) / (valorKM1 - valorKM2);

        if (equilibrio > 0) {
            if (valorKM1 > valorKM2) {
                return String.format(Locale.US,
                        "Empresa 1 quando a distância < %s, Tanto faz quando a distância = %s, Empresa 2 quando a distância > %s",
                        df.format(equilibrio), df.format(equilibrio), df.format(equilibrio));
            } else {
                return String.format(Locale.US,
                        "Empresa 2 quando a distância < %s, Tanto faz quando a distância = %s, Empresa 1 quando a distância > %s",
                        df.format(equilibrio), df.format(equilibrio), df.format(equilibrio));
            }
        }

        return valorKM1 < valorKM2 ? "Empresa 1" : "Empresa 2";
    }
}
