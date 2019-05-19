package domain.model;
import com.sun.org.apache.xpath.internal.operations.Mod;
import domain.model.ModelException;
public class Painting {

    private String painter;
    private String name;
    private int price;
    private String code;
    private int leeftijd;

    public Painting() {
    }

    public Painting(String painter, String name, int price, String code, int leeftijd) {
        setPainter(painter);
        setName(name);
        setPrice(price);
        setCode(code);
        setLeeftijd(leeftijd);
    }

    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter){
        if(painter == null || painter.trim().isEmpty())throw new ModelException("De naam van de schilder mag niet leeg zijn=.");
        this.painter = painter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty())throw new ModelException("De naam van het schilderij mag niet leeg zijn.");
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price <0 )throw new ModelException("Prijs kan niet negatief zijn.");
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if(code == null ||code.trim().isEmpty())throw new ModelException("Code Moet bestaan uit de Eerste 2 letters van ieder woord van de schilder en schilderij.");
        this.code = code;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        if(leeftijd<0)throw new ModelException("leeftijd kan niet negatief zijn.");
        this.leeftijd = leeftijd;
    }
}
