import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Thanos {
	

	//Textausgabe von Arraylist bzw. List
	private static void displayList(List<Hero> aList) {
		String textAusgabe ="";
		for (Hero aHero: aList) {
			textAusgabe += textAusgabe.equals("") ? aHero.getName()+": "+aHero.getAge() : " | "+aHero.getName()+": "+aHero.getAge();
		}
		System.out.println(textAusgabe);
	}


    public static void main(String[] args) {

        // TODO 1 : Create an empty heroes list
    	ArrayList<Hero> heroes = new ArrayList<>();

        // TODO 2 : Add those heroes to the list
        // name: Black Widow, age: 34
        // name: Captain America, age: 100
        // name: Vision, age: 3
        // name: Iron Man, age: 48
        // name: Scarlet Witch, age: 29
        // name: Thor, age: 1500
        // name: Hulk, age: 49
        // name: Doctor Strange, age: 42
    	heroes.add(new Hero("Black Widow", 34));
    	heroes.add(new Hero("Captain America", 100));
    	heroes.add(new Hero("Vision", 3));
    	heroes.add(new Hero("Iron Man", 48));
    	heroes.add(new Hero("Scarlet Witch", 29));
    	heroes.add(new Hero("Thor", 1500));
    	heroes.add(new Hero("Hulk", 49));
    	heroes.add(new Hero("Doctor Strange", 42));
    	
    	// Kontrolle:
    	System.out.println("*** TODO 1+2: Initiale Liste ***");
    	displayList(heroes);
    	System.out.println();


        // TODO 3 : It's Thor's birthday, now he's 1501
    	Hero aHero = heroes.get(5);
    	aHero.setAge(1501);
    	heroes.set(5, aHero);

    	// Kontrolle:
    	System.out.println("*** TODO 3: Thor hatte Geburtstag ***");
    	displayList(heroes);
    	System.out.println();
    	
        // TODO 4 : Shuffle the heroes list
    	Collections.shuffle(heroes);
    	
    	// Kontrolle:
    	System.out.println("*** TODO 4: Liste durcheinander ***");
    	displayList(heroes);
    	System.out.println();

        // TODO 5 : Keep only the half of the list
    	List<Hero> halfAList =  heroes.subList(0, heroes.size()/2); 
    	// Cast-Fehler: subList gibt eine innere Klasse vom Typ SubList zurück, die von AbstractList erbt und nicht zu ArrayList gecastet werden kann
    	//ArrayList<Hero> halfAnArrayList =  (ArrayList<Hero>) heroes.subList(0, heroes.size()/2); 
    	
    	// Kontrolle:
    	System.out.println("*** TODO 5: subList ***");
    	displayList(halfAList);
    	System.out.println();
    	
    	// Experiment 1 mit Referenzen: Element verändern in original ArrayList, Ausgabe in subList
    	Hero aHero2 = heroes.get(2);
    	aHero2.setAge(333);
    	heroes.set(2, aHero2);
    	System.out.println("*** Experiment 1: Ausgabe der subList, aber Visions Alter in _Arraylist_ auf 333 geändert ***");
    	displayList(halfAList);
    	System.out.println();
    	
    	// Experiment 1a mit Referenzen: Element verändern in neuer ArrayList auf Basis der Sublist, Ausgabe in subList
    	// Die Frage war: was baut der Konstruktor der ArrayList, wenn er eine List üebrgeben bekommt?
    	
    	ArrayList<Hero> newArrayList = new ArrayList<>(halfAList);
    	Hero aHero2a = newArrayList.get(2);
    	aHero2a.setAge(444);
    	newArrayList.set(2, aHero2);
    	System.out.println("*** Experiment 1a: Ausgabe der subList, aber Visions Alter in _neuer Arraylist_ auf 444 geändert ***");
    	displayList(halfAList);
    	System.out.println();

    	

    	
    	
    	
    	// Experiment 2 subList clearen - was geschieht mit Arraylist?
    	halfAList.clear();
    	// Arraylist ausgeben
    	System.out.println("*** Experiment 2:Ausgabe der Arraylist, nachdem die subList gecleart wurde ***");
    	displayList(heroes);
    	System.out.println();
    	

    	// TODO 6 : Loop through the list and display the name of the remaining heroes
		String textAusgabe = "";
		for (Hero aHero3: heroes) {
			textAusgabe += textAusgabe.equals("")?aHero3.getName():", "+aHero3.getName();
		}
		System.out.println("*** TODO 6: Die verbliebenen Heroes ***\n"+textAusgabe);
		System.out.println();
    
    }
    
    /* zu speziell, passt nur für ArrayList, nicht für List
	private static void displayArrayList(ArrayList<Hero> anArrayList) {
		for (Hero aHero: anArrayList) {
			System.out.print(aHero.getName()+":"+aHero.getAge()+" | ");
		}
		System.out.println();
	}
	*/
}
