package mother;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import java.math.BigDecimal;
import java.util.Set;

public class ProductMother {

  public static Product aBlueJacket() {
    return new Product(1L,
        "Jaqueta de frio azul",
        "Jaqueta",
        "Slug",
        "Brand",
        new BigDecimal("139"),
        new BigDecimal("29"),
        Color.BLUE,
        123,
        "Image",
        Set.of(Size.LARGE));
  }

  public static Product aWhiteTShirt() {
    return new Product(
        2L,
        "Camiseta Branca",
        "Camiseta de calor",
        "Slug",
        "Brand",
        new BigDecimal("139"),
        new BigDecimal("29"),
        Color.WHITE,
        123,
        "Image",
        Set.of(Size.SMALL));
  }


  public static Product aCheapTankTop() {
    return new Product(14040174L,
        "Regata Infantil Mario Bros",
        "A Regata Infantil Mario Bros é confeccionada em fibra natural, possui decote redondo e modelagem regular. As peças temáticas com os personagens preferidos da criançada são indispensáveis no guarda-roupa. Divertidas e cheias de personalidade, os modelos são uma forma dos pequenos se expressarem em relação aos seus gostos pessoais, que já começam desde cedo. Aposte!",
        "regata-infantil-mario-bros-14040174_sku",
        "Nintendo",
        new BigDecimal("29.90"),
        null,
        Color.GRAY,
        98,
        "https://static.riachuelo.com.br/RCHLO/14040174004/portrait/f10a3e016dd974dbdc7dfaefa41a47599557a58a.jpg",
        Set.of(Size.SMALL, Size.MEDIUM, Size.LARGE));
  }

}
