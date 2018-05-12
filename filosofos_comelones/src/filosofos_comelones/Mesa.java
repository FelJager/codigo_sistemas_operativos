package filosofos_comelones;

public class Mesa {
	private int numFilosofos ; 
	private boolean [] comiendo ; 
	public Mesa ( int n) { 
	numFilosofos = n;; 
	comiendo = new boolean [ numFilosofos ]; 
	for ( int i = 0; i < numFilosofos ; i ++) { comiendo [i] = false ; } 
	} 


public synchronized void permisoComer ( int i) throws InterruptedException 
{ 
	while ( comiendo [ ant (i)] || comiendo [ sig (i )]) { wait (); } 
		comiendo [i]= true ; 
} 

public synchronized void cedePermiso ( int i) { 
comiendo [i]= false ; 
notifyAll (); 
} 

public int sig ( int i) { return (i+1) % numFilosofos ; }

public int ant ( int i) 
{ 
	return ( i -1+ numFilosofos ) % numFilosofos ; 
	}
}