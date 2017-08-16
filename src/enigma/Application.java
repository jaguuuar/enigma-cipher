package enigma;

import services.EnigmaService;
import app.Module;
import enigma.cipher.*;

public class Application {

	public static void main(String[] args) {
        String mode = null, cipherName = null, cipherKey = null;
        ServiceRepository enigmaRep;
        TerminalTranslator terminalTranslator;


        try {
            mode = args[0];
            cipherName = args[1];
            if (args.length == 3)
                cipherKey = args[2];
        }
        catch (ArrayIndexOutOfBoundsException e){
				showMainMenu();
		}


        enigmaRep = initializeServiceRepository();

        terminalTranslator = new TerminalTranslator(mode, cipherName, cipherKey);
        terminalTranslator.initialize(enigmaRep);
        terminalTranslator.start();
    }


    public static ServiceRepository initializeServiceRepository() {
        ServiceRepository enigmaRep = new ServiceRepository();
        enigmaRep.register(new ForwardBackCipher());
        return enigmaRep;
    }

    public static void showMainMenu(){
        System.out.println("first argument: -e (enciper) /" +
                           "-d (deciper) option to start in decrypting mode" +
                           "\n-l to check available mode" +
                           "\nsecond argument: name of decrypting mode" +
                           "\nthird argument: key of decrypting mode if you need it\n");
    }

}
