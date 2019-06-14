package AguirreAntoniov4.src;
//importo los paquetes que necesito

import java.util.ArrayList;
import java.util.Objects;

//en esta clase sera donde realizo todos las operaciones
public class Districte implements Comparable<Districte> {
    private String idDistricte;
    private ArrayList<String> carrers=new ArrayList<String>();
    private int total, homes, dones;


    //creo el constructor
    public Districte(String idDistricte) {
        this.idDistricte = idDistricte;

    }

    //creo los getters y setters para poder trabajar mas comodamente
    public String getIdDistricte() {
        return idDistricte;
    }

    public void setIdDistricte(String idDistricte) {
        this.idDistricte = idDistricte;
    }

    public void addCarrer(String nom, int total, int homes, int dones){
        carrers.add(nom.replaceAll("^[0-9]+[.] ","").replaceAll("^el |^la |^els |^les |^l'",""));
        this.total+=total;
        this.homes+=homes;
        this.dones+=dones;
    }

    public ArrayList<String> getCarrers() {
        return carrers;
    }

    public int getTotal() {
        return total;
    }

    public String percHomes(){
        return (homes/(float)total)*100+"%";
    }

    public String percDones(){
        return (dones/(float)total)*100+"%";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Districte districte = (Districte) o;
        return Objects.equals(idDistricte, districte.idDistricte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistricte);
    }

    @Override
    public int compareTo(Districte d) {
        return d.total-total;
    }
}