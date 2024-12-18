package airlinesApiTests.pojos;

import java.util.List;

public class Passenger {
    private String name;
    private int trips;
    private List<Airline> airline;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrips() {
        return trips;
    }

    public void setTrips(int trips) {
        this.trips = trips;
    }

    public List<Airline> getAirline() {
        return airline;
    }

    public void setAirline(List<Airline> airline) {
        this.airline = airline;
    }

    // Nested class for Airline
    public static class Airline {
        private String _id;
        private String name;
        private String country;
        private String logo;
        private String slogan;
        private String head_quaters;
        private String website;
        private String established;

        // Getters and Setters
        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getHead_quaters() {
            return head_quaters;
        }

        public void setHead_quaters(String head_quaters) {
            this.head_quaters = head_quaters;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getEstablished() {
            return established;
        }

        public void setEstablished(String established) {
            this.established = established;
        }
    }
}
