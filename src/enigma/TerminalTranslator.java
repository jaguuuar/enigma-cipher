package enigma;

import app.Module;
import services.EnigmaService;
import registry.ServiceProvider;
import java.util.Scanner;

public class TerminalTranslator {

	private ServiceProvider provider;
    private String mode, cipherName, cipherKey;

	public TerminalTranslator(mode, cipherName, cipherKey){
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

	public void start(){
		EnigmaService enigma = provider.getByName(cipherName);
		Scanner scan = new Scanner(System.in);

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
			ServiceRepository services = new ServiceRepository();
			System.out.println("Available Cipher Method:")
			for (String cipherName : services){
				System.out.println(cipherName);
			}
		}
	}
}
