package lesson26_serializable._04_externalizable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Base64;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExtFile implements Externalizable {
    String firstName;
    String lastName;
    String password;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(firstName);
        out.writeObject(lastName);
        out.writeObject(encryptString(password));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firstName = (String) in.readObject();
        lastName = (String) in.readObject();
        password = decryptString((String) in.readObject());
    }

    private String encryptString(String password) {
        var encryptedString = Base64.getEncoder().encodeToString(password.getBytes());
        System.out.println(encryptedString);
        return encryptedString;
    }

    private String decryptString(String password) {
        var decryptedString = new String(Base64.getDecoder().decode(password));
        System.out.println(decryptedString);
        return decryptedString;
    }
}
