package Task2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {

        Person[]  people = {new Person(1,"Vaflya"),
                new Person(2,"Poker"), new Person(3, "Durik")};
        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos );

            oos.writeInt(people.length);

            for (Person person : people){
             oos.writeObject(person);
            }

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

