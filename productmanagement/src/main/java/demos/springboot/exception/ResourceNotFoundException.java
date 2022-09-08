package demos.springboot.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String resourceId;
	private int resourceIdValue;
	
	public ResourceNotFoundException() {
		super("ResourceNotFoundException occured");
	}

	public ResourceNotFoundException(String resourceName, String resourceId, int resourceIdValue) {
		super(resourceName+" with "+resourceId+" = "+ resourceIdValue+" Not found"); //Category with Id = 5 not found
		this.resourceName = resourceName;
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public int getResourceIdValue() {
		return resourceIdValue;
	}

	public void setResourceIdValue(int resourceIdValue) {
		this.resourceIdValue = resourceIdValue;
	}
	
	
	
	
	
	

}
