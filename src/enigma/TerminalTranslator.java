package enigma;

import app.Module;
import services.EnigmaService;
import registry.ServiceProvider;
import java.util.Scanner;

public class TerminalTranslator {

	private ServiceProvider provider;
    private String mode, cipherName, cipherKey;

	public TerminalTranslator(String mode, String cipherName, String cipherKey){
		this.mode = mode;
		this.cipherName = cipherName;
		this.cipherKey = null;
	}

	public void initialize(ServiceProvider provider){
		this.provider = provider;
	}

	public String getName(){
		return "TerminalTranslator";
	}

	/**
	* Method to translate user input in console to use program.
	* If user not writed anything text, program send message.
	*/
	public void start(){
		EnigmaService enigma = provider.getByName(cipherName);
		Scanner scan = new Scanner(System.in);

		try {

	        if (mode.equals("-e")){
				while(scan.hasNextLine()){
					System.out.println(enigma.encipher(scan.nextLine()));
				}
			}

			else if (mode.equalsIgnoreCase("-d")){
				while(scan.hasNextLine()){
					System.out.println(enigma.decipher(scan.nextLine()));
				}
			}

			else if (mode.equalsIgnoreCase("-l")){
				for (String cipherName : provider.listAll()){
					System.out.println(cipherName);
				}
			}

			else {
				System.out.println("Wrong option name!");
				Application.showMainMenu();
			}
		}
		catch (NullPointerException e) {
			System.out.println("Wrong cipher name, use -l to see available cipher methods.");
		}

	}
}
