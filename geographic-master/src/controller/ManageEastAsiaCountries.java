package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;
import model.Country;
import model.EastAsiaCountries;
import view.Library;
import view.Menu;
                            
public class ManageEastAsiaCountries extends Menu<String> {

    Library lb = new Library();
    ArrayList<Country> listCountry = new ArrayList<>();
    static String[] mc = {"Input the information of 11 countries in East Asia", "Display the information of country you've just input", "Search the information of country by user-entered name", "Display the information of countries sorted name in ascending order"};

    public ManageEastAsiaCountries() {
        super("======================= ManageEastAsiaCountries====================", mc, "Exit");
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addCountry();
                break;
            case 2:
                displayCountry();
                break;
            case 3:
                searchByName();
                break;
            case 4:
                displaySort();
                break;
        }
    }

    public void addCountry() {
        String codeC = lb.getValue("Enter code of country: ");
        String nameC = lb.getValue("Enter name of country: ");
        float areaC = lb.getInt("Enter total Area: ");
        String terraC = lb.getValue("Enter terrain of country: ");
        listCountry.add(new EastAsiaCountries(codeC, nameC, areaC, terraC));
    }

    public void displayCountry() {
        for (Country co : listCountry) {
            System.out.println(co);
        }
    }

    public ArrayList<Country> search(Predicate<Country> cd) {
        ArrayList<Country> subList = new ArrayList<>();
        for (Country d : listCountry) {
            if (cd.test(d)) {
                subList.add(d);
            }
        }
        return subList;
    }

    public void display(ArrayList<Country> a) {
        for (Country b : a) {
            System.out.println(b);
        }
    }

    public void searchByName() {
        ArrayList<Country> c = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name to search:");
        String name = sc.nextLine();

        c = search(cs -> cs.getCountryName().contains(name));
        if (c.isEmpty()) {
            System.out.println("Nobody have phone like this.");
        } else {
            display(c);
        }
        System.out.println("--------------------------------------------");
    }

    public String getName(String name) {
        name = name.trim();
        if (name.indexOf(" ") > 0) {
            int vt = name.lastIndexOf(" ");
            return name.substring(vt + 1);
        } else {
            return name;
        }
    }

    public void sortCustomerByName() {
        Collections.sort(this.listCountry, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                String nameO1 = getName(o1.getCountryName());
                String nameO2 = getName(o2.getCountryName());

                if ((nameO1.compareToIgnoreCase(nameO2)) > 0) {
                    return -1;
                } else if ((nameO1.compareToIgnoreCase(nameO2)) < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void displaySort() {
        sortCustomerByName();
        displayCountry();
    }
//    1
}
