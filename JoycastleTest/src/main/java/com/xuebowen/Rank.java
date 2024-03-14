package com.xuebowen;

public class Rank {
	
    int id;  
    
    int score;  
    
    int rank;

    Rank(int id, int score, int rank) {
    	this.id = id;
    	this.score = score;
    	this.rank = rank;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}  
    
}
