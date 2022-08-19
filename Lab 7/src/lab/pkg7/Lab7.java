package lab.pkg7;

/**
 *
 * @author jerrywang
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DynamicArray andrew = new DynamicArray();
        andrew.Add(1);
        andrew.Add(2);
        andrew.Add(1);
        andrew.Add(4);
        andrew.Add(69);
        andrew.Add(1);
        andrew.Add(2);
        andrew.Add(1);
        andrew.Add(4);
        andrew.Add(69);
        System.out.println(andrew.Length());
        for(int i = 0; i < andrew.Length(); i++){
            System.out.print(andrew.Get(i) + " ");
        }
        System.out.println();
        andrew.Remove(6);
        andrew.Remove(6);
        andrew.Remove(6);
        andrew.Remove(1);
        andrew.Remove(1);
        andrew.Remove(1);
        andrew.Remove(1);
        andrew.Remove(1);
        andrew.Remove(0);
        System.out.println(andrew.Length());
        for(int i = 0; i < andrew.Length(); i++){
            System.out.print(andrew.Get(i) + " ");
        }
        System.out.println();
        andrew.Add(1);
        andrew.Add(2);
        andrew.Add(1);
        andrew.Add(4);
        andrew.Add(69);
        andrew.Add(1);
        andrew.Add(2);
        andrew.Add(1);
        andrew.Add(4);
        andrew.Add(69);
        System.out.println(andrew.Length());
        for(int i = 0; i < andrew.Length(); i++){
            System.out.print(andrew.Get(i) + " ");
        }
        System.out.println();
        andrew.Remove();
        for(int i = 0; i < andrew.Length(); i++){
            System.out.print(andrew.Get(i) + " ");
        }
        System.out.println();
        
    }
}
