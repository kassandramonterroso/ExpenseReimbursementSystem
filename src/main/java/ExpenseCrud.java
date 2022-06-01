
import java.util.List;

import io.javalin.Javalin;
import service.EmployeeService;
import model.EmployeePojo;
import model.ReimbursementPojo;

import exception.ApplicationException;
import io.javalin.Javalin;
import model.EmployeePojo;

import service.EmployeeServiceImpl;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

public class ExpenseCrud {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		ReimbursementService reimbursementService = new ReimbursementServiceImpl();

		//create service object to call
		EmployeeServiceImpl service = new EmployeeServiceImpl(); 
		Javalin app = Javalin.create((config) -> config.enableCorsForAllOrigins());
		app.start(8082);
        app.get("/", (ctx) ->{
        	System.out.println("/ route hit");
        	ctx.result("Hello World");
        	});
        //can access this endpoint through postman
        
        
        
        //lets create other endpoints
        
        //CRUD 

        // login
        app.post("/login", (ctx)->{

        //read all books
        // /books
        app.post("/login/{username}/{password}", (ctx)->{

        	System.out.println("post rout");
        	
        	String username = ctx.pathParam("username");
        	String password = ctx.pathParam("password");
        	
        	
        	try {
        		EmployeePojo info =service.login(username, password);
            	//here we contact service service contacts dao and returns all books
            	//List<BookPojo> allBooks = service.getAllBooks();
//            	ctx.json(allBooks);
        		if (info == null) {
        			throw new ApplicationException("invalid username or password");
        		}
            	ctx.json(info);
            	
        	} catch(ApplicationException e) {
        		
        		ctx.json(e);
        	}
        	
        });
        
        //endpoint manager can view all employees
        
        app.get("/employees",(ctx)->{
        	System.out.println("All Employees details");
        	List<EmployeePojo> allEmployees = employeeService.manViewAll(); 
        	ctx.json(allEmployees);
        });  
        
        //endpoint manager can view specific employee manViewRequest
        app.get("/employees",(ctx)->{
        	System.out.println("Specific Employees details");
        	// here we retrieve the eId from the path/url
        	String empId = ctx.pathParam("eId");
        	// convert String to int
        	int empIdInteger = Integer.parseInt(empId);
        	ReimbursementPojo specificEmployee = reimbursementService.manViewRequest(empIdInteger); 
        	ctx.json(specificEmployee);
        });   
        
        //endpoint employee can view his details empViewInfo
        app.get("/employees",(ctx)->{
        	System.out.println("Employee own details");
        	// here we retrieve the eId from the path/url
        	String empId = ctx.pathParam("eId");
        				
        	// convert String to int
        	int empIdInteger = Integer.parseInt(empId);
        	EmployeePojo employeeInfo = employeeService.empViewInfo(empIdInteger); 
        	ctx.json(employeeInfo);
        });   
        

        //endpoint put employee can update his details
        app.put("/employees",(ctx)->{
        	System.out.println("Employee update details");
        	// here we retrieve the eId from the path/url
        	String empId = ctx.pathParam("eId");
        				
        	// convert String to int
        	int empIdInteger = Integer.parseInt(empId);
        	EmployeePojo employeeInfo = employeeService.empViewInfo(empIdInteger); 
        	ctx.json(employeeInfo);
        });   
        
        //enpoint put update a book
        
        
        
	}

}
