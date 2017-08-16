package enigma;

import registry.ServiceRegistry;
import registry.ServiceProvider;
import services.EnigmaService;

import java.util.LinkedList;
import java.util.List;

public class ServiceRepository implements ServiceProvider, ServiceRegistry {

    private LinkedList<EnigmaService> services;

    public ServiceRepository(){
        this.services = new LinkedList<EnigmaService>();
    }

    public void register(EnigmaService service){
        this.services.add(service);
    }

    public List<String> listAll(){

  		List<String> result = new LinkedList<String>();

  		for(EnigmaService service : this.services){
  			result.add(service.getName());
  		}

  		return result;
    }

    public EnigmaService getByName(String name){
  		for(EnigmaService service : this.services){
  			if (service.getName().equals(name)){
  				return service;
  			}
  		}
  		return null;
  	}
}
