package org.hellojianwu.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hellojianwu.redis.data.RedisKeys;
import org.hellojianwu.redis.data.Wine;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisDataManager {
    private Jedis jedis;

    public RedisDataManager() {
        jedis = new Jedis("localhost");
    }

    public List<Wine> findAll() {
        List<String> wineIdList = jedis.lrange(RedisKeys.WINE_ALL.key(), 0, -1);
        ArrayList<Wine> wineList = new ArrayList<Wine>(wineIdList.size());

        for (String idStr : wineIdList) {
            long id = Long.parseLong(idStr);
            wineList.add(getWine(id));
        }

        return wineList;
    }

    public Wine saveWine(Wine newWine) {
        long wineId = jedis.incr(RedisKeys.WINE_IDS.key());
        newWine.setId(wineId);

        //Getting the Pipeline
        Pipeline pipeline = jedis.pipelined();

        //add to wine list
        pipeline.lpush(RedisKeys.WINE_ALL.key(), String.valueOf(wineId));

        //add to the hash
        pipeline.hmset(RedisKeys.WINE_DATA.formatDataKey(String.valueOf(wineId)), Wine.toMap(newWine));

        pipeline.sync();

        return newWine;
    }

    public Wine getWine(long wineId) {
        String wineDataKey = RedisKeys.WINE_DATA.formatDataKey(String.valueOf(wineId));
        Map<String, String> map = jedis.hgetAll(wineDataKey);

        return Wine.fromMap(map);
    }

}
