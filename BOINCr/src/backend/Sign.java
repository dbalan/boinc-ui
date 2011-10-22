/**
 * 
 */
package backend;

/**
 * @author abil
 *
 */

import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;


class Sign {
	/**
	 * @param privkeyfile private key file PKCS8Encoded
	 * @param data String to be signed
	 * @return realSig Signature String  
	 */
    	public static String generate(String privkeyfile,String data){
    		try{

                /* Get key */
            	FileInputStream keyfis = new FileInputStream(privkeyfile);
                byte[] encKey = new byte[keyfis.available()];
                int len=encKey.length;
                System.err.print(len);
                keyfis.read(encKey);
                keyfis.close();
                PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(encKey);
             
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                RSAPrivateKey priv = (RSAPrivateKey) keyFactory.generatePrivate(privKeySpec);


                /* Create a Signature object and initialize it with the private key */

                Signature rsa = Signature.getInstance("SHA1withRSA"); 

                rsa.initSign(priv);

                /* Update and sign the data */

               rsa.update(data.getBytes(), 0, data.length());
      

                /* Generate a signature for msg */

                byte[] realSig = rsa.sign();

            
                /* return the signature*/          
                return realSig.toString();


            } catch (Exception e) {
                e.printStackTrace();return null;
            }
			

    	}
  

}



