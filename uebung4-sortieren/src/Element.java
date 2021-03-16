public class Element {
    private String station;
    private String icao;

    public Element(){
        this.icao = "blank";
        this.station = "blank";
    }

    public String getIcao() {
        return icao;
    }
    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getStation() {
        return station;
    }
    public void setStation(String station) {
        this.station = station;
    }
}
