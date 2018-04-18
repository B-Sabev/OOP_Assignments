/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * 
 * adapted from:
 * author Sjaak
 */
public class PolynomialTest {
    
    public PolynomialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Polynomial.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polynomial instance = new Polynomial("-1 4 1 3 2 2 -1 1");
        String expResult = "-x^4 + x^3 + 2,00x^2 + -1,00x";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial b = new Polynomial("5 5 4 4");
        Polynomial instance = new Polynomial("6 6 6 3 -2 2");
        instance.plus(b);
        Polynomial result =  new Polynomial("5 5 4 4 6 6 6 3 -2 2");
        assertEquals(result, instance);
        
        /// test additive identity
        Polynomial a = new Polynomial("8 5 8 5");
        Polynomial zero = new Polynomial("");
        a.plus(zero);
        assertEquals("additive identity", a, new Polynomial("8 5 8 5"));
    }
    
    @Test
    public void testPlusCommutative() {
        System.out.println("plusCommutative");
        Polynomial a = new Polynomial("1 2");
        Polynomial b = new Polynomial("2 1");
        a.plus(b);
        Polynomial a2 = new Polynomial("1 2");
        b.plus(a2);
        assertEquals(a, b);
    }
    
    @Test
    public void testPlusAssociative(){
        System.out.println("plusAssociative");
        Polynomial a1 = new Polynomial("3 3");
        Polynomial b1 = new Polynomial("2 2");
        Polynomial c1 = new Polynomial("3 3 -2 2");
        
        Polynomial a2 = new Polynomial("3 3");
        Polynomial b2 = new Polynomial("2 2");
        Polynomial c2 = new Polynomial("3 3 -2 2");
        a1.plus(b1);
        a1.plus(c1);
        
        b2.plus(c2);
        a2.plus(b2);
        
        assertEquals(a1, a2);
    }
    
    
    @Test
    public void testTimesCommutative() {
        System.out.println("plusCommutative");
        Polynomial a = new Polynomial("1 2");
        Polynomial b = new Polynomial("2 1");
        a.times(b);
        Polynomial a2 = new Polynomial("1 2");
        b.times(a2);
        assertEquals(a, b);
    }
    
    @Test
    public void testTimesAssociative(){
        System.out.println("plusAssociative");
        Polynomial a1 = new Polynomial("3 3");
        Polynomial b1 = new Polynomial("2 2");
        Polynomial c1 = new Polynomial("3 3 -2 2");
        
        Polynomial a2 = new Polynomial("3 3");
        Polynomial b2 = new Polynomial("2 2");
        Polynomial c2 = new Polynomial("3 3 -2 2");
        a1.times(b1);
        a1.times(c1);
        
        b2.times(c2);
        a2.times(b2);
        
        assertEquals(a1, a2);
    }
    
    @Test
    public void testDistributive(){
        System.out.println("distributive");
        Polynomial a1 = new Polynomial("3 3");
        Polynomial b1 = new Polynomial("2 2");
        Polynomial c1 = new Polynomial("3 3 -2 2");
        
        Polynomial a2 = new Polynomial("3 3");
        Polynomial a3 = new Polynomial("3 3");
        Polynomial b2 = new Polynomial("2 2");
        Polynomial c3 = new Polynomial("3 3 -2 2");
        b1.plus(c1);
        a1.times(b1);
        
        a2.times(b2);
        a3.times(c3);
        a2.plus(a3);
        
        assertEquals(a1, a2);
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial b = new Polynomial("2 2");
        Polynomial instance = new Polynomial("2 2");
        instance.minus(b);
        assertEquals("Substract 2 equal polynomials and check if it is emtpy", instance, new Polynomial());
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial b = new Polynomial("1 2");
        Polynomial instance = new Polynomial("1 2");
        instance.times(b);
        assertEquals("Check 1 term polynomial multiplication ", new Polynomial("1 4"),instance);
        
        b = new Polynomial("1 0 1 1");
        instance = new Polynomial("1 0 1 1");
        instance.times(b);
        assertEquals("Check polynomial multiplication", new Polynomial("1 0 2 1 1 2"),instance);
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other_poly = new String();
        Polynomial instance = new Polynomial();
        boolean expResult = false;
        boolean result = instance.equals(other_poly);
        assertEquals(expResult, result);
        
        other_poly = new Polynomial("1 2 2 1");
        instance = new Polynomial("1 2 2 1");
        expResult = true;
        result = instance.equals(other_poly);
        assertEquals("Test the same for equals", expResult, result);
        
    }
    //substraction is the same as multiplying by 􀀀1 and then addition
   
    @Test
    public void testAll() {
        System.out.println("all at once");
        Polynomial a1 = new Polynomial("1 2");
        Polynomial b1= new Polynomial("2 1");
        a1.minus(b1);
        
        Polynomial a2 = new Polynomial("1 2");
        Polynomial b2 = new Polynomial("2 1");
        b2.times(new Polynomial("-1 0"));
        a2.plus(b2);
        assertEquals("substraction is the same as multiplying by -1 and then addition", a1, a2);
    }
    
}
