package responsi;

public class Main {

    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();
        ModelMenu modelMenu = new ModelMenu();
        new ControllerMenu(viewMenu,modelMenu);
    }
}
