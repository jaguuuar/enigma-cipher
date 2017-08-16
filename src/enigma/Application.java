package enigma;

import services.EnigmaService;
import app.Module;

public class Application {

	public static void main(String[] args) {
        String mode = null, cipherName = null, cipherKey = null;

        try {
            mode = args[0];
            cipherName = args[1];
            if (args.size() == 3)
                cipherKey = args[2];
        }
        catch (ArrayIndexOutOfBoundsException e){
            showMainMenu()
        }

        ServiceRepository repo = new ServiceRepository();
        repo.register(new cipherName());

        Module module = new cipherName();
        module.initialize(repo);
        module.start();
    }


    public static void initializeServiceRepository() {

    }


    public static void showMainMenu(){
        
    }

}
