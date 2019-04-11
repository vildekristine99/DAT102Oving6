package hvl.no.dat102.KjedetBinaerSoekeTre;
import  java.util.*;

class KlientBSTre{
	public static void main(String[]a){
		System.out.println("Oppgave 2b oblig 5");
		mangeTre();
		
		KjedetBinaerSokeTre<Integer> tre = tilfeldigTre(8192, 500);
		System.out.println(tre.hoyde());		
	}
	
	public static KjedetBinaerSokeTre<Integer> tilfeldigTre(int size, int max) {
		KjedetBinaerSokeTre<Integer> bs = new KjedetBinaerSokeTre<Integer>();
		Random r = new Random();

		for (int i = 0; i < size; i++) {
			Integer n = new Integer(r.nextInt(max));
			bs.leggTil(n);
		}
		
		return bs;
	}
	
	public static void mangeTre() {
		final int ANTALL_NODER = 8192;
		final int ANTALL_TRE = 100;
		
		ArrayList<Integer> hoyder = new ArrayList<Integer>();
		
		int i = 0;
		while(i < 100) {
			KjedetBinaerSokeTre<Integer> bs = tilfeldigTre(ANTALL_NODER, 512);
			
			hoyder.add(bs.hoyde());
			i++;
		}
		
		System.out.println("Generert " + ANTALL_TRE + " trær med " + ANTALL_NODER + " noder i hver.\n");
		
		System.out.println("Minste teoretiske høyde: " + minTeoretiskHoyde(ANTALL_NODER));
		System.out.println("Største teoretiske høyde: " + (ANTALL_NODER - 1));
		System.out.println("Minste høyde: " + min(hoyder));
		System.out.println("Største høyde: " + max(hoyder));
		System.out.println("Gjennomsnittlig høyde: " + gjennomsnitt(hoyder, ANTALL_TRE));
	}
	
	public static int min(ArrayList<Integer> array) {
		Iterator<Integer> itt = array.iterator();
		
		int min = array.get(0);
		int her;
		while(itt.hasNext()) {
			her = itt.next();
			if(min > her) {
				min = her;
			}
		}
		
		return min;
	}
	
	public static int max(ArrayList<Integer> array) {
		Iterator<Integer> itt = array.iterator();
		
		int max = 0;
		int her;
		while(itt.hasNext()) {
			her = itt.next();
			if(max < her) {
				max = her;
			}
		}
		
		return max;
	}
	
	public static int gjennomsnitt(ArrayList<Integer> array, int antall) {
		Iterator<Integer> itt = array.iterator();
		
		int gjn = 0;
		
		while(itt.hasNext()) {
			gjn += itt.next();
		}
		
		gjn = gjn/antall;
		
		return gjn;
	}
	
	public static int minTeoretiskHoyde(int n) {
		return (int) Math.floor(Math.log10(n) / Math.log(2));
	}

	public static void klient() {
		//Lager BS-tre med 8 noder
		//Skriv ut i in-orden, dvs sortert
		//Sjekker om verdien 10 er i treet
		//
		
		final int ANTALL_NODER = 16;
		Random tilfeldig = new Random();
		
		KjedetBinaerSokeTre <Integer>bs = new KjedetBinaerSokeTre<Integer>();
		Integer resultat = null;
		
		for(int i = 0; i < ANTALL_NODER; i++){
			Integer element = new Integer(tilfeldig.nextInt(30));
			bs.leggTil(element);
			System.out.print(" " +element);
		}
		  
		//  System.out.println("Hoyde: " +bs.hoyde());
		//  
		System.out.println("Treet med  " + ANTALL_NODER + " noder.");
		bs.visInorden();
		  
		Integer el = new Integer(10);
		  
		//************************************************************************
		  
		resultat = bs.finn(el);
		if(resultat != null)
			System.out.println("\nSoekte etter " + el +" og fant " +resultat);
		else
			System.out.println("\nSoekte etter " + el +" som ikke var i treet ");   
		  
		//****************************************************************************
		 
		resultat = bs.fjernMaks();
		if(resultat != null)
			System.out.println("\nFjernet stoerste " + resultat );
		else
			System.out.println("Treet er tomt");   
		
		System.out.println("Treet er nå: ");
		bs.visInorden();
		
		//****************************************************************************
		resultat = bs.fjernMin();
		if(resultat != null)
			System.out.println("\nFjernet minste " + resultat);
		else
			System.out.println("Tree er tomt ");
		
		System.out.println("Treet er nå: ");    
		bs.visInorden();
		//****************************************************************************
		        
		resultat = bs.finnMin();
		if(resultat != null)
			System.out.println("\nMinste element " + resultat);
		else
			System.out.println("Treet er tomt");
		  
		//******************************************************************************
		       
		resultat = bs.finnMaks();
		if(resultat != null)
			System.out.println("\nStoerste element " + resultat);
		else
			System.out.println("Treet er tomt");     
		       
		//****************************************************************************
		resultat = bs.hoyde();
		System.out.println("Hoyden til treet er: "+resultat);
		 	
		  
	}
}//class