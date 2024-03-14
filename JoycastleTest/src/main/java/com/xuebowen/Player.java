package com.xuebowen;

import java.util.Comparator;

class Player implements Comparable<Player>{ 
	
    int id;  
    
    int score;  
    
    long timestamp; // 假设用时间戳来区分相同分数的玩家  
    
    String nickName; //昵称
    
    int level;
  
    // 实现Comparable接口以便进行排序  
	@Override
	public int compareTo(Player player) {
        if (this.score != player.score) {  
            return player.score - this.score;
        } else if (this.timestamp != player.timestamp) {  
            return Long.compare(this.timestamp, player.timestamp);  
        } else if (this.level != player.level) {  
            return player.level - this.level;  
        } else {  
            return this.nickName.compareTo(player.nickName);  
        }
	}  

    Player(int id, int score, long timestamp, String nickName, int level) {  
        this.id = id;  
        this.score = score;  
        this.timestamp = timestamp;  
        this.nickName = nickName;
        this.level = level;
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

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

    
}  