package dao.service;

import com.weirdo.util.Validator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class ValidatorTest {

    @Test
    public void testValidateUser() throws Exception {
        String result = Validator.ValidateInput(null,null);
        System.out.println(result);
    }

    @Test
    public void testValidateInput() throws Exception {

    }
}