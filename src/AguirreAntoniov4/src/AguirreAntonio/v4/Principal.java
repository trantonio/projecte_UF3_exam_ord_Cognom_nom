package AguirreAntoniov4.src.AguirreAntonio.v4;


import java.io.File;

import static AguirreAntoniov4.src.ExamenUF3.poblacioImmigrantCompactHTML;


public class Principal {

    static final String INPUT_DIR="data/in";
    static final String OUTPUT_DIR="data/out";
    static final String FILE_NAME="emigraciosexe2012_asequible";
    static final String FS = File.separator;

    public static void main(String[] args) {

        // TODO comprovar què els arguments sòn correctes
        poblacioImmigrantCompactHTML(
                INPUT_DIR+FS+FILE_NAME+".csv",
                OUTPUT_DIR+FS+FILE_NAME+".html", // o ".html"
                ':',
                '"'
                );

    }

}
