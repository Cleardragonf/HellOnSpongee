package me.Cleardragonf.HOS.Portal;


import com.google.gson.Gson;
import org.spongepowered.api.world.Location;

import java.util.HashMap;
import java.util.Map;

public class PortalManager {

    private Map<String, PortalLocation> locations = new HashMap<String, PortalLocation>();

    public void setPortal(String name, Location<?> location) {
        locations.put(name, PortalLocation.convert(location));
    }

    public void removePortal(String name) {
        locations.remove(name);
    }

    public PortalLocation getPortal(String name) {
        return locations.get(name);
    }

    public String toJson() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }

    public void setLocations(Map<String, PortalLocation> locations) {
        this.locations = locations;
    }

    public Map<String, PortalLocation> getPortal() {
        return locations;
    }
}