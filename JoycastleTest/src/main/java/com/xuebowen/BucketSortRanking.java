package com.xuebowen;

import java.util.*;  

class BucketSortRanking {  
	
    private static List<Bucket> buckets;  
    
    private static final int NUM_BUCKETS = 100; // 假设有100个桶，每个桶代表100分  
    
    private static final int MIN_SCORE = 0;  
    
    private static final int MAX_SCORE = 10000;  
  
    static {  
        int scoreRange = (MAX_SCORE - MIN_SCORE) / NUM_BUCKETS;  
        buckets = new ArrayList<>();  
        for (int i = 0; i < NUM_BUCKETS; i++) {  
            int min = MIN_SCORE + i * scoreRange;  
            int max = Math.min(MIN_SCORE + (i + 1) * scoreRange, MAX_SCORE);  
            buckets.add(new Bucket(min, max));  
        }  
    }  
  
    //通过分数查桶子
    private int getBucketIndex(int score) {  
        return score / ((MAX_SCORE - MIN_SCORE) / NUM_BUCKETS);  
    }  

    public static void addPlayer(Player player) {  
        for (Bucket bucket : buckets) {  
            bucket.addPlayer(player);  
            if (player.score >= bucket.minScore && player.score < bucket.maxScore) {  
                break;  
            }  
        }  
    }  
  
    public static int getPlayerRank(int playerId) {  
        for (Bucket bucket : buckets) {  
            for (Player player : bucket.getPlayers()) {  
                if (player.id == playerId) {  
                    return bucket.getGlobalRank(player);  
                }  
            }  
        }  
        return -1; // 玩家未找到  
    }  
    
    //上下的玩家排名信息,下限为排名-minusRank,上限为排名+plusRank
    public static int getPlayerRankAndAround(int playerId, int minusRank, int plusRank, int score) {  
    	
    	int rank = -1;
    	
        for (Bucket bucket : buckets) {  
            for (Player player : bucket.getPlayers()) {  
                if (player.id == playerId) {  
                	rank = bucket.getGlobalRank(player);  
                }  
            }  
        }  

    	int rankMinus = rank + minusRank;
    	int rankPlus = rank + plusRank;
        for (Bucket bucket : buckets) {  
            for (Player player : bucket.getPlayers()) {  
                if (player.id == playerId) {  
                    return bucket.getGlobalRank(player);  
                }  
            }  
        }  
        return -1; // 玩家未找到  

    	
    }  
  
    public static List<Bucket> getBuckets() {  
        return buckets;  
    }  
  
    public static List<Rank> getPlayerRankAndNeighbors(Player player, int highRankRange, int lowRankRange) {  
        List<Player> allPlayers = new ArrayList<>();  
        for (Bucket bucket : buckets) {  
            allPlayers.addAll(bucket.getPlayers());  
        }  
  
        Collections.sort(allPlayers);  
  
        int playerIndex = allPlayers.indexOf(player);  
        if (playerIndex == -1) {  
            return Collections.emptyList();
        }  
  
        int start = Math.max(0, playerIndex - highRankRange);  
        int end = Math.min(allPlayers.size() - 1, playerIndex + lowRankRange);  
        List<Player> result = allPlayers.subList(start, end + 1);
        List<Rank> ranks = new ArrayList<>();
        for(Player playerTmp: result) {
        	int rankTmp = allPlayers.indexOf(playerTmp) + 1;
        	ranks.add(new Rank(playerTmp.getId(), playerTmp.getScore(), rankTmp));
        }
        return ranks;  
    }  
}