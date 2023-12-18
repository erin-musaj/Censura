import java.util.Locale;

public class Main {

    public static String censura(String s, String[] cancel_culture){
        int c[]=new int[cancel_culture.length];
        int count = 0;
        for(String p: cancel_culture) {
            String cmp = s.toLowerCase();
            int offset = 0;
            String censura = "";
            p = p.toLowerCase();
            for(int i = 0; i<p.length(); i++){
                censura += "*";
            }
            while(cmp.indexOf(p.toLowerCase(), offset+p.length()-1) != -1){
                c[count]++;
                offset = cmp.indexOf(p.toLowerCase());
                s = s.substring(0, offset) + censura + s.substring(offset+p.length());
                cmp = s.toLowerCase();
            }
            count++;
        }

        s+="\n";

        for (int i = 0; i < c.length; i++) {
            s+="\nparola: " + cancel_culture[i] + "\noccorenze: " + c[i] + "\nlunghezza parola: " + cancel_culture[i].length();
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(censura("Ciao Furly ciaone sei un furlan ciaone si", new String[]{"Furly", "ciaone"}));
    }
}