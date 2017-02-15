package com.michonskim.main;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.michonski.classes.Candidate;
import com.michonski.classes.Elections;
import com.michonski.classes.Voter;
import com.michonskim.enums.Constituency;


public class Main {

	public static void main(String[] args) {
		
		
		Set<Voter> voters = new HashSet<>();
		Set<Candidate> candidates = new HashSet<>();
		Collections.addAll(voters, 
			new Voter("W1", null, Constituency.WARSZAWA),
			new Voter("W2", null, Constituency.LODZ),
			new Voter("W3", null, Constituency.KRAKOW),
			new Voter("W4", null, Constituency.POZNAN),
			new Voter("W5", null, Constituency.SZCZECIN),
			new Voter("W6", null, Constituency.WARSZAWA),
			new Voter("W7", null, Constituency.LODZ),
			new Voter("W8", null, Constituency.WARSZAWA),
			new Voter("W9", null, Constituency.LODZ),
			new Voter("W10", null, Constituency.KRAKOW),
			new Voter("W11", null, Constituency.POZNAN),
			new Voter("W12", null, Constituency.SZCZECIN),
			new Voter("W13", null, Constituency.WARSZAWA),
			new Voter("W14", null, Constituency.LODZ)
		);
		
		Collections.addAll(candidates, 
			new Candidate("Name1","Surname1", 0, Constituency.KRAKOW),	
			new Candidate("Name2","Surname2", 0, Constituency.LODZ),
			new Candidate("Name3","Surname3", 0, Constituency.WARSZAWA),
			new Candidate("Name4","Surname4", 0, Constituency.WARSZAWA),
			new Candidate("Name5","Surname5", 0, Constituency.KRAKOW),
			new Candidate("Name6","Surname6", 0, Constituency.LODZ),
			new Candidate("Name7", "Surname7", 0, Constituency.POZNAN),
			new Candidate("Name8", "Surname8", 0, Constituency.POZNAN),
			new Candidate("Name9", "Surname9", 0, Constituency.SZCZECIN),
			new Candidate("Name10", "Surname10", 0, Constituency.SZCZECIN)
		);
		
		Elections.fillElectionsLists(voters, candidates);
		Elections.vote();
		
	}
}
