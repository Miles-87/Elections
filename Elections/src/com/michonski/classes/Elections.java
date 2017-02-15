package com.michonski.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.omg.Messaging.SyncScopeHelper;

import com.michonskim.enums.Constituency;

public class Elections {
	private static Set<Voter> voters; 
	private static Set<Candidate> candidates = new TreeSet<>((c1,c2) -> {
		if (c1.getName().equals(c2.getName()))
		{
			if (c1.getSurname().equals(c2.getSurname()))
			{
				return c1.getConstituency().compareTo(c2.getConstituency());
			}
			return c1.getSurname().compareTo(c2.getSurname());
		}
		return c1.getName().compareTo(c2.getName());
	});
	
	public static void fillElectionsLists(Set<Voter> voters, Set<Candidate> candidates)
	{
		Elections.candidates = candidates;
		Elections.voters = voters;
		
		Map<Constituency, List<Candidate>> candidatesMap = new HashMap<>();
		for (Candidate c : Elections.candidates)
		{
			if (candidatesMap.containsKey(c.getConstituency()))
			{
				candidatesMap.get(c.getConstituency()).add(c);
			}
			else
			{
				candidatesMap.put(c.getConstituency(), new ArrayList<>(Arrays.asList(new Candidate[]{c})));
			}
		}
		
		for(Voter v: Elections.voters)
		{
			v.setCandidates(candidatesMap.get(v.getConstituencyName()));
		}
	}
	
	public static void showElectionLists()
	{
		voters.forEach(v -> {
			System.out.println(v.getVoterId() + " " + v.getConstituencyName());
			if (v.getCandidates() != null)
			{
				v.getCandidates().forEach(c -> {System.out.println(c);});
			}
			System.out.println("---------------------------------------------");
		});
		
	}
	
	public static void vote()
	{
		Map<Constituency, Integer> numOfVotesMap = new HashMap<>();
		Map<Constituency, Boolean> repeatElection = new HashMap<>();
		for(Candidate c : candidates)
		{
			repeatElection.put(c.getConstituency(), false);
			numOfVotesMap.put(c.getConstituency(), 0);
		}
		
		do
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("-------------------------ELECTIONS---------------------");
			System.out.println("-------------------------------------------------------");
			
			System.out.println("-------------------------------------------------------");
			System.out.println("--------------------------VOTING-----------------------");
			System.out.println("-------------------------------------------------------");
			voters.forEach(v -> {
				if (v.getCandidates() == null)
				{
					System.out.println("Your candidates list is empty :( Sorry ...");				
				}
				else if (!repeatElection.get(v.getConstituencyName())) 
				{
					int i = 1;
					for(Candidate c : v.getCandidates())
					{
						System.out.println(i + " " + c);
						++i;
					}
					Scanner sc = new Scanner(System.in);
					String candidateNumber;
					int howManyCandidates = v.getCandidates().size();
					String  regex = "[1-" + howManyCandidates + "]";
					do
					{
						System.out.println("Enter candidate number " + regex +  ":");
						candidateNumber = sc.nextLine();
					}
					while(!candidateNumber.matches(regex));
					
					
					i = 1;
					for(Candidate c : v.getCandidates())
					{
						if (i == Integer.parseInt(candidateNumber))
						{
							c.setNumOfVotes(c.getNumOfVotes() + 1);
							break;
						}
						++i;
					}
				}
			});
			
			System.out.println("-------------------------------------------------------");
			System.out.println("---------------------COUNTING RESULTS-------------------");
			System.out.println("-------------------------------------------------------");
			for(Candidate c: candidates)
			{
				repeatElection.put(c.getConstituency(), false);
				numOfVotesMap.put(c.getConstituency(), 0);
			}
			
			numOfVotesMap.entrySet().forEach(c -> {
				candidates.forEach(cand ->{
						
					if(cand.getConstituency().equals(c.getKey()))
					{
						numOfVotesMap.put(c.getKey(), numOfVotesMap.get(c.getKey())+cand.getNumOfVotes());
					}
				});
			});
				
			candidates.forEach(cand ->{	

				if(cand.getNumOfVotes()>0.5*numOfVotesMap.get(cand.getConstituency()))
				{
					repeatElection.put(cand.getConstituency(), true);
				}
			});
			
			repeatElection.entrySet().stream().forEach(r -> {
				if (r.getValue())
				{
					System.out.println(r.getKey() + " - DONE!");
				}
			});
			if (!repeatElection.entrySet().stream().allMatch(e -> e.getValue()))
			{
				System.out.println("ELECTIONS AGAIN!");
			}
		}while(!repeatElection.entrySet().stream().allMatch(e -> e.getValue()));
		
		System.out.println("-------------------------------------------------------");
		System.out.println("--------------------------WINNERS----------------------");
		System.out.println("-------------------------------------------------------");
		candidates.forEach(cand ->{	

			if(cand.getNumOfVotes()>0.5*numOfVotesMap.get(cand.getConstituency()))
			{
				System.out.println(cand.getConstituency() + ": " + cand.getSurname() + " " + cand.getName());
			}
		});
	}
	
}

