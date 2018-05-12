package filosofos_comelones;

import java.util.Random;

public class Filosofo extends Thread { 
	private Random random ; 
	private int tiempoComiendo , tiempoPensando ; 
	private Mesa mesa ; 
	private int id; 
	
	public Filosofo ( Random r, int tc , int tp , Mesa m, int i) 
	{ 
		random = r; 
		tiempoPensando = tp; 
		tiempoComiendo = tc; 
		mesa = m; 
		id = i; 
	}
	
	public void run () { 
		boolean para = false ; 
			while (! para ) { 
				try 
				{ciclo ();} 
					catch ( InterruptedException e) { 
					para = true ; 
					} 
			}
	}
	
	private void ciclo () throws InterruptedException { piensa (id , tiempoPensando ); mesa . permisoComer (id ); 
		try { 
		come (id , tiempoComiendo ); 
		} catch ( InterruptedException e) { mesa . cedePermiso (id ); throw e; } 
		mesa . cedePermiso (id ); 
		} 
		private void espera ( int tiempo ) throws InterruptedException { 
		int t = random . nextInt ( tiempo ); 
		sleep (t); 
		} 
		private void piensa ( int id , int tiempo ) throws InterruptedException { 
		System . out . println (" El filosofo "+id+" empieza a pensar " ); 
		espera ( tiempo ); 
		System . out . println (" El filosofo "+id+" acaba de pensar " ); 
		} 
		private void come ( int id , int tiempo ) throws InterruptedException { 
		System . out . println (" El filosofo "+id+" empieza a comer "+": "+ mesa ); 
		espera ( tiempo ); 
		System . out . println (" El filosofo "+id+" acaba de comer "+":" + mesa ); 
		}


public static void main ( String [] args ) throws InterruptedException {
	int numFilosofos = 5; 
	int tiempoPensando = 1000; 
	int tiempoComiendo = 2000; 
	int tiempoParada = 10000; 
	Random r = new Random (); 
	Mesa mesa = new Mesa ( numFilosofos ); 
	Filosofo [] filosofo = new Filosofo [ numFilosofos ]; 
	for ( int i = 0; i < numFilosofos ; i++) { 
		filosofo [i] = new Filosofo (r, tiempoComiendo , tiempoPensando , mesa , i); 
		filosofo [i]. start (); 
	}

	for ( int i = 0; i < numFilosofos ; i++) { 
		Thread . sleep ( tiempoParada ); 
		System . out . println (" Parando filosofo "+i+" ............................. " ); 
		filosofo [i]. interrupt (); 
	} 
		for ( int i = 0; i < numFilosofos ; i++) { 
			filosofo [i]. join (); 
		} 
	} 
}