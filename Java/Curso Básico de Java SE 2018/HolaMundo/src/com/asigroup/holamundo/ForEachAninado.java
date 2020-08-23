package com.asigroup.holamundo;

public class ForEachAninado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        //Definimos un array de 3 filas x 5 columnas
        int array[][]={{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
 
        //Recorremos el array multidimensional
        for (int[] arrayInterno : array){
            for(int numero: arrayInterno){
                System.out.println(numero);
            }
        }

	}

}