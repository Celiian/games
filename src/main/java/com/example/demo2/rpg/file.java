package com.example.demo2.rpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class file {

    public static List<String> file() {
        List<String> lineList = new ArrayList<String>();

        try {
            File file = new File("./src/com/company/hero_config");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                lineList.add(line);
            }
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineList;
    }

    public static Map<Integer, Map<String, String>> read(String line, Map<Integer, Map<String, String>> heroTab, int y){
        Map<String, String> hero = new HashMap<String, String>();
        ArrayList<String> liste = new ArrayList<String>();


        final String SEPARATOR1 = "-";
        final String SEPARATOR2 = ":";

        String[] mots = line.split(SEPARATOR1);

        String mot1 = "";
        String mot2 = "";

        for (int i = 0; i < mots.length; i++){
            liste.add(mots[i]);
        }


        for(int x = 0; x < liste.size(); x++){
            String[] mot = liste.get(x).split(SEPARATOR2);
            for (int z = 0; z < mot.length; z += 2){
                hero.put(mot[z], mot[z+1]);
            }
        }


        heroTab.put(y, hero);
        return heroTab;
    }

    public static ArrayList<String> separator(String line){
        ArrayList<String> liste = new ArrayList<String>();

        final String SEPARATOR = "=";
        String[] mot = line.split(SEPARATOR);
        for (int x = 0; x < mot.length; x += 2){
            liste.add(mot[x]);
            liste.add(mot[x+1]);
        }
        return liste;
    }
}