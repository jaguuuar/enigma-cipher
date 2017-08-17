package enigma;

import services.EnigmaService;
import app.Module;
import enigma.cipher.*;
import java.util.Arrays;
import java.util.stream.Stream;

import java.util.LinkedList;
import java.util.List;


public class Application {

	public static void main(String[] args) {

        String mode = null, cipherName = null, cipherKey = null;
        ServiceRepository enigmaRep;
        TerminalTranslator terminalTranslator;

		mode = ifMode(args);
		cipherName = ifCipherName(args);
		cipherKey = ifCipherKey(args);
		noArgsInfo(mode);

		enigmaRep = initializeServiceRepository();

        terminalTranslator = new TerminalTranslator(mode, cipherName, cipherKey);
        terminalTranslator.initialize(enigmaRep);
        terminalTranslator.start();
    }


    public static ServiceRepository initializeServiceRepository() {
        ServiceRepository enigmaRep = new ServiceRepository();
        enigmaRep.register(new NumericCipher());
		enigmaRep.register(new MirrorCipher());
		enigmaRep.register(new ForwardBackCipher());
        enigmaRep.register(new Rot13());
		enigmaRep.register(new MorseCipher());

	    return enigmaRep;
    }

    public static void showMainMenu(){
        System.out.println("first argument: -e (enciper) /" +
                           "-d (deciper) option to start in decrypting mode" +
                           "\n-l to check available mode" +
                           "\nsecond argument: name of decrypting mode" +
                           "\nthird argument: key of decrypting mode if you need it\n");
    }


	public static String ifMode(String[] args)
	{
		if(args.length > 0)
			return args[0].trim();

		return null;
	}

	public static String ifCipherName(String[] args)
	{
		if(args.length > 1 && args.length <= 3)
			return args[1];

		return null;
	}

	public static String ifCipherKey(String[] args)
	{
		if(args.length == 3)
			return args[2];

		return null;
	}

	public static void noArgsInfo(String mode)
	{
		if (mode == null)
			showMainMenu();
	}

	public static String checkCipherName(String cipherName, ServiceRepository enigmaRep)
	{
		for (String name: enigmaRep.listAll()){
			if (name.equals(cipherName))
				return cipherName;
		}
		return null;
	}

	public static void nameTestResult(String cipherName)
	{
		if (cipherName == null)
		{
			System.out.println("Wrong cipher name!");
			showMainMenu();
			System.exit(0);
		}
	}



}
