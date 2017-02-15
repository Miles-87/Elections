package com.michonski.classes;

import com.michonskim.enums.Constituency;

public class Candidate {
	private String name;
	private String surname;
	private int numberOfVotes;
	private Constituency constituencyName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getNumOfVotes() {
		return numberOfVotes;
	}
	public void setNumOfVotes(int numOfVotes) {
		this.numberOfVotes = numOfVotes;
	}
	public Constituency getConstituency() {
		return constituencyName;
	}
	public void setConstituency(Constituency constituency) {
		this.constituencyName = constituency;
	}
	public Candidate(String name, String surname, int numOfVotes, Constituency constituency) {
		super();
		this.name = name;
		this.surname = surname;
		this.numberOfVotes = numOfVotes;
		this.constituencyName = constituency;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Candidate [name=" + name + ", surname=" + surname + ", numOfVotes=" + numberOfVotes + ", constituency="
				+ constituencyName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((constituencyName == null) ? 0 : constituencyName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfVotes;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (constituencyName != other.constituencyName)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfVotes != other.numberOfVotes)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
}
