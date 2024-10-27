import java.io.FileWriter;
import java.io.IOException;

/**
 * Abstract class representing a weapon.
 */
public abstract class Weapon {
    private WeaponType weaponType;
    private Ammunition ammunition;
    private Manufacturer manufacturer;
    private FileWriter logWriter;

    public Weapon() throws IOException {
        this.weaponType = new WeaponType("Unknown", 0);
        this.ammunition = new Ammunition("None", 0);
        this.manufacturer = new Manufacturer("Unknown");
        logWriter = new FileWriter("weapon_log.txt", true);
        logAction("Created default weapon");
    }

    public Weapon(WeaponType weaponType, Ammunition ammunition, Manufacturer manufacturer) throws IOException {
        this.weaponType = weaponType;
        this.ammunition = ammunition;
        this.manufacturer = manufacturer;
        logWriter = new FileWriter("weapon_log.txt", true);
        logAction("Created weapon with specified parameters");
    }

    protected void logAction(String action) throws IOException {
        logWriter.write(action + "\n");
    }

    public void closeLog() throws IOException {
        if (logWriter != null) {
            logAction("Closing log file.");
            logWriter.close();
        }
    }

    public abstract void shoot() throws IOException;
    public abstract void reload(int newAmmo) throws IOException;

    public String getWeaponInfo() throws IOException {
        String info = "Weapon: " + weaponType.getName() + ", Ammo: " + ammunition.getType() + ", Manufacturer: " + manufacturer.getName();
        logAction("Fetched weapon info: " + info);
        return info;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Ammunition getAmmunition() {
        return ammunition;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}