

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Weapon {
	 File dataFile = new File("MyFile.txt");
     PrintWriter fout = new PrintWriter(dataFile);

    private WeaponType weaponType;
    private Ammunition ammunition;
    private Manufacturer manufacturer;
    private FileWriter logWriter;

    /**
     * Звичайний конструктор
     */
    public Weapon() throws IOException {
        this.weaponType = new WeaponType("Unknown", 0);
        this.ammunition = new Ammunition("None", 0);
        this.manufacturer = new Manufacturer("Unknown");
        logWriter = new FileWriter("weapon_log.txt", true);
        logAction("Created default weapon");
    }

    /**
     * Параметризований конструктор
     */
    public Weapon(WeaponType weaponType, Ammunition ammunition, Manufacturer manufacturer) throws IOException {
        this.weaponType = weaponType;
        this.ammunition = ammunition;
        this.manufacturer = manufacturer;
        logWriter = new FileWriter("weapon_log.txt", true);
        logAction("Created weapon with specified parameters");
    }

    /**
     * Журнал активності методу у файл.
     */
    private void logAction(String action) throws IOException {
        logWriter.write(action + "\n");
    }

    /**
     * Закрийтя файл журналу.
     */
    public void closeLog() throws IOException {
        if (logWriter != null) {
            logAction("Closing log file.");
            logWriter.close();
        }
    }

    // Різні методи, пов'язані зі зброєю:

    public String getWeaponInfo() throws IOException {
        String info = "Weapon: " + weaponType.getName() + ", Ammo: " + ammunition.getType() + ", Manufacturer: " + manufacturer.getName();
        logAction("Fetched weapon info: " + info);
        return info;
    }

    public void reload(int newAmmo) throws IOException {
        ammunition.setQuantity(newAmmo);
        logAction("Reloaded weapon with " + newAmmo + " rounds.");
    }

    public void shoot() throws IOException {
        if (ammunition.getQuantity() > 0) {
            ammunition.decreaseQuantity();
            logAction("Weapon fired.");
        } else {
            logAction("Weapon attempted to fire but was out of ammo.");
        }
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) throws IOException {
        this.weaponType = weaponType;
        logAction("Set new weapon type: " + weaponType.getName());
    }

    public Ammunition getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(Ammunition ammunition) throws IOException {
        this.ammunition = ammunition;
        logAction("Set new ammunition: " + ammunition.getType());
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) throws IOException {
        this.manufacturer = manufacturer;
        logAction("Set new manufacturer: " + manufacturer.getName());
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            closeLog();
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args) throws IOException {
        Weapon weapon = new Weapon();
        weapon.shoot();
        weapon.reload(5);
        weapon.shoot();
        System.out.println(weapon.getWeaponInfo());
        weapon.closeLog();
    }
}
