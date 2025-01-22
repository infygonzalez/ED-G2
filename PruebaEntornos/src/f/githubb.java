package f;

import java.util.Scanner;


 class Calculadoras {

	public Calculadoras() {
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	
		int menu = 0;
		int numero1=0,numero2 = 0;
		int x=1;
	
		
		
		MetodoMenu(menu, numero1, numero2);
		damenumero();
		damenumero2();
		
	}
	

	
	public static int damenumero() {
		
		Scanner teclado= new Scanner(System.in);
		System.out.println("Escribe el primer numero: ");
		int numero1=teclado.nextInt();
		return numero1;
	}
	
	

	public static int damenumero2() {

	System.out.println("Escribe el segundo numero: ");
		Scanner teclado= new Scanner (System.in);
		int numero2=teclado.nextInt();
		return numero2;
	}
	

	
	public static int MetodoMenu(int menu, int numero1,int numero2){
		int operacion = 0;
		int resultado;
		
		Scanner teclado= new Scanner(System.in);
		System.out.print("Introduce la operacion \n"
				+ "1. Suma\n"
				+ "2. Resta\n"
				+ "3. Multiplicacion\n"
				+ "4. Dividir\n"
				+ "0. Salir");
		menu=teclado.nextInt();
		
		switch (operacion){
			case 1:
				resultado=numero1+numero2;
				System.out.println(resultado);
				break;
			
			case 2:
				resultado=numero1-numero2;
				System.out.println(resultado);
				break;
			
			case 3:
				resultado=numero1*numero2;
				System.out.println(resultado);
				break;
			
			case 4:
				resultado=numero1/numero2;
				System.out.println(resultado);
				break;
			
			default:
		}
		return menu;
	}	
}
