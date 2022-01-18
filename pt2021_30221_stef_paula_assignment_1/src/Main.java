import Controller.Permissions;
import Model.Operations;
import View.View;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        View.ViewPage page1 = new View.ViewPage();
        Permissions permisions = new Permissions(page1);
    }
}