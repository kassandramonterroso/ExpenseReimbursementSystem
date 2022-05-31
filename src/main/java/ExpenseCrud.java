import io.javalin.Javalin;
import service.EmployeeServiceImpl;

public class ExpenseCrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		//create service object to call
		EmployeeServiceImpl service = new EmployeeServiceImpl(); 
		Javalin app = Javalin.create((config) -> config.enableCorsForAllOrigins());
		app.start(8080);
        app.get("/", (ctx) ->{
        	System.out.println("/ route hit");
        	ctx.result("Hello World");
        	});
        //can access this endpoint through postman
        
        
        
        //lets create other endpoints
        
        //CRUD 
        //read all books
        // /books
        app.post("/login", (ctx)->{
        	System.out.println("post rout");
        	String username = ctx.formParam("username");
        	String password = ctx.formParam("password");
        	System.out.println(username + password);
        	System.out.println(service.login(username, password));
        	//here we contact service service contacts dao and returns all books
        	//List<BookPojo> allBooks = service.getAllBooks();
//        	ctx.json(allBooks);
        	ctx.result("post Sucess");
        });
        
        //endpoint read a book
        
        //endpoint delete a book
        //endpoint post a book
        //enpoint put update a book
        
        
        
	}

}
