// ContactsManager.java
public class ContactsManager {
    // Attributs :
    Contact[] myFriends;
    int friendsCount;

    // Constructeur :
    ContactsManager() {
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
    }

    // Méthode pour ajouter un nouveau contact au tableau
    void addContact(Contact contact) {
        if (friendsCount < myFriends.length) { // Vérification pour éviter un ArrayIndexOutOfBoundsException
            myFriends[friendsCount] = contact;
            friendsCount++;
        } else {
            System.out.println("La liste de contacts est pleine. Impossible d'ajouter plus de contacts.");
        }
    }

    // Méthode pour rechercher un contact par nom et retourner l'objet Contact correspondant
    Contact searchContact(String searchName) {
        for (int i = 0; i < friendsCount; i++) {
            if (myFriends[i] != null && myFriends[i].name.equals(searchName)) {
                return myFriends[i];
            }
        }
        return null; // Retourne null si le contact n'est pas trouvé
    }

    public static void main(String[] args) {
        // Crée un objet ContactsManager
        ContactsManager myContactsManager = new ContactsManager();

        // Crée et ajoute 5 contacts
        Contact friend1 = new Contact("Alice", "111-222-3333");
        myContactsManager.addContact(friend1);

        Contact friend2 = new Contact("Bob", "444-555-6666");
        myContactsManager.addContact(friend2);

        Contact friend3 = new Contact("Charlie", "777-888-9999");
        myContactsManager.addContact(friend3);

        Contact friend4 = new Contact("David", "123-456-7890");
        myContactsManager.addContact(friend4);

        Contact friend5 = new Contact("Eve", "098-765-4321");
        myContactsManager.addContact(friend5);

        // Recherche un contact et affiche son numéro de téléphone
        String searchName = "Charlie";
        Contact foundContact = myContactsManager.searchContact(searchName);

        if (foundContact != null) {
            System.out.println("Contact trouvé pour " + searchName + " : Numéro de téléphone = " + foundContact.phoneNumber);
        } else {
            System.out.println("Contact avec le nom " + searchName + " non trouvé.");
        }

        // Exemple de recherche d'un contact qui n'existe pas
        searchName = "Frank";
        foundContact = myContactsManager.searchContact(searchName);
        if (foundContact != null) {
            System.out.println("Contact trouvé pour " + searchName + " : Numéro de téléphone = " + foundContact.phoneNumber);
        } else {
            System.out.println("Contact avec le nom " + searchName + " non trouvé.");
        }
    }
}