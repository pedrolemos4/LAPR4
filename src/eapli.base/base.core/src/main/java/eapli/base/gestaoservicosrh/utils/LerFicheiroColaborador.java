package eapli.base.gestaoservicosrh.utils;

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
            String username = split[0];
            String password = split[1];
            String firstName=split[2];
            String lastName = split[3];
            String email = split[4];
            int number = Integer.parseInt(split[5]);
            String fullName = split[6];
            String shortName = split[7];
            String data = split[8];
            int prefix = Integer.parseInt(split[9]);
            int contacto = Integer.parseInt(split[10]);
            String residencia = split[11];
            String roles = split[12]; //Separado por espaços

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
