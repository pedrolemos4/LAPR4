package eapli.base.colaborador.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LerFicheiroColaborador {

    public Map<Integer,List<String>> lerDados(final String nomeFicheiro) throws FileNotFoundException {
        Map<Integer,List<String>> mapa = new TreeMap<>();
        List<String> list = new ArrayList<>();
        String linha;
        int cont=0;
        Scanner ler = new Scanner(new File(nomeFicheiro));

        while(ler.hasNextLine()){
            linha = ler.nextLine();
            String[] split = linha.split(",");


            for(int i=0;i<split.length;i++){
                list.add(split[i]);
            }
            mapa.put(cont,list);
            cont++;
        }
        ler.close();
        return mapa;
    }

}
