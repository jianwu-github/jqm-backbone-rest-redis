package org.hellojianwu.redis.data;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Wine {

    public static Map<String, String> toMap(Wine wine) {
        if (wine != null) {
            HashMap<String, String> map = new HashMap<String, String>();

            if (wine.getId() > 0) {
                map.put("id", String.valueOf(wine.getId()));
            }

            if (wine.getName() != null && wine.getName().trim().length() > 0) {
                map.put("name", wine.getName());
            }

            if (wine.getGrapes() != null && wine.getGrapes().trim().length() > 0) {
                map.put("grapes", wine.getGrapes());
            }

            if (wine.getCountry() != null && wine.getCountry().trim().length() > 0) {
                map.put("country", wine.getCountry());
            }

            if (wine.getPicture() != null && wine.getPicture().trim().length() > 0) {
                map.put("picture", wine.getPicture());
            }

            if (wine.getRegion() != null && wine.getRegion().trim().length() > 0) {
                map.put("region", wine.getRegion());
            }

            if (wine.getYear() != null && wine.getYear().trim().length() > 0) {
                map.put("year", wine.getYear());
            }

            if (wine.getDescription() != null && wine.getDescription().trim().length() > 0) {
                map.put("description", wine.getDescription());
            }

            return map;
        }

        return null;
    }

    public static Wine fromMap(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            Wine wine = new Wine();
            if (map.containsKey("id")) {
                wine.setId(Long.parseLong(map.get("id")));
            }

            if (map.containsKey("name")) {
                wine.setName(map.get("name"));
            }

            if (map.containsKey("description")) {
                wine.setDescription(map.get("description"));
            }

            if (map.containsKey("country")) {
                wine.setCountry(map.get("country"));
            }

            if (map.containsKey("grapes")) {
                wine.setGrapes(map.get("grapes"));
            }

            if (map.containsKey("region")) {
                wine.setRegion(map.get("region"));
            }

            if (map.containsKey("year")) {
                wine.setYear(map.get("year"));
            }

            if (map.containsKey("picture")) {
                wine.setPicture(map.get("picture"));
            }

            return wine;
        }

        return null;
    }

    private long id;

    private String name;

    private String grapes;

    private String country;

    private String region;

    private String year;

    private String picture;

    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrapes() {
        return grapes;
    }

    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
