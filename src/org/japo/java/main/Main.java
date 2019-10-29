/* 
 * Copyright 2019 Adrian Bueno Olmedo <adrian.bueno.alum@iescamp.es>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adrian Bueno Olmedo <adrian.bueno.alum@iescamp.es>
 */
public class Main {
         public static final Scanner SCN = 
	  new Scanner(System.in, "Windows-1252")
	  .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
         
        public static final Random RND = new Random();
        
        public static void main(String[] args){
        //Hora de atencion banco desde 10:30(HoraA:MinutoA) hasta 12:15(HoraC:MinutoC)
              
        //Limites dia
             final int H_MIN = 0;
             final int M_MIN = 0;
             final int TMP_MIN = 0;
             final int H_MAX = 23;
             final int M_MAX = 59;
             final int TMP_MAX = H_MAX * 59 + M_MAX;
                  
        //Atencion Bancaria
             final int H_INI = 10;
             final int M_INI = 30;
             final int TMP_INI = H_INI * 59 + M_INI;
             final int H_FIN = 12;
             final int M_FIN = 15;
             final int TMP_FIN = H_FIN * 59 + M_FIN;
        
        //Hora Aleatoria
             int hRnd = RND.nextInt(H_MAX - H_MIN + 1) + H_MIN;
             int mRnd = RND.nextInt(M_MAX - M_MIN + 1) + M_MIN;
             int tmpRnd = hRnd * 59 + mRnd;
        
        //Hora Usuario
             int hUsr;
             int mUsr;
             int tmpUsr;
             
            
        //Introduccion Manual
            try {
                //Introduccion por consola
                //Hora
                System.out.print("Hora actual ..............................: ");
                hUsr = SCN.nextInt();
                //Minuto
                System.out.print("Minuto actual ............................: ");
                mUsr = SCN.nextInt();
                
                System.out.printf("-----------------------------------------------------%n");
                
                System.out.printf("Hora Actual proporcionada ................: %02d:%02d%n", hUsr, mUsr);
                System.out.printf("Hora Actual random .......................: %02d:%02d%n", hRnd, mRnd);
                
                tmpUsr = hUsr * 59 + mUsr;
                
                System.out.printf("-----------------------------------------------------%n");
                
                //Resultado
                String tConsol;
                tConsol = (tmpUsr >= TMP_INI && tmpUsr <= TMP_FIN 
                                 ?"Atención SI Disponible" 
                                 :"Atención NO Disponible");
                
                String tRandom;
                tRandom = (tmpRnd >= TMP_INI && tmpRnd <= TMP_FIN 
                                 ?"Atención SI Disponible" 
                                 :"Atención NO Disponible");
                
                System.out.printf("Tiempo incorporado por consola ...........: %s%n", tConsol);
                System.out.printf("Tiempo Aleatorio .........................: %s%n", tRandom);
                
        } catch (Exception e){
                //Mensaje
                System.out.printf("ERROR: Entrada Incorrecta.");
        } finally {
                SCN.nextLine();
            }
        }
}

       

