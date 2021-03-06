package FileManagement;


import java.io.*;
import java.io.Serializable;

public class Config implements Serializable {


    //Initialization of config variables
    private Integer counter;

    //Main constructor
    public Config() {
        counter = 0;
    }

    //***Setters***
    public void setCounter(Integer counter) {
        this.counter = counter;
    }


    //***Getters***
    public Integer getCounter() {
        return counter;
    }



    //Writer
    public static void ConfigWriter(Config config){
        try {
            FileOutputStream fos = new FileOutputStream("config.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(config);
            oos.close();
            System.out.println("Writing Config in config.ser ...");
        }catch(IOException exception){exception.printStackTrace();}
    }

    //Reader
    public static Config ConfigReader () {
        Config config = new Config();
        try {
            FileInputStream fis = new FileInputStream("config.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            config = (Config)obj;
            ois.close();
            System.out.println("Reading Configuration from config.ser ...");
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Impossible to read configuration from config.ser ... ");
        }
        return config;
    }
    //toString method
    @Override
    public String toString() {
        return "\nConfig values ; \n" +
                "Counter : " + this.getCounter()+"\n";
    }
}

