public class Main {
    public static void main(String[] args) {
        // Api test = new Api();
        // System.out.println(test.DataJSON());

        Call data = new Call();

        System.out.println("=== Jadwal Sholat dan Imsakiyah ===");
        System.out.println("[+] Untuk daerah DKI Jakarta");
        System.out.println("[+] " + data.Tanggal() + "\n");

        System.out.println("Subuh   : " + data.Subuh());
        System.out.println("Dzuhur  : " + data.Dzuhur());
        System.out.println("Ashar   : " + data.Ashar());
        System.out.println("Maghrib : " + data.Maghrib());
        System.out.println("Isya    : " + data.Isya());
    }
}
