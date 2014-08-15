package com.ryan.friendsinmycity;

public class Friend {
    
    private final long id;
    
    private final String name;
    private final String profilePhotoLink;
        
    private String lastCity;
    
    public Friend(final long id, final String name, final String profilePhotoLink) { 
        this.id = id;
        this.name = name;
        this.profilePhotoLink = profilePhotoLink;
    }
    
    public Friend(final long id, final String name, final String profilePhotoLink, final String lastCity) { 
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
    public long getId() {
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
}
