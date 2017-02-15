package com.michonski.classes;

import java.util.List;

import com.michonskim.enums.Constituency;

public class Voter {
	private String voterId;
	private List<Candidate> candidates;
	private Constituency constituencyName;
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	public List<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	public Constituency getConstituencyName() {
		return constituencyName;
	}
	public void setConstituencyName(Constituency constituencyName) {
		this.constituencyName = constituencyName;
	}
	public Voter(String voterId, List<Candidate> candidates, Constituency constituencyName) {
		super();
		this.voterId = voterId;
		this.candidates = candidates;
		this.constituencyName = constituencyName;
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidates == null) ? 0 : candidates.hashCode());
		result = prime * result + ((constituencyName == null) ? 0 : constituencyName.hashCode());
		result = prime * result + ((voterId == null) ? 0 : voterId.hashCode());
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
		Voter other = (Voter) obj;
		if (candidates == null) {
			if (other.candidates != null)
				return false;
		} else if (!candidates.equals(other.candidates))
			return false;
		if (constituencyName != other.constituencyName)
			return false;
		if (voterId == null) {
			if (other.voterId != null)
				return false;
		} else if (!voterId.equals(other.voterId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", candidates=" + candidates + ", constituencyName=" + constituencyName
				+ "]";
	}
}
