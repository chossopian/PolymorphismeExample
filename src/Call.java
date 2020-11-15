public class Call extends Api {

    public String Subuh() {
        String subuh = (String) this.DataJSON().get("subuh");
        return subuh;
    }

    public String Dzuhur() {
        String dzuhur = (String) this.DataJSON().get("dzuhur");
        return dzuhur;
    }

    public String Ashar() {
        String ashar = (String) this.DataJSON().get("ashar");
        return ashar;
    }

    public String Maghrib() {
        String maghrib = (String) this.DataJSON().get("maghrib");
        return maghrib;
    }

    public String Isya() {
        String isya = (String) this.DataJSON().get("isya");
        return isya;
    }

    public String Tanggal() {
        String tanggal = (String) this.DataJSON().get("tanggal");
        // System.out.println("[+] " + tanggal + "\n");
        return tanggal;
    }
}
