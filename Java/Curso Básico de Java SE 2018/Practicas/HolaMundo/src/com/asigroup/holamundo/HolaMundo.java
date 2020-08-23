package com.asigroup.holamundo;

public class HolaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Hola Mundo! :)");
        
        //Enteros
        byte edad = 2;
        short year = 32767;
        int id_user = 1001;
        long id_twitter = 12345678923456789L;
        
        //Punto Flotante
        float diametro = 34.25f;
        double precio = 12345.3883844456788383;

        //Texto
        char genero = 'M';
        
        int xz = 1;  
        while (xz <= 10)   
            System.out.println(++xz);
        
        
        int i1=1, j2=2, k3=3, m4=2; 
        System.out.println ((j2 >= i1) || (k3 == m4));
        
        //Logicos
        boolean isVisible = true;
        boolean funciona = false;
        
        int variable = 2;
        int _variable = 3;
        int $variable = 4;
        int variable1 = 5;
        
        //Constantes
        int VALOR = 0;
        int VALOR_MAXIMO = 1;
        
        //Lower Camel Case: nombre de metodos y declaraciones de variables        
        //Upper Camel Case: nombre de la clase

        //CAST de variables
        byte b = 6;
        short s = b;
        
        b = (byte) s; //casteo de la variable s, para que pueda asignarse a b
        
        int i = 1;
        double d = 2.8;

        i = (int) d;

        int codigo = 97;
        char codigoASCII = (char) codigo;

        short numero = 259;
        byte numeroByte = (byte) numero;


        //System.out.println(numeroByte);

        //Arrays
        //Declaracion de array

        int[] arregloInt = new int[2];
        double arregloDouble[];

        int[][] array2D = new int[2][3]; //2 filas x 3 columnas = 6 elementos
        int[][][] array3D = new int[3][3][2]; //3 filas x 3 columnas x 2 niveles = 18 elementos
        //int[][][][] array4D = new int[1][2][3][4];

        char[][] days2D = { {'M','T','W'}, {'M','T','W'} };
        char[][][] days3D = { { {'a','b','c'}, {'a','b','c'}, {'a','b','c'} }, { {'a','b','c'}, {'a','b','c'}, {'a','b','c'} } };

        char[] names = new char[4];
        names[0] = 'h';
        names[1] = 'o';
        names[2] = 'l';
        names[3] = 'a';

        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        System.out.println(names[3]);
        
        char[][][][] monkey = new char[2][3][2][2];
        monkey[1][0][0][1] = 'M';

        System.out.println(monkey[1][0][0][1]);

        //Operadores aritméticos
        int a = 1;
        int aa = a+a;
        //System.out.println("El valor de aa: " + aa);
        
        double x = 2.56;
        int y = 9;
        float w = (float) x + y;
        //System.out.println("El valor de w: " + w);
        //System.out.println(w*2);
        
        double k = 4 / 0.0002;
        //System.out.println(k);
        //System.out.println(7%2);
        
        double f = 2;
        int g = 3;
        //f = f + g;
        f %= g;
        //System.out.println(f);
        
        // 1. Incrementar el valor l+1
        // 2. Asignar el valor a l
        int l = 3;
        //l++;
        //++l;
        //System.out.println(l);
        //System.out.println(l++);
        //System.out.println(l);
        //System.out.println(++l);
        
        //Operadores de equidad
        
        int q = 8;
        int p = 5;
        
        System.out.println(q == p);
        System.out.println(q != p);
        
        //Operadores relacionales
        
        
        System.out.println("Si q es mayor que p " + (q > p));
        System.out.println("Si q es menor que p " + (q < p));
        System.out.println("Si q es mayor o igual que p " + (q >= p));
        System.out.println("Si q es menor o igual que p " + (q <= p));
        
        //Operadores lógicos
        boolean n = false;
        boolean m = true;
        
        System.out.println("n && m " + (n && m));
        System.out.println("n || m " + (n || m));
        System.out.println("!n " + (!n));
        System.out.println("!m " + (!m));
        
        //Control de flujo
        //if/else
        
        if (q > p) {
        	//true
        	System.out.println("Si es mayor");
        } else if (q == p) {
        	//false
        	System.out.println("Es igual");
        } else {
        	System.out.println("No es mayor ni igual");
        }

        q++;
        
        //switch
        
        int mes = 6;
        
        switch (mes) {
		case 1:
			System.out.println("Enero");
			break;
		case 2:
			System.out.println("Febrero");
			break;
		case 3:
			System.out.println("Marzo");
			break;
		case 4:
			System.out.println("Abril");
			break;
		case 5:
			System.out.println("Mayo");
			break;
		case 6:
			System.out.println("Junio");
			break;
		case 7:
			System.out.println("Julio");
			break;
		case 8:
			System.out.println("Agosto");
			break;
		case 9:
			System.out.println("Septiembre");
			break;
		case 10:
			System.out.println("Octubre");
			break;
		case 11:
			System.out.println("Noviembre");
			break;
		case 12:
			System.out.println("Diciembre");
			break;
		default:
			System.out.println("Mes No Valido");
			break;
		}

        //Bucle While
        int e = 1;
        while(e <= 5) {
        	System.out.println("e es menor o igual a 5, valor: " + e);
        	e++;
        }

        System.out.println("Continuamos con el flujo");

        //Bucle For
        for(int c = 0; (c <= 5); c++) {
        	System.out.println("c es menor o igual a 5, valor: " + c);
        }        

        System.out.println("Continuamos con el flujo");

        int[] numeros = new int[5];

        //Bucle For
        for(int c = 0; c <= 4; c++) {
        	numeros[c] = c;
        	System.out.println("numeros["+c+"]: " + numeros[c]);
        }

        System.out.println("Continuamos con el flujo");

        for (int j : numeros) {
			System.out.println(j);
		}
        
        System.out.println("Continuamos con el flujo");
        
	}

}