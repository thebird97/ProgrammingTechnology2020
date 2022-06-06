package demo1.localizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Localizer {
    
    private Map<String, String> messages = new HashMap<>();

    /*
     * Use runtime exceptions to indicate programming errors. The great majority 
     * of runtime exceptions indicate precondition violations. A precondition 
     * violation is simply a failure by the client of an API to adhere to the 
     * contract established by the API specification. For example, in our case
     * the contract for the localizer class that the provided resource file must
     * exists and it must contain exactly one value for any requested string.
     */
    
    /**
     * @param path 
     */
    public Localizer(String path) {
        try {
            parse(path);
        } catch (Exception ex) {
            throw new RuntimeException("cannot create localizer with the given file: " + path, ex);
        }
    }

    private void parse(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));
        while(sc.hasNextLine()) {
            parseLine(sc.nextLine());
        }
    }

    private void parseLine(String nextLine) {
        Scanner sc = new Scanner(nextLine);
        sc.useDelimiter("\\s*:\\s*");
        String key = sc.next();
        String value = sc.next();
        if(messages.containsKey(key)) {
            throw new RuntimeException("duplicate entry for key: " + key);
        }
        messages.put(key, value);
    }
    
    public String getString(String key) {
        if(!messages.containsKey(key)) {
            throw new RuntimeException("key not found in this localizer: " + key);
        }
        return messages.get(key);
    }

    public String getString(String key, Object... args) {
        String str = getString(key);
        MessageFormat format = new MessageFormat(str);
        return format.format(args);
    }
}
