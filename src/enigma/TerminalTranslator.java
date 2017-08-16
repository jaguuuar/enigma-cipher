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
