package redis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRUCache
 * @Description TODO
 * @Date 2020/2/15 18:56
 * @Created by zheng.nie
 */
public class LRUCache extends LinkedHashMap {


    private int cacheSize;

    public LRUCache(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75)+1,0.75f,true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return cacheSize < size();
    }
}
