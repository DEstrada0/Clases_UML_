import java.util.ArrayList;

public class PatronManagement {
    private ArrayList<User> patrons = new ArrayList<>();

    public void registerPatron(User user) {
        patrons.add(user);
        System.out.println("Patron registered successfully!");
    }

    public void viewPatrons() {
        System.out.println("List of Patrons:");
        for (User user : patrons) {
            System.out.println("Name: " + user.getNombre() +
                               ", ID: " + user.getId() +
                               ", Email: " + user.getCorreo() +
                               ", Phone: " + user.getTelefono());
        }
    }

    public User findPatronById(int id) {
        for (User user : patrons) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;  // Not found
    }
}
