package com.xuebowen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Bucket {  
	
    protected int minScore;  
    
    protected int maxScore;  
    
    protected List<Player> players;  
  
    public Bucket(int minScore, int maxScore) {  
        this.minScore = minScore;  
        this.maxScore = maxScore;  
        this.players = new ArrayList<>();  
    }  
  
    public void addPlayer(Player player) {  
        if (player.score >= minScore && player.score < maxScore) {  
            players.add(player);  
            Collections.sort(players);  
        }  
    }  
  
    public List<Player> getPlayers() {  
        return players;  
    }  
  
    // 获取全局排名  
    public int getGlobalRank(Player player) {  
        int rank = 1;  
        for (Bucket bucket : BucketSortRanking.getBuckets()) {  
        	if(bucket.minScore <= player.score && bucket.maxScore >= player.score) {
        		rank += bucket.getPlayers().indexOf(player);  
        	}
            if(bucket.minScore > player.score) {
            	// 累加其他高于此玩家积分桶的玩家数量  
            	rank += bucket.players.size();  
            }
        }  
        return rank;  
    } 
}  