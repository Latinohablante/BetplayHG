package com.ligabetplay.controller;

import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

import com.ligabetplay.model.entity.Equipo;
import com.ligabetplay.model.entity.Jugador;

public class Keyunique {
    // Llave unica para Equipos
    public static int generateUniqueKeyT(Hashtable<Integer, Equipo> hashtable){
        do {
            int randomInt = ThreadLocalRandom.current().nextInt(0, 100);
            if(!hashtable.containsKey(randomInt)) {
                return randomInt;
            }
        } while (true);
    }
    // Llave unica para Jugadores
    public static int generateUniqueKeyJ(Hashtable<Integer, Jugador> hashtable){
        do {
            int randomInt = ThreadLocalRandom.current().nextInt(0, 100);
            if(!hashtable.containsKey(randomInt)) {
                return randomInt;
            }
        } while (true);
    }
}
