package uf3.AguirreAntonio;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Districte {
    int districte;
    String barris;
    double total;
    double homes;
    double dones;
    static ArrayList<Districte> districteArrayList= new ArrayList<>();


    public Districte(String[] linea) {

        if( linea[1]==""||linea[1].isEmpty()){
            this.districte = 0;
        }else{
            this.districte = parseInt(linea[1]);
        }
        this.barris = linea[3];
        this.total = parseDouble(linea[4]);
        this.homes = parseDouble(linea[5]);
        this.dones = parseDouble(linea[6]);

        districteArrayList.add(this);
    }


    public int getDistricte() {
        return districte;
    }
    public String getBarris() {
        return barris;
    }
    public double getTotal() {
        return total;
    }
    public double getHomes() {
        return homes;
    }
    public double getDones() {
        return dones;
    }
    @Override
    public String toString() {
        return "Districte{" +
                "districte=" + districte +
                ", barris='" + barris + '\'' +
                ", total=" + total +
                ", homes=" + homes +
                ", dones=" + dones +
                '}';
    }
}
