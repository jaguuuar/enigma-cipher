package enigma;

import registry.ServiceRegistry;
import registry.ServiceProvider;
import services.EnigmaService;

import java.util.LinkedList;
import java.util.List;

public class ServiceRepository implements ServiceRepository, ServiceRegistry {

    LinkedList<EnigmaService> services;

    public ServiceRepository(){
        this.services = new LinkedList<EnigmaService>();
    }

    public void register(EnigmaService service){
        this.services.add(service);
    }
}
