import exception.ApplicationException;
import io.javalin.Javalin;
import model.EmployeePojo;
import service.EmployeeServiceImpl;

public class ExpenseCrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
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
        app.post("/changePass/{newPassword}", (ctx)->{
        	System.out.println("post rout");
        	
        	String newPassword = ctx.pathParam("newPassword");
        	
        	
        	
        	try {
        		EmployeePojo info =service.empUpdateInfo();
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
        //endpoint read a book
        
        //endpoint delete a book
        //endpoint post a book
        //enpoint put update a book
        
        
        
	}

}
