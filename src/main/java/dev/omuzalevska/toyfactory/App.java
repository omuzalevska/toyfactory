package dev.omuzalevska.toyfactory;
import dev.omuzalevska.toyfactory.controller.ToyController;
import dev.omuzalevska.toyfactory.repository.ToyRepository;
import dev.omuzalevska.toyfactory.repository.ToyRepositoryImpl;
import dev.omuzalevska.toyfactory.view.ConsoleView;

public class App {
    public static void main(String[] args) {

        ToyRepository repository = new ToyRepositoryImpl();

        ConsoleView view = new ConsoleView();

        ToyController controller = new ToyController(repository, view);
        
        controller.start();
    }
}
