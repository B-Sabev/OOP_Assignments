/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_icecream;

/**
 *
 * @author Borislav
 */
public class IcecreamTest {
    
    public Ice[] icecreams;
    
    public IcecreamTest(){
        icecreams = createIceCreams();
    }

    private Ice[] createIceCreams() {
        // fill icecreams here
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void showIcecreams(){
        for(Ice ice : icecreams){
            System.out.println(ice);
        }
    }
    
}
