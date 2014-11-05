package org.sonatype.mavenbook.weather.model;
/*
import java.util.Date;

public class Weather {
	private Integer id;

	private Date date;

	private String locationZip;
	private Location location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocationZip() {
		return locationZip;
	}

	public void setLocationZip(String locationZip) {
		this.locationZip = locationZip;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}*/



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import java.util.Date;

@Entity
@NamedQueries({
	@NamedQuery(name="Weather.byLocation", query="from Weather w where w.location = :location")
})
public class Weather {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Location location;

    @OneToOne(mappedBy="weather",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Condition condition;

    @OneToOne(mappedBy="weather",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Wind wind;

    @OneToOne(mappedBy="weather",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Atmosphere atmosphere;

    private Date date;
    
    private String locationZip; //wxg add
    
    
    public Weather() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public final Condition getCondition() { return condition; }
    public final void setCondition(final Condition newCondition) {
	this.condition = newCondition;
    }

    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; }
    
    public Atmosphere getAtmosphere() { return atmosphere; }
    public void setAtmosphere(Atmosphere atmosphere) { this.atmosphere = atmosphere; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

	public String getLocationZip() {
		return locationZip;
	}

	public void setLocationZip(String locationZip) {
		this.locationZip = locationZip;
	}
    
    
}