package me.Cleardragonf.HOS.Portal;


import org.spongepowered.api.world.Location;

public class PortalLocation {

    public double x;
    public double y;
    public double z;

    public PortalLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static PortalLocation convert(Location<?> location) {
        return new PortalLocation(location.getX(), location.getY(), location.getZ());
    }
}