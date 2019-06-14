import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Districte {
    int districte;
    private ArrayList<String> barris=new ArrayList<String>();
    double total;
    double homes;
    double dones;
    static ArrayList<Districte> districteArrayList= new ArrayList<>();
    static ArrayList<String> conjuntoBarrios = new ArrayList<>();

    public Districte(String[] linea) {


        if( linea[1]==""||linea[1].isEmpty()){
            this.districte = 0;
        }else{
            this.districte = parseInt(linea[1]);
        }
        separarBarris(linea[3]);
        this.total = parseDouble(linea[4]);
        this.homes = parseDouble(linea[5]);
        this.dones = parseDouble(linea[6]);

        districteArrayList.add(this);

    }

    public int getDistricte() {
        return districte;
    }

    public void separarBarris(String nombre) {
        barris.add(nombre.replaceAll("^[0-9]+[.] ","").replaceAll("^el |^la |^els |^les |^l'",""));
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
    public String getHomesPorcentaje(){
        return (homes/(float)total)*100+"%";
    }

    public String getDonesPorcentajes(){
        return (dones/(float)total)*100+"%";
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
