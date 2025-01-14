package robolini.paolo.zodiaco;

import java.time.LocalDate;

public class ZodiacoConverter {
    private final int giorno;
    private final int mese;
    private final LocalDate data;

    public ZodiacoConverter(LocalDate data){
        this.data = data;
        this.giorno = data.getDayOfMonth();
        this.mese = data.getMonthValue();
    }

    public String getSegno(){
        switch (mese) {
            case 1 -> {
                if (giorno < 20) {
                    return "capricorno";
                } else {
                    return "acquario";
                }
            }
            case 2 -> {
                if (giorno < 20) {
                    return "acquario";
                } else {
                    return "pesci";
                }
            }
            case 3 -> {
                if (giorno < 21) {
                    return "pesci";
                } else {
                    return "ariete";
                }
            }
            case 4 -> {
                if (giorno < 20) {
                    return "ariete";
                } else {
                    return "toro";
                }
            }
            case 5 -> {
                if (giorno < 20) {
                    return "toro";
                } else {
                    return "gemelli";
                }
            }
            case 6 -> {
                if (giorno < 21) {
                    return "gemelli";
                } else {
                    return "cancro";
                }
            }
            case 7 -> {
                if (giorno < 22) {
                    return "cancro";
                } else {
                    return "leone";
                }
            }
            case 8 -> {
                if (giorno < 24) {
                    return "leone";
                } else {
                    return "vergine";
                }
            }
            case 9 -> {
                if (giorno < 23) {
                    return "vergine";
                } else {
                    return "bilancia";
                }
            }
            case 10 -> {
                if (giorno < 23) {
                    return "bilancia";
                } else {
                    return "scorpione";
                }
            }
            case 11 -> {
                if (giorno < 22) {
                    return "scorpione";
                } else {
                    return "sagittario";
                }
            }
            case 12 -> {
                if (giorno < 22) {
                    return "sagittario";
                } else {
                    return "capricorno";
                }
            }
            default -> {
                return "Errore";
            }
        }
    }

    public String getSegnoAscendente(){
        double oraSiderale = (24.0 * data.getDayOfYear()) / 365;
        if (oraSiderale >= 6 && oraSiderale < 8) return "Ariete";
        if (oraSiderale >= 8 && oraSiderale < 10) return "Toro";
        if (oraSiderale >= 10 && oraSiderale < 12) return "Gemelli";
        if (oraSiderale >= 12 && oraSiderale < 14) return "Cancro";
        if (oraSiderale >= 14 && oraSiderale < 16) return "Leone";
        if (oraSiderale >= 16 && oraSiderale < 18) return "Vergine";
        if (oraSiderale >= 18 && oraSiderale < 20) return "Bilancia";
        if (oraSiderale >= 20 && oraSiderale < 22) return "Scorpione";
        if (oraSiderale >= 22 || oraSiderale < 2) return "Sagittario";
        if (oraSiderale >= 2 && oraSiderale < 4) return "Capricorno";
        if (oraSiderale >= 4 && oraSiderale < 6) return "Acquario";
        return "Pesci";
    }
}
