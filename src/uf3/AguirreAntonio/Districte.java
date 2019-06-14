package uf3.AguirreAntonio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Districte implements Comparable<Districte>{
    int districte;
    private ArrayList<String> barris=new ArrayList<String>();
    int total;
    int homes;
    int dones;
    static ArrayList<Districte> districteArrayList= new ArrayList<>();
    static ArrayList<String> conjuntoBarrios = new ArrayList<>();
    NumberFormat nf = new DecimalFormat("##");

    public Districte(String[] linea) {


        if( linea[1]==""||linea[1].isEmpty()||linea[4]==""||linea[4].isEmpty()||linea[5]==""||linea[5].isEmpty()||linea[6]==""||linea[6].isEmpty()){
            this.districte = 0;
            this.total=0;
            this.homes=0;
            this.dones=0;
        }else{
            this.districte = parseInt(linea[1]);
            this.total = parseInt(linea[4].replace(".",""));
            this.homes = parseInt(linea[5].replace(".",""));
            this.dones = parseInt(linea[6].replace(".",""));
        }
        separarBarris(linea[3]);
        districteArrayList.add(this);

    }

    public int getDistricte() {
        return districte;
    }

    public void separarBarris(String nombre) {
        barris.add(nombre.replaceAll("^[0-9]+[.] ","").replaceAll("^el |^la |^els |^les |^l'",""));

    }
    public void addCarrer(String nom, int total, int homes, int dones){
        barris.add(nom.replaceAll("^[0-9]+[.] ","").replaceAll("^el |^la |^els |^les |^l'",""));
        this.total+=total;
        this.homes+=homes;
        this.dones+=dones;
    }
    public ArrayList<String> getBarris() {
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
    public String getPorcentaje(int hd,int total){
        return nf.format((hd/(float)total*100))+"%";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Districte districte = (Districte) o;
        return Objects.equals(districte, districte.districte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(districte);
    }

    @Override
    public int compareTo(Districte d) {
        return d.total-total;
    }
}
