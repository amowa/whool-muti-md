package org.sonatype.mavenbook.weather.model;

public class Wind {
    private Integer id;

    private String chill;

    private String direction;

    private String speed;

    private Integer weatherId;

    private Weather weather; //w
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
    
}