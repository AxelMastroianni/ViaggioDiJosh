package quest.albero.equazioni;

import java.util.LinkedList;
import java.util.Random;

public class Equazione {
	
	private static final int MASSIMO_COEFFICIENTE=10;
	private int paramA=0;
	private int paramB=0;
	private int paramC=0;
	private double soluzione1=0;
	private double soluzione2=0;
	private double delta=0;
	private LinkedList<Equazione> vicine=new LinkedList<Equazione>();
	private Random r=new Random();
	
	public Equazione() {
		paramA=r.nextInt()%MASSIMO_COEFFICIENTE;
		paramB=r.nextInt()%MASSIMO_COEFFICIENTE;
		paramC=r.nextInt()%MASSIMO_COEFFICIENTE;
	}

	public int getParamA() {
		return paramA;
	}

	public void setParamA(int paramA) {
		this.paramA = paramA;
	}

	public int getParamB() {
		return paramB;
	}

	public void setParamB(int paramB) {
		this.paramB = paramB;
	}

	public int getParamC() {
		return paramC;
	}

	public void setParamC(int paramC) {
		this.paramC = paramC;
	}

	public double getSoluzione1() {
		return soluzione1;
	}

	public void setSoluzione1(double soluzione1) {
		this.soluzione1 = soluzione1;
	}

	public double getSoluzione2() {
		return soluzione2;
	}

	public void setSoluzione2(double soluzione2) {
		this.soluzione2 = soluzione2;
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public LinkedList<Equazione> getVicine() {
		return vicine;
	}

	public void setVicine(LinkedList<Equazione> vicine) {
		this.vicine = vicine;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}
	
	private void calcolaDelta() {
		double nuovoDelta=Math.pow(paramB, 2)-4*paramA*paramC;
		setDelta(nuovoDelta);
	}
	
	private void calcolaSoluzione1() {
		if(delta<0)
			setSoluzione1(0);
		else {
			double soluzione1=(-paramB+Math.sqrt(delta))/2;
			setSoluzione1(soluzione1);
		}
	}
	
	private void calcolaSoluzione2() {
		if(delta<0)
			setSoluzione2(0);
		else {
			double soluzione2=(-paramB-Math.sqrt(delta))/2;
			setSoluzione2(soluzione2);
		}
	}
	
	public void calcolaSoluzioni() {
		calcolaDelta();
		calcolaSoluzione1();
		calcolaSoluzione2();
	}
	
	public double moduloSoluzioni() {
		double sommaQuadrati=Math.pow(soluzione1, 2)+Math.pow(soluzione2, 2);
		return Math.sqrt(sommaQuadrati);
	}
	/**
	 * svuota la lista di vicine
	 */
	public void eliminaVicine() {
		while(!vicine.isEmpty())
			vicine.remove(0);
	}

}
