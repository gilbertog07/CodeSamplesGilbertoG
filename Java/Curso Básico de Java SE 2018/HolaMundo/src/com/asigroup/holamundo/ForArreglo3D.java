package com.asigroup.holamundo;

public class ForArreglo3D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Arreglo 3D de 4 filas x 4 columnas x 2 niveles:");
		System.out.println("");

		int[][][] numeros = {

                                {
                                  {3, 6},
                                  {9, 12},
                                  {15, 18},
                                  {21, 24}
                                 },
				                {
                                  {6, 12},
                                  {18, 24},
                                  {30, 36},
                                  {42, 48}
                                 },
				                {
        		            	  {9, 18},
                                  {27, 36},
                                  {45, 54},
                                  {63, 72} 
                                 },
 				                {
 	        		              {12, 24},
 	                              {36, 48},
 	                              {60, 72},
 	                              {84, 96}
 	                             }

		                      };

		System.out.println("Recorrido For:");
		System.out.println("");

		for(int x = 0; x < numeros.length; x++) {
			for(int y = 0; y < numeros[0].length; y++) {
				for(int z = 0; z < numeros[0][0].length; z++) {
					System.out.println("numeros["+ x +"]["+ y +"]["+ z +"]: " + numeros[x][y][z]);
				}
			}
		}

		System.out.println("");
		System.out.println("Recorrido ForEach:");
		System.out.println("");

		for(int[][] x: numeros) {
        	for(int[] y: x) {
        		for(int z: y) {
        			System.out.println(z);
        		}
        	}
        }

	}

}