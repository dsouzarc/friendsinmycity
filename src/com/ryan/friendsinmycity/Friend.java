package com.ryan.friendsinmycity;

public class Friend {
    
    private final int id;
    
    private final String name;
    private final String profilePhotoLink;
        
    private String lastCity;
    
    public Friend(final int id, final String name, final String profilePhotoLink) { 
        this.id = id;
        this.name = name;
        this.profilePhotoLink = profilePhotoLink;
        this.lastCity = "";
    }
    
    public Friend(final int id, final String name, final String profilePhotoLink, final String lastCity) { 
        this.id = id;
        this.name = name;
        this.profilePhotoLink = profilePhotoLink;
        this.lastCity = lastCity;
    }

    /**
     * @return the lastCity
     */
    public String getLastCity() {
        return lastCity;
    }

    /**
     * @param lastCity the lastCity to set
     */
    public void setLastCity(String lastCity) {
        this.lastCity = lastCity;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the profilePhotoLink
     */
    public String getProfilePhotoLink() {
        return profilePhotoLink;
    }
    
    @Override
    public String toString() { 
        return "Name: " + name + "\tCity: " + lastCity + "\tID: " + id;
    }
}
