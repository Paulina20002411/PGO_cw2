import java.time.LocalDate;

public class SklepKomputerowy {
    private Produkt[] listaProduktow = new Produkt[10];
    private Klient[] listaKlientow = new Klient[10];
    private Zamowienie[] listaZamowien = new Zamowienie[10];
    private int licznikProduktow = 0;
    private int licznikKlientow = 0;
    private int licznikZamowien = 0;

    public void dodajProdukt(Produkt nowyProdukt) {
        if (licznikProduktow >= listaProduktow.length) {
            System.out.println("Nie można dodać więcej produktów — brak miejsca.");
            return;
        }
        listaProduktow[licznikProduktow] = nowyProdukt;
        licznikProduktow++;
    }

    public void dodajKlienta(Klient nowyKlient) {
        if (licznikKlientow >= listaKlientow.length) {
            System.out.println("Nie można dodać więcej klientów — brak miejsca.");
            return;
        }
        listaKlientow[licznikKlientow++] = nowyKlient;
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produktyZamowione, int[] ilosci) {
        Zamowienie z = new Zamowienie();
        z.setId(0);
        z.setKlient(klient);
        z.setProdukty(produktyZamowione);
        z.setIlosci(ilosci);
        z.setDataZamowienia(LocalDate.now().toString());
        z.setStatus("Nowe");
        return z;
    }

    public void aktualizujStanMagazynowy(Zamowienie zam) {
        Produkt[] zamProdukty = zam.getProdukty();
        int[] ilosci = zam.getIlosci();

        for (int i = 0; i < zamProdukty.length; i++) {
            int idProduktu = zamProdukty[i].getId();
            for (int j = 0; j < licznikProduktow; j++) {
                if (listaProduktow[j].getId() == idProduktu) {
                    int nowyStan = listaProduktow[j].getIloscWMagazynie() - ilosci[i];
                    listaProduktow[j].setIloscWMagazynie(nowyStan);
                    break;
                }
            }
        }
    }

    public void zmienStatusZamowienia(int idZam, String nowyStatus) {
        for (int i = 0; i < licznikZamowien; i++) {
            Zamowienie z = listaZamowien[i];
            if (z.getId() == idZam) {
                z.setStatus(nowyStatus);
                return;
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        System.out.println("Produkty w kategorii: " + kategoria);
        for (int i = 0; i < licznikProduktow; i++) {
            Produkt p = listaProduktow[i];
            if (p.getKategoria().equalsIgnoreCase(kategoria)) {
                p.wyswietlInformacje();
                System.out.println("-----");
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (int i = 0; i < licznikZamowien; i++) {
            Zamowienie z = listaZamowien[i];
            if (z.getKlient().getId() == idKlienta) {
                z.wyswietlSzczegoly();
                System.out.println("======================");
            }
        }
    }
}


