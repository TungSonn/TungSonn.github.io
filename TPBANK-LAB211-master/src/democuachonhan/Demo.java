package stackjava.com.internationalize;
import java.util.Locale;
import java.util.ResourceBundle;
public class Demo {
  public static void main(String[] args) {
    Locale localeEn = new Locale("en");
    ResourceBundle labels = ResourceBundle.getBundle("en", localeEn);
    System.out.println("Xin chào trong tiếng anh: "+labels.getString("ae"));
    
    Locale localeVi = new Locale("vi");
    labels = ResourceBundle.getBundle("vn", localeVi);
    System.out.println("Xin chào trong tiếng việt: "+labels.getString("ae"));
  }
}