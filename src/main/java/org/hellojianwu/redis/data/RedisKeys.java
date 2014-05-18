package org.hellojianwu.redis.data;

public enum RedisKeys {
    WINE_ALL("wine:all"),
    WINE_DATA("wine:%s:data"),
    WINE_IDS("wine:ids");

    private String key;

    private RedisKeys(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

    public String formatDataKey(String... value) {
        return String.format(key, value);
    }

}
