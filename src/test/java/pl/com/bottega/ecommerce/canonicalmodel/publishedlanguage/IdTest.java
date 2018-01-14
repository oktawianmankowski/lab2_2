package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage;

import org.junit.Test;

/**
 * Created by Lukasz on 2018-01-14.
 */
public class IdTest {

    @Test(expected = NullPointerException.class)
    public void attemptCreateIdWithNullParameterThrowNullPointerException(){
        String id = null;
        new Id(id);
    }


}