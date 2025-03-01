package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage{
    
    String productTitle = "//span[@id='productTitle']";
    String productImage = "//div[@id='magnifierLens']";
    String imgLocator= "//*[@id=\"landingImage\"]";
    String thumbnails_selector = "//*[@id=\"altImages\"]";

    public ProductDetailPage() {
        super(driver);
    }

    public String productTitle() {
        return textFromElement(productTitle);
    }

    public boolean checkImage() {
        return imagenDisplayed(imgLocator);
    }

    public void validateThumbnails() {
        List<WebElement> thumbnails = bringMeAllElements(thumbnails_selector);
        
        for (WebElement thumbnail : thumbnails) {
            String thumbnailUrl = thumbnail.getDomAttribute("src");

            Assert.assertNotNull("La URL de la miniatura es nula.", thumbnailUrl);
            Assert.assertFalse("La URL de la miniatura está vacía.", thumbnailUrl.isEmpty());

            try {
                URL url = URI.create(thumbnailUrl).toURL();
                HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                httpConn.setRequestMethod("GET");
                httpConn.setConnectTimeout(5000);
                httpConn.connect();

                int responseCode = httpConn.getResponseCode();
                httpConn.disconnect();

                Assert.assertEquals(
                    "La miniatura está rota (código HTTP diferente de 200): " + thumbnailUrl,
                    200, responseCode
                );
            } catch (IOException e) {
                Assert.fail("Error al abrir la conexión con la URL de la miniatura: " 
                            + thumbnailUrl + " - Excepción: " + e.getMessage());
            }
        }
    }

}
