package enigma;

import app.Module;
import services.EnigmaService;
import registry.ServiceProvider;
import java.util.Scanner;

public class TerminalTranslator {

	private ServiceProvider provider;
    private String mode, cipherName, cipherKey;
