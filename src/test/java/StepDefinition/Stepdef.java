package StepDefinition;

import org.junit.Assert;
import cucumber.api.java.en.*;
import jupiter.cts.OracleConnector.OracleConnector;
import jupiter.cts.MySQLConector.MySqlConnector;

public class Stepdef {
	
	String parampath=System.getProperty("paramdir");
	
	@Given("^The target table \"([^\"]*)\" is loaded and verified by running \"([^\"]*)\"$")
	public void the_target_table_is_loaded_and_verified_by_running(String arg1, String arg2) throws Throwable  {
	    String sql=parampath+arg2;
	    String param=parampath+"JupiterParam";
		MySqlConnector con=new MySqlConnector();
	   int cnt=con.executeMySQL(sql,param);
	   if (cnt != 0){
		   System.out.println("Target Table "+arg1+" has been loaded");
		   System.out.println("TEST STEP SUCCESS");
	   }else{
		   System.out.println("TEST STEP FAILURE");
		   Assert.fail("Target Table "+arg1+" has not been loaded yet");
	   }
	}

	@Then("^The target table count \"([^\"]*)\" is \"([^\"]*)\" and verified by running \"([^\"]*)\"$")
	public void the_target_table_count_is_and_verified_by_running(String arg1, String arg2, String arg3) throws Throwable {
		 String sql=parampath+arg3;
		    String param=parampath+"JupiterParam";
		MySqlConnector con=new MySqlConnector();
		   int cnt=con.executeMySQL(sql,param);
		   if (cnt == Integer.parseInt(arg2)){
			   System.out.println("Target Table "+arg1+" has been loaded with "+arg2+" records");
			   System.out.println("TEST STEP SUCCESS");
		   }else{
			   System.out.println("TEST STEP FAILURE");
			   Assert.fail("Target Table "+arg1+" has not been loaded with "+arg2+" records");
		   }
	}

	@Then("^No records for the column \"([^\"]*)\" should be NULL when running \"([^\"]*)\"$")
	public void no_records_for_the_column_should_be_NULL_when_running(String arg1, String arg2) throws Throwable {
		String sql=parampath+arg2;
	    String param=parampath+"JupiterParam";
		MySqlConnector con=new MySqlConnector();
	   int cnt=con.executeMySQL(sql,param);
		   if (cnt == 0){
			   System.out.println("Column "+arg1+" has no NULL values");
			   System.out.println("TEST STEP SUCCESS");
		   }else{
			   System.out.println("TEST STEP FAILURE");
			   Assert.fail("Column "+arg1+" has NULL Values"); 
			   
		   }
	}
}
