package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Customer;
import testDataTypes.ProductDetails;

public class JsonDataReader {
	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Customer.json";
	private final String productDetailsFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "ProductDetails.json";
	private List<Customer> customerList;
	private List<ProductDetails> productDetailsList;

	public JsonDataReader(){
		customerList = getCustomerData();
		productDetailsList = getProductDetailsData();
	}

	private List<Customer> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
			return Arrays.asList(customers);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
	
	private List<ProductDetails> getProductDetailsData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(productDetailsFilePath));
			ProductDetails [] proDetails = gson.fromJson(bufferReader, ProductDetails [].class);
			return Arrays.asList(proDetails);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + productDetailsFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}

	public final Customer getCustomerByName(String customerName){
		return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}
	
	public final ProductDetails getProductByName(String productName){
		return productDetailsList.stream().filter(x -> x.productName.equalsIgnoreCase(productName)).findAny().get();
	}
}