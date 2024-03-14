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
  
    public static List<Bucket> getBuckets() {  
        return buckets;  
    }  
  
    // 其他方法，比如获取邻居，更新玩家得分等...  
}