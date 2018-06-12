package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;

public class Generate implements Initializable {
    @FXML
    private TextField nameS;
    @FXML
    private TextField nipS;
    @FXML
    private TextField addressS;
    @FXML
    private TextField mailS;
    @FXML
    private TextField nameN;
    @FXML
    private TextField nipN;
    @FXML
    private TextField addressN;
    @FXML
    private TextField mailN;
    @FXML
    private TextField prod1;
    @FXML
    private TextField prod2;
    @FXML
    private TextField prod3;
    @FXML
    private TextField prod4;
    @FXML
    private TextField prod5;
    @FXML
    private TextField il1;
    @FXML
    private TextField il2;
    @FXML
    private TextField il3;
    @FXML
    private TextField il4;
    @FXML
    private TextField il5;
    @FXML
    private TextField c1;
    @FXML
    private TextField c2;
    @FXML
    private TextField c3;
    @FXML
    private TextField c4;
    @FXML
    private  TextField c5;
    @FXML
    private TextField v1;
    @FXML
    private  TextField v2;
    @FXML
    private TextField v3;
    @FXML
    private TextField v4;
    @FXML
    private TextField v5;

    class Product{
        String name;
        String il;
        String c;
        String v;
        String amount;
        String priceVat;
        String totalPrice;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nipS.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        il1.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        il2.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        il3.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        il4.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        il5.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        v1.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(2));
        v2.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(2));
        v3.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(2));
        v4.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(2));
        v5.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(2));
    }

    public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if(e.getCharacter().matches("[0-9.]")){
                    if(txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")){
                        e.consume();
                    }else if(txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")){
                        e.consume();
                    }
                }else{
                    e.consume();
                }
            }
        };
    }

    @FXML
    public void generateHtml(ActionEvent event) throws DocumentException, IOException{

        File htmlF = readTemplate(prod1, prod2, prod3, prod4, prod5);
        String htmlString = FileUtils.readFileToString(htmlF);
        String nameSText = nameS.getText();
        String nipSText = nipS.getText();
        String addressSText = addressS.getText();
        String mailSText = mailS.getText();
        String nameNText = nameN.getText();
        String nipNText = nipN.getText();
        String addressNText = addressN.getText();
        String mailNText = mailN.getText();


        htmlString = htmlString.replace("$nameS", nameSText);
        htmlString = htmlString.replace("$nipS", nipSText);
        htmlString = htmlString.replace("$addressS", addressSText);
        htmlString = htmlString.replace("$mailS", mailSText);
        htmlString = htmlString.replace("$nameN", nameNText);
        htmlString = htmlString.replace("$nipN", nipNText);
        htmlString = htmlString.replace("$addressN", addressNText);
        htmlString = htmlString.replace("$mailN", mailNText);


        if (!prod5.getText().isEmpty()) {
            Product product1 = findProduct(prod1,il1,c1,v1);
            htmlString = htmlString.replace("$product1", product1.name);
            htmlString = htmlString.replace("$amount1", product1.il);
            htmlString = htmlString.replace("$jm1", mailNText);
            htmlString = htmlString.replace("$netto1", product1.c);
            htmlString = htmlString.replace("$amNetto1", product1.amount);
            htmlString = htmlString.replace("$pV1", product1.v);
            htmlString = htmlString.replace("$priceVAT1", product1.priceVat);
            htmlString = htmlString.replace("$total1", product1.totalPrice);
        }
       
        if (!prod2.getText().isEmpty()) {
            Product product2 = findProduct(prod2, il2, c2, v2);
            htmlString = htmlString.replace("$product2", product2.name);
            htmlString = htmlString.replace("$amount2", product2.il);
            htmlString = htmlString.replace("$jm2", mailNText);
            htmlString = htmlString.replace("$netto2", product2.c);
            htmlString = htmlString.replace("$amNetto2", product2.amount);
            htmlString = htmlString.replace("$pV2", product2.v);
            htmlString = htmlString.replace("$priceVAT2", product2.priceVat);
            htmlString = htmlString.replace("$total2", product2.totalPrice);
        }

        if (!prod3.getText().isEmpty()) {
            Product product3 = findProduct(prod3, il3, c3, v3);
            htmlString = htmlString.replace("$product3", product3.name);
            htmlString = htmlString.replace("$amount3", product3.il);
            htmlString = htmlString.replace("$jm3", mailNText);
            htmlString = htmlString.replace("$netto3", product3.c);
            htmlString = htmlString.replace("$amNetto3", product3.amount);
            htmlString = htmlString.replace("$pV3", product3.v);
            htmlString = htmlString.replace("$priceVAT3", product3.priceVat);
            htmlString = htmlString.replace("$total3", product3.totalPrice);
        }

        if (!prod4.getText().isEmpty()) {
            Product product4 = findProduct(prod4, il4, c4, v4);
            htmlString = htmlString.replace("$product4", product4.name);
            htmlString = htmlString.replace("$amount4", product4.il);
            htmlString = htmlString.replace("$jm4", mailNText);
            htmlString = htmlString.replace("$netto4", product4.c);
            htmlString = htmlString.replace("$amNetto4", product4.amount);
            htmlString = htmlString.replace("$pV4", product4.v);
            htmlString = htmlString.replace("$priceVAT4", product4.priceVat);
            htmlString = htmlString.replace("$total4", product4.totalPrice);
        }

        if (!prod5.getText().isEmpty()) {
            Product product5 = findProduct(prod5, il5, c5, v5);
            htmlString = htmlString.replace("$product5", product5.name);
            htmlString = htmlString.replace("$amount5", product5.il);
            htmlString = htmlString.replace("$jm5", mailNText);
            htmlString = htmlString.replace("$netto5", product5.c);
            htmlString = htmlString.replace("$amNetto5", product5.amount);
            htmlString = htmlString.replace("$pV5", product5.v);
            htmlString = htmlString.replace("$priceVAT5", product5.priceVat);
            htmlString = htmlString.replace("$total5", product5.totalPrice);
        }

        File newHtmlFile = new File("C:/Users/Eliza/Documents/Faktury/szablon/szablon1.html");
        FileUtils.writeStringToFile(newHtmlFile, htmlString);

        ByteArrayInputStream html = new ByteArrayInputStream(FileUtils.readFileToByteArray(new File("C:/Users/Eliza/Documents/Faktury/szablon/szablon1.html")));
        ByteArrayInputStream css = new ByteArrayInputStream(FileUtils.readFileToByteArray(new File("C:/Users/Eliza/Documents/Faktury/szablon/style.css")));

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf1.pdf"));
        writer.setInitialLeading(12);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, html, css);
        document.close();

    }

    public File readTemplate(TextField p1, TextField p2, TextField p3, TextField p4, TextField p5){
        if (p2.getText().isEmpty()){
            File htmlF = new File("C:/Users/Eliza/Documents/Faktury/szablon/szablon_na1.html");
            return htmlF;
        }
        else if (p3.getText().isEmpty())
        {
            File htmlF = new File("C:/Users/Eliza/Documents/Faktury/szablon/szablon_na2.html");
            return htmlF;
        }
        else if (p4.getText().isEmpty())
        {
            File htmlF = new File("C:/Users/Eliza/Documents/Faktury/szablon/szablon_na3.html");
            return htmlF;
        }
        else if (p5.getText().isEmpty()){
            File htmlF = new File("C:/Users/Eliza/Documents/Faktury/szablon/szablon_na4.html");
            return htmlF;
        }
        else {
            File htmlF = new File("C:/Users/Eliza/Documents/Faktury/szablon/szablon.html");
            return htmlF;
        }
    }

    public int getInt(String test){
        try{
            return Integer.parseInt(test.trim());
        }catch(Exception e){
            return 0;
        }
    }

    public void backStart(ActionEvent event) throws IOException {
        Parent fParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene fScene = new Scene(fParent, 650, 600);
        Stage appStage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(fScene);
        appStage.show();
    }

    public Product findProduct(TextField prod, TextField il, TextField c, TextField v){
        String prodText = prod.getText();
        String ilText = il.getText();
        Integer il1 = getInt(ilText);
        String cText = c.getText();
        Float c1Number = Float.parseFloat(cText);
        String vText = v.getText();
        BigDecimal vDec = new BigDecimal(vText);

        Integer v1 = getInt(vText);
        Float amount1 = c1Number*il1;
        Float Vat1 = (float)v1/100;
        Float priceVat1 = Vat1 * amount1;
        Float total1 = amount1 + priceVat1;

        BigDecimal totalDec = new BigDecimal(Float.toString(total1));
        BigDecimal amountDec= new BigDecimal(Float.toString(amount1));
        BigDecimal priceVatDec = new BigDecimal(Float.toString(priceVat1));

        String amountText = amountDec.setScale(2,RoundingMode.HALF_UP).toString();
        String priceVatText = priceVatDec.setScale(2,RoundingMode.HALF_UP).toString();
        String totalText = totalDec.setScale(2, RoundingMode.HALF_UP).toString();
        String vDecText = vDec.setScale(2,RoundingMode.HALF_UP).toString();

        Product product = new Product();
        product.name = prodText;
        product.c = cText;
        product.il = ilText;
        product.v = vDecText;
        product.amount = amountText;
        product.priceVat = priceVatText;
        product.totalPrice = totalText;

        return product;
    }

}

